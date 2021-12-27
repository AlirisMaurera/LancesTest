package br.com.alirismaurera.leilao.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    private String url_login = "http://localhost:8080/login";

    @FindBy(css = ".mr-2 a")
    private WebElement botaoEntrar;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage irParaPaginaLogar() {
//        driver.get(url_login);
        botaoEntrar.click();
        return new LoginPage(driver);
    }
}
