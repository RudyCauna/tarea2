package testUI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import pages.SettingsModal;
import session.Session;

public class ChangePassword {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    MenuSection menuSection= new MenuSection();
    SettingsModal settingsModal = new SettingsModal();

    @BeforeEach
    public void goWebApp(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @AfterEach
    public void closeWebApp(){
        Session.getInstance().closeSession();
    }

    @Test
    public void changePassword(){
        mainPage.loginButton.click();
        loginModal.emailTxtBox.writeText("pedro.4@escamoso.com");
        loginModal.pwdTxtBox.writeText("1234");
        loginModal.loginButton.click();

        menuSection.settingsButton.click();

        settingsModal.oldPwdTxtBox.writeText("1234");
        settingsModal.newPwdTxtBox.writeText("12345");
        settingsModal.okButton.click();

        menuSection.logoutButton.click();

        mainPage.loginButton.click();
        loginModal.emailTxtBox.writeText("pedro.4@escamoso.com");
        loginModal.pwdTxtBox.writeText("12345");
        loginModal.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "Error, el Cambio de Contraseña fallo");
    }
}
