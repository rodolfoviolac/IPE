package Login.Model;
import java.util.HashMap;

import java.util.Hashtable;

import java.util.Map;

public class Handler {

    private Map<String,User> userDic;

    private Handler handler_user;


    public Handler(){

        downLoadUsersFromSource();

    }

    private void downLoadUsersFromSource() {


        //HERE YOU CAN DOWNLOAD THE USER FROM YOUR DB SERVER

        userDic = new HashMap<String, User>();

        User lucio = new User("1","Lucio Franco","lucio.lpf", "lucinho");
        User rodolfo = new User("2","Rodolfo Viola","rodolfo.v", "rodolfinho");

        this.userDic.put(lucio.getLogin(), lucio);
        this.userDic.put(rodolfo.getLogin(), rodolfo);


    }

    public User userWithParams(String login){

            return userDic.get(login);

    }
}
