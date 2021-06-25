import java.net.http.WebSocket;
import java.sql.*;


public class database {
    public database() {

        try {

            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "robocode");
            Statement st = c.createStatement();
            String sql = "SELECT * FROM clientlist;";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String email = rs.getString("email");
                String pass = rs.getString("password");
                System.out.println("email: " + email);
                System.out.println("password: " + pass);
            }
            rs.close();
            st.close();
            c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }            /*String sql = "INSERT INTO clientlist VALUES(" + login + ", " + pass + ");";
        } else {

            if (type.equalsIgnoreCase("log")) {
                for (User_info user : clients) {
                    if (user.getLogin().equals(login)) {
                        if (user.getPass().equals(pass)) {
                            webSocket.send("Вхід до системи виконаний успішно");
                        } else {
                            webSocket.send("Паролі не співпадають! Спробуйте ще раз");
                        }
                    } else {
                        webSocket.send("Такого користувача не існує");
                    }


                }

            }
        }*/


    public boolean addNewUser(String email, String pass) {
        String CheckEmail = "SELECT email FROM clientlist WHERE email = " + email + ");";

        if (CheckEmail == null) {
            String addNewUser = "INSERT INTO clientlist VALUES(" + email + ", " + pass + ");";
            return true;
        } else {
            return false;
        }
    }
    public boolean LoginUser(String email, String pass) {
        String CheckEmail = "SELECT email FROM clientlist WHERE email = " + email + ");";
        String CheckPass = "SELECT password FROM clientlist WHERE email = " + email + ");";
        if (CheckEmail == email && CheckPass == pass) {
            return true;
        } else {
            return  false;
        }
    }
}
// test@gmail.com robocode