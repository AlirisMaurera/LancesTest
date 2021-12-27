package br.com.alirismaurera.leilao.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    private static WebDriver driver;
    private String url = "http://localhost:8080/leiloes";

    @Before
    public void inicializa() {
        String webDriver = System.getProperty("browser", "chrome");
        if (webDriver.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get(url);
    }

    public static WebDriver obterDriver() {
        return driver;
    }

    @After
    public void fechar() {
        driver.quit();
    }

}


