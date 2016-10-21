package noz.nozunittesting;

import android.test.mock.MockContentResolver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import noz.nozunittesting.login.iLoginView;
import noz.nozunittesting.login.pLoginPresenter;
import noz.nozunittesting.login.sLoginService;

/**
 * Created by CLient-Pc on 22/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginTestLogic {
    
    @Mock
    private iLoginView view;
    @Mock
    private sLoginService service;
    private pLoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new pLoginPresenter(view, service);
    }

    @Test
    public void shouldShowErrorMessageWhenEmailIsEmpty() throws Exception {
        when(view.getEmail()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).etEmailError(R.string.email_error);
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        when(view.getEmail()).thenReturn("james");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).etPasswordError(R.string.password_error);
    }
}
