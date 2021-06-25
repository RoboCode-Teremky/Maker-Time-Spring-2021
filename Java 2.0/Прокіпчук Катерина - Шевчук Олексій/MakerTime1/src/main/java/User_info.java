public class User_info {
    private String pass;
    private String login;

    public User_info(String login, String pass) {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public User_info(String name, String pass, String token) {
        this.login = name;
        this.pass = pass;

    }
    public String toString(){
        String result = "Name: "+login+", password: "+pass;
        return result;
    }
}
