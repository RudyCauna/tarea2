package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class SettingsModal {
    public TextBox oldPwdTxtBox = new TextBox(By.id("TextPwOld"));
    public TextBox newPwdTxtBox = new TextBox(By.id("TextPwNew"));
    public Button okButton = new Button(By.xpath("//span[text()='Ok']"));
}
