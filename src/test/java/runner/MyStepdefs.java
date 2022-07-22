package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("tengo acceso a todo.ly")
    public void tengoAccesoATodoLy() {

    }

    @When("realizo click en el boton login")
    public void realizoClickEnElBotonLogin() {
    }

    @And("ingreso mi correo electronico: {string}")
    public void ingresoMiCorreoElectronico (String email) {
    }

    @And("ingreso mi password: {int}")
    public void ingresoMiPassword(int arg0) {
    }

    @Then("deberia ingresar a la aplicacion")
    public void deberiaIngresarALaAplicacion() {
    }
}
