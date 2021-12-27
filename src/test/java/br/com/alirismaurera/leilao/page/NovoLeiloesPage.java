package br.com.alirismaurera.leilao.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NovoLeiloesPage {

    private WebDriver driver;

    @FindBy(id = "nome")
    private WebElement nome;

    @FindBy(id = "valorInicial")
    private WebElement valor;

    @FindBy(id = "dataAbertura")
    private WebElement data;

    @FindBy(id = "button-submit")
    private WebElement salvar;

    public NovoLeiloesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LeilaoPage PreencherFormularioNovoLeilao(String nomeLeilao, String valorInicial, String dataAbertura) {
        nome.sendKeys(nomeLeilao);
        valor.sendKeys(valorInicial);
        data.sendKeys(dataAbertura);
        salvar.submit();
    return new LeilaoPage(driver);
    }

    public String obterUrlDaPagina(){
        return driver.getCurrentUrl();
    }


}
