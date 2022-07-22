package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import pages.SettingsModal;

import java.util.Map;

public class MyStepChangePassword {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    MenuSection menuSection= new MenuSection();
    SettingsModal settingsModal = new SettingsModal();
    @When("yo cambio mi password antiguo por uno nuevo")
    public void yoCambioMiPasswordAntiguoPorUnoNuevo(Map<String, String> dataPwd) {
        menuSection.settingsButton.click();

        settingsModal.oldPwdTxtBox.writeText(dataPwd.get("oldPwd"));
        settingsModal.newPwdTxtBox.writeText(dataPwd.get("newPwd"));
        settingsModal.okButton.click();
    }

    @And("salgo de la App Web")
    public void salgoDeLaAppWeb() {
        menuSection.logoutButton.click();
    }

    @Then("yo deberia realizar el login con el password nuevo")
    public void yoDeberiaRealizarElLoginConElPasswordNuevo(Map<String,String> credential) {
        mainPage.loginButton.click();
        loginModal.emailTxtBox.writeText(credential.get("email"));
        loginModal.pwdTxtBox.writeText(credential.get("password"));
        loginModal.loginButton.click();
    }
}
