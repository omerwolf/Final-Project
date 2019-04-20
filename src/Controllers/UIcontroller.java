package Controllers;

import DB.Dao.*;
import DB.DaoImpl.*;
import DB.Entites.*;
import Model.UserInput;




import javafx.scene.control.Button;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;


import java.awt.*;
import java.net.URL;

import java.time.Year;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.List;

import DB.Dao.variety_typeDao;
import DB.DaoImpl.variety_typeDaoImpl;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import DB.Dao.CropDao;
import DB.DaoImpl.CropDaoImpl;

import DB.Dao.crop_expected_yield_validationDao;
import DB.DaoImpl.crop_expected_yield_validationDaoImpl;
import javafx.scene.input.MouseEvent;


public class UIcontroller implements Initializable{

    private ObservableList oList = FXCollections.observableArrayList();
    private Crop selectedCrop = null;
    private variety_type selectedVarType = null;
    private Soil selectedSoil = null;
    private Double selectedexpectedYield = null;
    private Double selectedpreviousCropNCredit = null;
    private IrrigationMethod selectedIrrigationMethod = null;
    private Double selectedIrrigationVolume = null;
    private fertilization_method selectedFertilizationMethod = null;
    private Boolean selectedBaseDressing = null;
    private Double selectedSoilPH = null;

    private UserInput ui;


    @FXML
    private ChoiceBox<String> cropTypesCB;
    @FXML
    private ChoiceBox<String> varTypesCB;
    @FXML
    private ChoiceBox<String> soilTypesCB;
    @FXML
    private ChoiceBox<String> irrigationMethodCB;
    @FXML
    private ChoiceBox<String> fertilizationMethodCB;
    @FXML
    private ChoiceBox<String> baseDressingCB;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField instructionsTF;
    @FXML
    private TextField expectedYieldTF;
    @FXML
    private TextField previousCropNCreditTF;
    @FXML
    private TextField irrigationVolumeTF;
    @FXML
    private TextField soilPHTF;

    @FXML
    private Button submitB;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();

    }



    private void loadData()  {

        this.loadCropType();



            }
    private void submit(){
        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                 ui = new UserInput(selectedCrop,selectedVarType,selectedSoil,selectedexpectedYield,
                        selectedpreviousCropNCredit,selectedIrrigationMethod,selectedIrrigationVolume,
                        selectedFertilizationMethod,selectedBaseDressing,selectedSoilPH);
                instructionsTF.setText("Thank you !");
                int i = 5;

            }
        };
        submitB.setOnAction(event);
    }




    private void loadCropType() {
        this.oList.removeAll(oList);
        //Pull the cropTypes from DB
        instructionsTF.setText("Please select Crop type");
        List<Crop> cropTypes = this.getCropTypes();
        for (Crop ct : cropTypes) {
            oList.add(ct.getName());
        }
        cropTypesCB.getItems().addAll(oList);

        // add a listener
        this.cropTypesCB.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                int choosenIndex = new_value.intValue();
                selectedCrop = new Crop(cropTypes.get(choosenIndex));
                loadVarType();
                instructionsTF.setText("Please select Variety type");
            }
        });
    }

    private void loadVarType() {
        this.oList.removeAll(oList);
        //Pull the varietyTypes according the crop type selected from DB
        List<variety_type> matchVarTypeId = this.getVarietyTypes();
        for (variety_type vt : matchVarTypeId) {
            oList.add(vt.getVariety_name());
        }
        varTypesCB.getItems().addAll(oList);

        // add a listener
        this.varTypesCB.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value) {

                int choosenIndex = new_value.intValue();
                selectedVarType = new variety_type(matchVarTypeId.get(choosenIndex));
                instructionsTF.setText("Please select expected yield");
                loadExpectedYield();
            }
        });
    }



    private void loadExpectedYield() {
        int varTypeId = this.selectedVarType.getVariety_id();
        double minRange = -1;
        double maxRange = -1;

        crop_expected_yield_validationDao ceyv = new crop_expected_yield_validationDaoImpl();
        List<crop_expected_yield_validation> expYieldList = ceyv.selectAll();
        for (crop_expected_yield_validation c : expYieldList) {
            if (c.getVariety_id() == varTypeId) {
                minRange = c.getMin_yield();
                maxRange = c.getMax_yield();
                break;
            }
        }
        this.instructionsTF.setText("Please select expected yield value between " + minRange + " to " + maxRange);
        final double fMaxRange = maxRange;
        final double fMinRange = minRange;
        // add a listener
        this.expectedYieldTF.textProperty().addListener((ov,value,new_value) -> {
                String choosenVal = new_value;
                try {
                    selectedexpectedYield = Double.parseDouble(choosenVal);
                    if (selectedexpectedYield >= fMinRange && selectedexpectedYield <= fMaxRange) {
                        instructionsTF.setText("Please select Soil type");
                        loadSoilType();
                    }
                    else {
                        this.instructionsTF.setText("Please select expected yield value between " + fMinRange + " to " + fMaxRange);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    this.instructionsTF.setText("Please enter only numbers!");
                } finally {

                }


        });

    }

    private void loadSoilType() {
        this.oList.removeAll(oList);
        //Pull the cropTypes from DB
        List<Soil> soilTypes = this.getSoilTypes();
        for (Soil soil : soilTypes) {
            oList.add(soil.getName());
        }
        soilTypesCB.getItems().addAll(oList);

        // add a listener
        this.soilTypesCB.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                int choosenIndex = new_value.intValue();
                selectedSoil = new Soil(soilTypes.get(choosenIndex));
                instructionsTF.setText("Please enter previous crop N credit, if none please enter 0");
                loadPreviousCropNCredit();
            }
        });
    }

    private void loadPreviousCropNCredit() {
        loadIrrigationMethod();
        // add a listener
        this.previousCropNCreditTF.textProperty().addListener((ov,value,new_value) -> {
            String choosenVal = new_value;
            try {
                selectedpreviousCropNCredit = Double.parseDouble(choosenVal);
                if (selectedpreviousCropNCredit >= 0) {
                    instructionsTF.setText("Please select irrigation method ");

                }
                else {
                    this.instructionsTF.setText("Please enter previous crop N credit, if none please enter 0");
                }

            } catch (Exception e) {
                e.printStackTrace();
                this.instructionsTF.setText("Please enter only numbers!");
            }
        });
    }



    private void loadIrrigationMethod() {
        this.oList.removeAll(oList);
        //Pull the cropTypes from DB
        List<IrrigationMethod> irrigationMethods = this.getIrrigationMethod();
        for (IrrigationMethod method : irrigationMethods) {
            oList.add(method.getIrrigation_method_desc());
        }
        irrigationMethodCB.getItems().addAll(oList);

        // add a listener
        this.irrigationMethodCB.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                int choosenIndex = new_value.intValue();
                selectedIrrigationMethod = new IrrigationMethod(irrigationMethods.get(choosenIndex));
                instructionsTF.setText("Please enter irrigation volume(mm/season)");
                loadIrrigationVolume();
            }
        });
    }

    private void loadIrrigationVolume() {
        loadFertilizationMethod();
        // add a listener
        this.irrigationVolumeTF.textProperty().addListener((ov,value,new_value) -> {
            String choosenVal = new_value;
            try {
                selectedIrrigationVolume = Double.parseDouble(choosenVal);
                if (selectedIrrigationVolume >= 0) {
                    instructionsTF.setText("Please select fertilization method ");

                }
                else {
                    this.instructionsTF.setText("Please enter only positive numbers!");
                }

            } catch (Exception e) {
                e.printStackTrace();
                this.instructionsTF.setText("Please enter only numbers!");
            }
        });
    }

    private void loadFertilizationMethod() {
        this.oList.removeAll(oList);
        //Pull the FertilizationMethod from DB
        List<fertilization_method> fertilizationMethods = this.getFertilizationMethod();
        for (fertilization_method method : fertilizationMethods) {
            oList.add(method.getFert_method_desc());
        }
        fertilizationMethodCB.getItems().addAll(oList);

        // add a listener
        this.fertilizationMethodCB.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                int choosenIndex = new_value.intValue();
                selectedFertilizationMethod= new fertilization_method(fertilizationMethods.get(choosenIndex));
                instructionsTF.setText("Please select base dressing option");
                loadBaseDressing();
            }
        });
    }
    private void loadBaseDressing(){
        this.oList.removeAll(oList);
        oList.add("Yes");
        oList.add("No");
        baseDressingCB.getItems().addAll(oList);
        // add a listener
        this.baseDressingCB.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                String choosen = new_value.toString();
                if (choosen.equals("Yes")) {
                    selectedBaseDressing = Boolean.TRUE;
                } else {
                    selectedBaseDressing = Boolean.FALSE;
                }

                instructionsTF.setText("Please enter soil PH between 0.00 to 14.00");
                loadSoilPH();
            }
        });
    }
    private void loadSoilPH(){
        // add a listener
        this.soilPHTF.textProperty().addListener((ov,value,new_value) -> {
            String choosenVal = new_value;
            try {
                selectedSoilPH = Double.parseDouble(choosenVal);
                if (selectedSoilPH >= 0 && selectedSoilPH <= 14) {
                    instructionsTF.setText("Please submit ");
                    submit();

                }
                else {
                    this.instructionsTF.setText("Please enter only positive numbers!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.instructionsTF.setText("Please enter only numbers!");
            }
        });
    }

    private List<Crop> getCropTypes() {
        CropDao cd = new CropDaoImpl();
        List<Crop> cropTypes = cd.selectAll();
        return cropTypes;
    }

    private List<variety_type> getVarietyTypes() {
        int selectedCropId = this.selectedCrop.getId();
        crop_expected_yield_validationDao ceyv = new crop_expected_yield_validationDaoImpl();
        List<Integer> matchVarTypeId = ceyv.getMatchVarType(selectedCropId);

        variety_typeDao varTypeDao = new variety_typeDaoImpl();
        List<variety_type> matchVarType = new ArrayList<>();
        for (int id : matchVarTypeId) {
            variety_type vt = varTypeDao.selectById(id);
            matchVarType.add(vt);
        }

        return matchVarType;
    }

    private List<Soil> getSoilTypes() {
        SoilDao sd = new SoilDaoImpl();
        List<Soil> soilTypes = sd.selectAll();
        return soilTypes;
    }
    private List<IrrigationMethod> getIrrigationMethod() {
        IrrigationMethodDao imd = new IrrigationMethodDaoImpl();
        List<IrrigationMethod> irrigationMethods = imd.selectAll();
        return irrigationMethods;
    }
    private List<fertilization_method> getFertilizationMethod() {
        fertilization_methodDao fm = new fertilization_methodDaoImpl();
        List<fertilization_method> fertilizationMethods= fm.selectAll();
        return fertilizationMethods;

    }



}

