package runner;

import Util.Util;
import io.cucumber.java.en.When;
import pages.MainPage;
import pages.MenuSection;
import pages.SignupModal;

import java.util.Map;

public class MyStepSignup {
    MainPage mainPage = new MainPage();
    SignupModal signupModal = new SignupModal();
    MenuSection menuSection = new MenuSection();

    @When("yo quiero realizar un signup")
    public void yoQuieroRealizarUnSignup(Map<String, String> dataSignup) {
        mainPage.signupButton.click();
        signupModal.fullNameTxtBox.writeText(dataSignup.get("fullName"));
        signupModal.emailTxtBox.writeText(Util.obtenerCorreo());
        signupModal.pwdTxtBox.writeText(dataSignup.get("password"));
        signupModal.termsCheckBox.click();
        signupModal.signupButton.click();
    }
}
