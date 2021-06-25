import java.sql.*;
import java.util.ArrayList;

public class database {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String pass = "robocode";
    private Connection connection;

    public database() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, user, pass);

    }
    public void addNewUser(User_info user, int id) throws SQLException {
        Statement statement = connection.createStatement();
        String request = "INSERT INTO chat VALUES("+id+", '" + user.getLogin()
                + "','" + user.getPass() + "')";
        statement.execute(request);
    }
    public ArrayList<User_info> getAllUsers() throws SQLException{
        ArrayList<User_info> result = new ArrayList<>();
        Statement statement = connection.createStatement();
        String request = "SELECT * FROM chat;";
        ResultSet resultSet = statement.executeQuery(request);
        while(resultSet.next()){
            User_info temp = new User_info(resultSet.getString("login"), resultSet.getString("pass"));
            result.add(temp);
        }
        return result;
    }
}

