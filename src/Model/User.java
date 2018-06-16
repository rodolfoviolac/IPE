package Model;

public class User {

    private String ID;
    private String name;
    private String login;
    private String password;
    private Plot plot;


    public User(String ID, String name, String login, String password) {
        this.ID = ID;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
