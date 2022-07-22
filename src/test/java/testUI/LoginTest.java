package testUI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import session.Session;

public class LoginTest {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
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
    public void verifyLoginIsSuccessfully(){
        mainPage.loginButton.click();
        loginModal.emailTxtBox.writeText("pedro.3@escamoso.com");
        loginModal.pwdTxtBox.writeText("1234");
        loginModal.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "Error, el Login fallo");
    }
}
