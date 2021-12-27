package br.com.alirismaurera.leilao.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeilaoPage {


    private WebDriver driver;

    @FindBy(css = ".mr-2 span")
    private WebElement nomeUsuario;

    @FindBy(id = "novo_leilao_link")
    private WebElement botaoNovoLeilao;

    @FindBy( css= ".table-hover tbody tr:last-child td")
    private List<WebElement> tabelaLeiloes;

    @FindBy(linkText = "dar lance")
    private WebElement lance;


    public LeilaoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String obterNomeUsuario() {
        return nomeUsuario.getText();
    }

    public String obterPage() {
       return driver.getCurrentUrl();
    }

    public String obterCodigoFonte() {
        return driver.getPageSource();
    }

    public NovoLeiloesPage irParaNovoLeiloes() {
        botaoNovoLeilao.click();
        return new NovoLeiloesPage(driver);
    }

    public boolean estaPresenteOLeilao(String nomeL, String valorI, String data, String usuarioL) {
        System.out.println(tabelaLeiloes.size());
        String nome = tabelaLeiloes.get(0).getText();
        String dataAbertura = tabelaLeiloes.get(1).getText();
        String ValorInicial = tabelaLeiloes.get(2).getText();
        String usuario = tabelaLeiloes.get(3).getText();
        return nome.equalsIgnoreCase(nomeL) && dataAbertura.equalsIgnoreCase(data)
                && valorI.equalsIgnoreCase(valorI) && usuario.equalsIgnoreCase(usuarioL);
    }

    public EditarLeilaoPage irParaEditarLeilao() {
        tabelaLeiloes.get(4).click();
        return new EditarLeilaoPage(driver);
    }

    public LancesPage irParaLance() {
        lance.click();
        return new LancesPage(driver);
    }
}
