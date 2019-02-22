package DB.DaoImpl;

import DB.Dao.CropDao;
import DB.Entites.Crop;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CropDaoImpl implements CropDao {
    @Override
    public void insert(Crop crop) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `crop type` (crop_id,crop_name)" +
                    "VALUES (?, ?)");
            preparedStatement.setInt(1, crop.getId());
            preparedStatement.setString(2, crop.getName());
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
    public Crop selectById(int id) {
        Crop crop = new Crop();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `crop type` WHERE crop_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                crop.setId(resultSet.getInt("crop_id"));
                crop.setName(resultSet.getString("crop_name"));
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
        return crop;
    }

    @Override
    public List<Crop> selectAll() {
        List<Crop> crops = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `crop type`");

            while (resultSet.next()) {
                Crop crop = new Crop();
                crop.setId(resultSet.getInt("crop_id"));
                crop.setName(resultSet.getString("crop_name"));
                crops.add(crop);
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
            if (statement != null) {
                try {
                    statement.close();
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
        return crops;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `crop type` WHERE crop_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("DELETE FROM `crop type` WHERE crop_id = ?");

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
    public void update(Crop crop, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `crop type` SET " +
                    "crop_name = ? WHERE crop_id = ?");

            preparedStatement.setString(1, crop.getName());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            System.out.println("UPDATE `crop type` SET " +
                    "crop_name = ? WHERE crop_id = ?");

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
    public int generateUniqueId() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int emptySpace = 1;
        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `crop type`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("crop_id") + 1;

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
            if (statement != null) {
                try {
                    statement.close();
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
        return emptySpace;
    }

    @Override
    public void insertAll(String[] cropsName) {
        Arrays.sort(cropsName);

        for(String cropName : cropsName) {
            Crop crop = new Crop();
            crop.setName(cropName);
            crop.setId(this.generateUniqueId());
            this.insert(crop);

        }
        System.out.println("insertAll finished!");
    }
}
