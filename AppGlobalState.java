import java.sql.*;

public class AppGlobalState {
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Statement statement;

    private static PreparedStatement insertWeatherPreparedStatement;

    private static AppGlobalState instance;

    public String cityName1;

    private String cityKey;

    public String getCityName1() {

        return cityName1;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static PreparedStatement getInsertWeatherPreparedStatement() {

        return insertWeatherPreparedStatement;
    }

    public void setCityName1(String cityName1) {

        this.cityName1 = cityName1;
    }

    public String getCityKey() {

        return cityKey;
    }

    public void setCityKey(String cityKey) {

        this.cityKey = cityKey;
    }

    public String getDbName() {

        return "weather-app.db";
    }


    private AppGlobalState() {
        try {
            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:c:\\sqlite\\" + getDbName())) {
                statement = connection.createStatement();
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather(" +
                        "date TEXT NOT NULL,city TEXT NOT NULL, temp TEXT NOT NULL, text TEXT NOT NULL);");
                insertWeatherPreparedStatement = connection.prepareStatement(
                        "INSERT INTO weather (date, city, temp, text) VALUES (?,?,?,?);"
                );
            }


        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.exit(1);
        }
    }

    public static AppGlobalState getInstance() {
        if (instance == null) {
            instance = new AppGlobalState();
        }
        return instance;
    }


    public String getApiKey() {

        return "H6ldpZ8Uej2NF2cOGdMmZa5wo1wWr0vq";
    }
}
