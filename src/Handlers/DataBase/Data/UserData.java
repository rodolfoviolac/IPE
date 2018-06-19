package Handlers.DataBase.Data;
import Handlers.Model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import java.util.Map;

@Scope(value = "singleton")
@Component
public class UserData {

    private Map<String, User> userDic;

    private UserData handler_UserDB_user;
    private User LogedUserIndex;


    public UserData(){
        User initUser = new User("none", "none","none", "none");
        setLogedUser(initUser);
        downLoadUsersFromSource();
    }

    private void downLoadUsersFromSource() {
        //HERE YOU CAN DOWNLOAD THE USER FROM YOUR DB SERVER
        userDic = new HashMap<String, User>();
        User lucio = new User("1","Lucio Franco","lucio.lpf", "lucinho");
        User rodolfo = new User("2","Rodolfo Viola","rodolfo", "rodolfo");
        User julia = new User("3","Julia Ritizman","sempre.doente", "rodolfo");
        User henrique = new User("4","Henrique Sei La","trouxa", "rodolfo");

        this.userDic.put(lucio.getLogin(), lucio);
        this.userDic.put(lucio.getLogin(), julia);
        this.userDic.put(lucio.getLogin(), henrique);
        this.userDic.put(rodolfo.getLogin(), rodolfo);
    }

    public void setLogedUser(User user){
        LogedUserIndex = user;
    }

    public User getLogedUser(){
        return LogedUserIndex;
    }

    public User userWithParams(String login){
            return userDic.get(login);
    }
}
