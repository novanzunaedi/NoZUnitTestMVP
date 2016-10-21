package noz.nozunittesting.login;

/**
 * Created by CLient-Pc on 22/10/2016.
 */

public class sLoginService {

    public boolean login (String username, String password){
        return "james".equals(username) && "bond".equals(password);
    }
}
