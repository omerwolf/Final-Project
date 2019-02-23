package DB.DaoImpl;

import DB.Dao.SoilDao;
import DB.Entites.Soil;
import DB.Util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SoilDaoImpl implements SoilDao {
    @Override
    public void insert(Soil soil) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `crop type` (crop_id,crop_name)" +
                    "VALUES (?, ?)");
            preparedStatement.setInt(1, soil.getId());
            preparedStatement.setString(2, soil.getName());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO `crop type` (crop_id,crop_name)" +
                    " VALUES (?, ?)");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Soil selectById(int id) {
        return null;
    }

    @Override
    public List<Soil> selectAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Soil soil, int id) {

    }

    @Override
    public int generateUniqueId() {
        return 0;
    }

    @Override
    public void insertAll(String[] soilsName) {

    }
}
