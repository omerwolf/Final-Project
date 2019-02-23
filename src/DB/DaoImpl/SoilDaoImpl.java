package DB.DaoImpl;

import DB.Dao.SoilDao;
import DB.Entites.Soil;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.List;

public class SoilDaoImpl implements SoilDao {
    @Override
    public void insert(Soil soil) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO soil_types" +
                    "(`soil_type_id`," +
                    "`soil_type_desc`," +
                    "`n_percent_for_base_dressing`," +
                    "`p_percent_for_base_dressing`," +
                    "`k_percent_for_base_dressing`," +
                    "`annual_som_decomposition_high_temp`," +
                    "`annual_som_decomposition_moderate_temp`," +
                    "`annual_som_decomposition_low_temp`," +
                    "`base_dressing_strategy_id`," +
                    "`rain effect`," +
                    "`default cec`," +
                    "`lower cec`," +
                    "`upper cec`," +
                    "`default bulk density`) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, soil.getId());
            preparedStatement.setString(2, soil.getName());
            preparedStatement.setDouble(3, soil.getnPrecent());
            preparedStatement.setDouble(4, soil.getpPrecent());
            preparedStatement.setDouble(5, soil.getkPrecent());
            preparedStatement.setDouble(6, soil.getSomDecompHigh());
            preparedStatement.setDouble(7, soil.getSomDecompModerate());
            preparedStatement.setDouble(8, soil.getSomDecompLow());
            preparedStatement.setInt(9, soil.getBaseDressingStrategy());
            preparedStatement.setDouble(10, soil.getRainEffect());
            preparedStatement.setInt(11, soil.getDefualtCEC());
            preparedStatement.setInt(12, soil.getLowerCEC());
            preparedStatement.setInt(13, soil.getUpperCEC());
            preparedStatement.setDouble(14, soil.getDefualtBulkDensity());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("Insert: " + soil.getName());
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
        Soil soil = new Soil();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM soil_types WHERE soil_type_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                soil.setId(resultSet.getInt("soil_type_id"));
                soil.setName(resultSet.getString("soil_type_desc"));
                soil.setnPrecent(resultSet.getDouble("n_percent_for_base_dressing"));
                soil.setpPrecent(resultSet.getDouble("p_percent_for_base_dressing"));
                soil.setkPrecent(resultSet.getDouble("k_percent_for_base_dressing"));
                soil.setSomDecompHigh(resultSet.getDouble("annual_som_decomposition_high_temp"));
                soil.setSomDecompModerate(resultSet.getDouble("annual_som_decomposition_moderate_temp"));
                soil.setSomDecompLow(resultSet.getDouble("annual_som_decomposition_low_temp"));
                soil.setBaseDressingStrategy(resultSet.getInt("base_dressing_strategy_id"));
                soil.setRainEffect(resultSet.getDouble("rain effect"));
                soil.setDefualtCEC(resultSet.getInt("default cec"));
                soil.setLowerCEC(resultSet.getInt("lower cec"));
                soil.setUpperCEC(resultSet.getInt("upper cec"));
                soil.setDefualtBulkDensity(resultSet.getDouble("default bulk density"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        return soil;
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

    @Override
    public void autoInsertAll() {
        Soil s1 = new Soil(1,"Sand",.0,0.15,0.15,0.015,0.01,0.005,1,0.5,5,1,10,1.71);
        this.insert(s1);
    }
}
