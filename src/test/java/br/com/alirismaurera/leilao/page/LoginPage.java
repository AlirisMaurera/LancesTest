package br.com.alirismaurera.leilao.page;

import br.com.alirismaurera.leilao.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement nomeUsuario;

    @FindBy(name = "password")
    private WebElement senhaUsuario;

    @FindBy(className = "btn-primary")
    private WebElement botaoLogar;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LeilaoPage prencherFormulario(String nome, String senha) {
        nomeUsuario.sendKeys(nome);
        senhaUsuario.sendKeys(senha);
        logar();
        return new LeilaoPage(driver);
    }


    public void logar() {
        botaoLogar.click();

    }
}
