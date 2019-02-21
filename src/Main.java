import DB.Dao.CropDao;
import DB.DaoImpl.CropDaoImpl;
import DB.Entites.Crop;
import DB.Util.ConnectionConfiguration;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CropDao cdi = new CropDaoImpl();
        /**Insert a new record**/
        //Crop crop = new Crop("Corn",4);
        //cdi.insert(crop);
        /**Select by id**/
        //Crop crop = cdi.selectById(6);
        //System.out.println(crop.getId() + ", " + crop.getName());

        /**Delete by id**/
        //cdi.delete(3);

        /**Update **/
        Crop cropUpdate = new Crop("BBB",2);
        cdi.update(cropUpdate,2);

        /**Select all**/
        List<Crop> crops = cdi.selectAll();
        for(Crop c : crops) {
            System.out.println(c.getId()+", "+c.getName());
        }
    }

}
