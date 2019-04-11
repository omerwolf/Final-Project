package DB;

import DB.Dao.CropDao;
import DB.Dao.SoilDao;
import DB.Dao.data_typesDao;
import DB.Dao.variety_typeDao;
import DB.Dao.pheonological_stageDao;
import DB.Dao.parameter_cropDao;
import DB.DaoImpl.CropDaoImpl;
import DB.DaoImpl.SoilDaoImpl;
import DB.DaoImpl.data_typesDaoImpl;
import DB.DaoImpl.variety_typeDaoImpl;
import DB.DaoImpl.pheonological_stageDaoImpl;
import DB.DaoImpl.parameter_cropDaoImpl;
import DB.Entites.Crop;
import DB.Entites.Soil;
import DB.Entites.data_types;
import DB.Entites.variety_type;
import DB.Entites.pheonological_stage;
import DB.Entites.parameter_crop;
import DB.Util.ConnectionConfiguration;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //data_typesDao cdi = new data_typesDaoImpl();
        //CropDao cdi = new CropDaoImpl();
        /**Insert a new record**/
        //Crop crop = new Crop(cdi.generateUniqueId(), "aaaaaaa");
        //cdi.insert(crop);
        /**Select by id**/
        //Crop crop = cdi.selectById(7);
        //System.out.println(crop.getId() + ", " + crop.getName());

        /**Delete by id**/
        //cdi.delete(1);
        //cdi.delete(2);
        //cdi.delete(3);
        //cdi.delete(4);
        //cdi.delete(5);
        //cdi.delete(6);
        /**Update **/
        //Crop cropUpdate = new Crop("BBB",2);
        //cdi.update(cropUpdate,2);


        /**Insert all**/
        //cdi.autoInsertAll();
        /**Select all**/
        /**List<Crop> crops = cdi.selectAll();
        for (Crop c : crops) {
            System.out.println(c.getId() + ", " + c.getName());
        }*/

        //SoilDao sdi = new SoilDaoImpl();
        //sdi.autoInsertAll();
        //List<Soil> soils = sdi.selectAll();
        //Soil soil = sdi.selectById(1);
        //sdi.update(soil,1);
        //sdi.delete(1);
        //sdi.autoInsertAll();


        //data type testing

        //data_typesDao dt = new data_typesDaoImpl();
        //data_types id = dt.selectById(1);
        //System.out.println(id.getData_type_id() + "," + id.getData_type_desc());
        //data_types dtn = new data_types(dt.generateUniqueId(),"an element");
        //dt.delete(1);
        //dt.delete(2);
        //dt.autoInsertAll();
        //data_types data = new data_types(4,"element");
        //dt.update(data,data.getData_type_id());
        /*List<data_types> ldata = dt.selectAll();
        for (data_types d: ldata) {
            System.out.println(d.getData_type_id() +" " + d.getData_type_desc());
        }*/

        //variety type testing

        //variety_typeDao vt = new variety_typeDaoImpl();
        //vt.autoInsertAll();
        //variety_type vtpe = new variety_type(vt.generateUniqueId(),"new");
        //vt.insert(vtpe);
        //vt.delete(27);
        //variety_type vtype2 = vt.selectById(13);
        //System.out.println(vtype2.getVariety_id() + ", " + vtype2.getVariety_name());
        //parameter_cropDao pc = new parameter_cropDaoImpl();
        //pc.autoInsertAll();
        //variety_type vtpeu = new variety_type(26,"Or");
        //vt.update(vtpeu,26);
        /*List<variety_type> listv = vt.selectAll();
        for (variety_type v: listv) {
            System.out.println(v.getVariety_id() + " " + v.getVariety_name());
        }*/

        //phenological stage testing

        //pheonological_stageDao psd = new pheonological_stageDaoImpl();
        //pheonological_stage ps = new pheonological_stage("hi2",3,3,null);
        //psd.insert(ps);
        //pheonological_stage update = new pheonological_stage("hia",6,5,2);
        //psd.update(update,update.getPheonological_stage_id());
        //pheonological_stage select= psd.selectById(0);
        //System.out.println(select.getPheonological_stage_desc() + " gdd: " + select.getPheonological_stage_duration_gdd());
        /*List<pheonological_stage> pslist = psd.selectAll();
        for (pheonological_stage item:pslist) {
            System.out.println(item.getPheonological_stage_id() + " " + item.getPheonological_stage_desc());
        }*/
        //pheonological_stage ps1 = psd.selectById(5);
        //psd.update(ps1,1);
        //psd.autoInsertAll();
        /*psd.delete(1);
        psd.delete(2);
        psd.delete(3);
        psd.delete(4);
        psd.delete(5);
        psd.delete(6);
        psd.delete(7);
        psd.delete(8);
        psd.delete(9);
        psd.delete(10);
        psd.delete(11);
        psd.delete(12);
        psd.delete(13);
        psd.delete(14);
        psd.delete(15);
        psd.delete(16);
        psd.delete(17);
        psd.delete(18);
        psd.delete(19);
        psd.delete(20);
        psd.delete(21);
        psd.delete(22);
        psd.delete(23);
        psd.delete(24);
        psd.delete(25);
        psd.delete(26);
        psd.delete(27);
        psd.delete(28);
        psd.delete(29);
        psd.delete(30);
        psd.delete(31);
        psd.delete(32);
        psd.delete(33);
        psd.delete(34);
        psd.delete(35);
        psd.delete(36);
        psd.delete(37);
        psd.delete(38);
        psd.delete(39);
        psd.delete(40);
        psd.delete(41);
        psd.delete(42);
        psd.delete(43);
        psd.delete(44);
        psd.delete(45);
        psd.delete(46);
        psd.delete(47);
        psd.delete(48);
        psd.delete(49);
        psd.delete(50);
        psd.delete(51);
        psd.delete(52);
        psd.delete(53);
        psd.delete(54);
        psd.delete(55);
        psd.delete(56);
        psd.delete(57);
        psd.delete(58);
        psd.delete(59);
        psd.delete(60);
        psd.delete(61);
        psd.delete(62);
        psd.delete(63);
        psd.delete(64);
        psd.delete(65);
        psd.delete(66);
        psd.delete(67);
        psd.delete(68);
        psd.delete(69);
        psd.delete(70);
        psd.delete(71);
        psd.delete(72);
        psd.delete(73);
        psd.delete(74);
        psd.delete(75);
        psd.delete(76);
        psd.delete(77);
        psd.delete(78);
        psd.delete(79);
        psd.delete(80);
        psd.delete(81);
        psd.delete(82);
        psd.delete(83);
        psd.delete(84);
        psd.delete(85);
        psd.delete(86);
        psd.delete(87);
        psd.delete(88);
        psd.delete(89);
        psd.delete(90);
        psd.delete(91);
        psd.delete(92);
        psd.delete(93);*/

    }
    }