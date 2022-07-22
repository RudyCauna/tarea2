package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicSelenium {
    ChromeDriver driver;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://todo.ly/");
    }
    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

    //@Test
    public void crearNuevaCuenta(){
        //driver.findElement(By.id());
        //driver.findElement(By.xpath(""));
        driver.findElement(By.xpath("//img[@src='/Images/design/pagesignup.png']")).click();
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName")).sendKeys("Pedro Coral Tavera");
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail")).sendKeys("pedro.3@escamoso.com");
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword")).sendKeys("12345");
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms")).click();
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_ButtonSignup")).click();

        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(),
                "ERROR, El usuario no pudo registrarse");
    }

    //@Test
    public void cambiarPassword(){
        //::Login
        // click boton login
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // escribir email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("pedro.3@escamoso.com");
        //escribir password
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click boton login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        // clic en boton settings
        driver.findElement(By.xpath("//a[@href='javascript:OpenSettingsDialog();']")).click();

        driver.findElement(By.id("TextPwOld")).sendKeys("12345");;
        driver.findElement(By.id("TextPwNew")).sendKeys("1234");;
        driver.findElement(By.xpath("//span[text()='Ok']")).click();

        driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).click();

        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("pedro.3@escamoso.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("1234");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        driver.findElement(By.xpath("//a[@href='javascript:OpenSettingsDialog();']")).click();

        // verificacion
        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(),
                "ERROR, el usuario no pudo cambiar su contraseña");
    }
}
