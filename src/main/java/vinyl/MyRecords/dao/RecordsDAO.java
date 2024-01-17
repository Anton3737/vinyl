package vinyl.MyRecords.dao;


import org.springframework.stereotype.Component;
import vinyl.MyRecords.models.Vinyls;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecordsDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/VinylRecords";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "love";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Vinyls> index() {
        List<Vinyls> vinylsList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Records";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Vinyls vinylsLine = new Vinyls();
                vinylsLine.setId(resultSet.getInt("id"));
                vinylsLine.setArtist(resultSet.getString("artist"));
                vinylsLine.setAlbum(resultSet.getString("album"));
                vinylsLine.setDatarecording(resultSet.getString("datarecording"));
                vinylsLine.setDatareliase(resultSet.getString("datareliase"));
                vinylsLine.setPublhouse(resultSet.getString("publhouse"));
                vinylsLine.setCountry(resultSet.getString("country"));
                vinylsLine.setGenry(resultSet.getString("genry"));
                vinylsLine.setNumberoftracks(resultSet.getString("numberoftracks"));
                vinylsLine.setNumberofdisk(resultSet.getString("numberofdisk"));
                vinylsLine.setConditions(resultSet.getString("conditions"));
                vinylsList.add(vinylsLine);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vinylsList;
    }

    public Vinyls show(int id) {
        Vinyls vinylsLine = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Records WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            vinylsLine = new Vinyls();

            vinylsLine.setId(resultSet.getInt("id"));
            vinylsLine.setArtist(resultSet.getString("artist"));
            vinylsLine.setAlbum(resultSet.getString("album"));
            vinylsLine.setDatarecording(resultSet.getString("datarecording"));
            vinylsLine.setDatareliase(resultSet.getString("datareliase"));
            vinylsLine.setPublhouse(resultSet.getString("publhouse"));
            vinylsLine.setCountry(resultSet.getString("country"));
            vinylsLine.setGenry(resultSet.getString("genry"));
            vinylsLine.setNumberoftracks(resultSet.getString("numberoftracks"));
            vinylsLine.setNumberofdisk(resultSet.getString("numberofdisk"));
            vinylsLine.setConditions(resultSet.getString("conditions"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vinylsLine;
    }

    public void save(Vinyls vinylsLine) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Records VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ;

            preparedStatement.setInt(1, vinylsLine.getId());
            preparedStatement.setString(2, vinylsLine.getArtist());
            preparedStatement.setString(3, vinylsLine.getAlbum());
            preparedStatement.setString(4, vinylsLine.getDatarecording());
            preparedStatement.setString(5, vinylsLine.getDatareliase());
            preparedStatement.setString(6, vinylsLine.getPublhouse());
            preparedStatement.setString(7, vinylsLine.getCountry());
            preparedStatement.setString(8, vinylsLine.getGenry());
            preparedStatement.setString(9, vinylsLine.getNumberoftracks());
            preparedStatement.setString(10, vinylsLine.getNumberofdisk());
            preparedStatement.setString(11, vinylsLine.getConditions());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        vinylsLine.setId(generatedId);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Vinyls updatedVinyls) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Records SET id=?, artist=?,  album=?,  datarecording=?,  datareliase=?,  publhouse=?,  country=?,  genry=?,  numberoftracks=?,  numberofdisk=?,  conditions=? WHERE id=?");

            preparedStatement.setInt(1, updatedVinyls.getId());
            preparedStatement.setString(2, updatedVinyls.getArtist());
            preparedStatement.setString(3, updatedVinyls.getAlbum());
            preparedStatement.setString(4, updatedVinyls.getDatarecording());
            preparedStatement.setString(5, updatedVinyls.getDatareliase());
            preparedStatement.setString(6, updatedVinyls.getPublhouse());
            preparedStatement.setString(7, updatedVinyls.getCountry());
            preparedStatement.setString(8, updatedVinyls.getGenry());
            preparedStatement.setString(9, updatedVinyls.getNumberoftracks());
            preparedStatement.setString(10, updatedVinyls.getNumberofdisk());
            preparedStatement.setString(11, updatedVinyls.getConditions());


            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement =
                null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Records WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
