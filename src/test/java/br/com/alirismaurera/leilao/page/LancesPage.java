package br.com.alirismaurera.leilao.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LancesPage {

    private WebDriver driver;

    @FindBy(id = "valor")
    private WebElement valorLance;

    @FindBy(id = "btnDarLance")
    private WebElement botaoDarLance;


    public LancesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void darUmLance(String valor) {
        valorLance.sendKeys(valor);
        botaoDarLance.click();
    }

    public String obterPaginaFonte() {
       return driver.getPageSource();
    }
}
