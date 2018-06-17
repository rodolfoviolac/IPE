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

    public UserData(){
        downLoadUsersFromSource();
    }

    private void downLoadUsersFromSource() {
        //HERE YOU CAN DOWNLOAD THE USER FROM YOUR DB SERVER
        userDic = new HashMap<String, User>();
        User lucio = new User("1","Lucio Franco","lucio.lpf", "lucinho");
        User rodolfo = new User("2","Rodolfo Viola","rodolfo", "rodolfo");
        this.userDic.put(lucio.getLogin(), lucio);
        this.userDic.put(rodolfo.getLogin(), rodolfo);
    }

    public User userWithParams(String login){
            return userDic.get(login);
    }
}