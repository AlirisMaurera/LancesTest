package br.com.alirismaurera.leilao.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditarLeilaoPage {

    private WebDriver driver;

    @FindBy(id = "nome")
    private WebElement nome;

    @FindBy(id = "valorInicial")
    private WebElement valor;

    @FindBy(id = "button-submit")
    private WebElement salvar;

    @FindBy(id = "dataAbertura")
    private WebElement data;

    public EditarLeilaoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LeilaoPage atualizarFormulario(String nomeL, String valorI, String dataL){
        nome.clear();
        nome.sendKeys(nomeL);
        valor.clear();
        valor.sendKeys(valorI);
        data.clear();
        data.sendKeys(dataL);
        salvar.click();
        return new LeilaoPage(driver);
    }
}
