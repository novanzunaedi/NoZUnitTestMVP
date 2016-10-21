package noz.nozunittesting.login;

/**
 * Created by CLient-Pc on 22/10/2016.
 */

public interface iLoginView {

    String getEmail();

    void etEmailError(int resId);

    String getPassword();

    void etPasswordError(int resId);

    void startNextActivity();

    void showLoginError();
}
