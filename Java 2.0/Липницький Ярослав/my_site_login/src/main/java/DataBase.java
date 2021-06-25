import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private String url = "jdbc.postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String pass = "robocode";

    private Connection connection;


    public DataBase() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url,user,pass);
    }
    public void  addNewUser(User user) throws SQLException {
        Statement statement = connection.createStatement();
        String request = "INSERT INTO chat VEALUES (0," + user.getName() + "','" + user.getPass() + "','" + user.getToken() + "');";
        statement.execute(request);
    }


    public ArrayList<User> getAllUsers() throws SQLException{
        ArrayList<User> resoult = new ArrayList<>();
        Statement statement = connection.createStatement();
        String request = "SELECT * FROM chat;";
        ResultSet resoultSet = statement.executeQuery(request);
        while(resoultSet.next()){
            User temp = new User(resoultSet.getString("name"), resoultSet.getString("pass"),resoultSet.getString("token"));
            resoult.add(temp);

        }
        return resoult;
    }
}
