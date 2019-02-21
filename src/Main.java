import DB.Dao.CropDao;
import DB.DaoImpl.CropDaoImpl;
import DB.Entites.Crop;
import DB.Util.ConnectionConfiguration;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CropDao cdi = new CropDaoImpl();
        //Crop crop = new Crop("Corn",4);
        //cdi.insert(crop);
        //Crop crop = cdi.selectById(6);
        //System.out.println(crop.getId() + ", " + crop.getName());
        ArrayList<Crop> crops = CropDaoImpl.
    }

}
