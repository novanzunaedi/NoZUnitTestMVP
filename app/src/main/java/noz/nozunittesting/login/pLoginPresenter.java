package noz.nozunittesting.login;

import noz.nozunittesting.R;

/**
 * Created by CLient-Pc on 22/10/2016.
 */

public class pLoginPresenter {
    private iLoginView view;
    private sLoginService service;

    public pLoginPresenter(iLoginView view, sLoginService service) {
        this.view = view;
        this.service = service;
    }

    public void onLoginClicked(){
        String email = view.getEmail();
        if(email.isEmpty()){
            view.etEmailError(R.string.email_error);
            return;
        }

        String password = view.getPassword();
        if(password.isEmpty()){
            view.etPasswordError(R.string.password_error);
            return;
        }

        boolean loginsuccess = service.login(email, password);
        if(loginsuccess){
            view.startNextActivity();
            return;
        }
        view.showLoginError();
    }
}
