import DB.Dao.CropDao;
import DB.Dao.SoilDao;
import DB.DaoImpl.CropDaoImpl;
import DB.DaoImpl.SoilDaoImpl;
import DB.Entites.Crop;
import DB.Entites.Soil;
import DB.Util.ConnectionConfiguration;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //CropDao cdi = new CropDaoImpl();
        /**Insert a new record**/
        //Crop crop = new Crop("Tomato",cdi.generateUniqueId());
        //cdi.insert(crop);
        /**Select by id**/
        //Crop crop = cdi.selectById(6);
        //System.out.println(crop.getId() + ", " + crop.getName());

        /**Delete by id**/
        //cdi.delete(13);

        /**Update **/
        //Crop cropUpdate = new Crop("BBB",2);
        //cdi.update(cropUpdate,2);

        /**Select all**/
        //List<Crop> crops = cdi.selectAll();
        //for (Crop c : crops) {
        //    System.out.println(c.getId() + ", " + c.getName());
        // }
        /**Insert all**/
        //cdi.autoInsertAll();


        SoilDao sdi = new SoilDaoImpl();
        //sdi.autoInsertAll();
        List<Soil> soils = sdi.selectAll();
        int i =0;
    }
    }