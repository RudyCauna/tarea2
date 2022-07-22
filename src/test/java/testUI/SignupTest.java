package testUI;

import Util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.MenuSection;
import pages.SignupModal;
import session.Session;

public class SignupTest {
    MainPage mainPage = new MainPage();
    SignupModal signupModal = new SignupModal();
    MenuSection menuSection= new MenuSection();

    @BeforeEach
    public void goWebApp(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @AfterEach
    public void closeWebApp(){
        Session.getInstance().closeSession();
    }

    @Test
    public void verifySignupIsSuccessfully(){
        mainPage.signupButton.click();
        signupModal.fullNameTxtBox.writeText("Pedro Coral Tavera");
        signupModal.emailTxtBox.writeText(Util.obtenerCorreo());
        signupModal.pwdTxtBox.writeText("12345");
        signupModal.termsCheckBox.click();
        signupModal.signupButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "Error, el SignUp fallo");
    }
}
