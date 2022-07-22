package runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import session.Session;

import java.util.Map;

public class MyStepLogin {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    MenuSection menuSection= new MenuSection();
    @Given("la pagina {string} este abierta")
    public void laPaginaEsteAbierta(String url) {
        Session.getInstance().getBrowser().get(url);
    }

    @When("yo quiero realizar el login")
    public void yoQuieroRealizarElLogin(Map<String,String> credential) {
        mainPage.loginButton.click();
        loginModal.emailTxtBox.writeText(credential.get("email"));
        loginModal.pwdTxtBox.writeText(credential.get("password"));
        loginModal.loginButton.click();
    }

    @Then("yo deberia ingresar a la app web")
    public void yoDeberiaIngresarALaAppWeb() {
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "Error, el Login fallo");
    }
}
