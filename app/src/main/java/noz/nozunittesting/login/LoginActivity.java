package noz.nozunittesting.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import noz.nozunittesting.ActivityAnimation;
import noz.nozunittesting.R;

public class LoginActivity extends AppCompatActivity implements iLoginView{

    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.etEmail)
    EditText etEmail;

    private pLoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new pLoginPresenter(this, new sLoginService());
    }


    @OnClick(R.id.btnLogin)
    public void onClick() {
        loginPresenter.onLoginClicked();
    }


    @Override
    public String getEmail() {
        return etEmail.getText().toString().trim();
    }

    @Override
    public void etEmailError(int resId) {
            etEmail.setError(getString(resId));
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void etPasswordError(int resId) {
        etPassword.setError(getString(resId));
    }

    @Override
    public void startNextActivity() {
        new ActivityAnimation(this, btnLogin).startMainActivity();
    }

    @Override
    public void showLoginError() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }
}
