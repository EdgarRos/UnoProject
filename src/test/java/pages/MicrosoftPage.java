package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.*;

public class MicrosoftPage {
    WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;

    public MicrosoftPage(WebDriver driver) {
        this.driver = driver;
//        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);


    }

    @FindBy(id = "R1MarketRedirect-close")
    private WebElement cerrar;
    @FindBy(id = "c-shellmenu_52")
    private WebElement windows10;
    @FindBy(id = "search")
    private WebElement search;
    @FindBy(id = "cli_shellHeaderSearchInput")
    private WebElement searchtextbox;
    private String price;

    public void clicmicrosoft() {
        windows10.click();
    }

    public void printelements() {
        List<WebElement> drop = driver.findElements(By.xpath("//div/button[@id='c-shellmenu_52']/following-sibling::ul/li/a"));
        Iterator<WebElement> it = drop.iterator();
        while (it.hasNext()) {
            WebElement row = it.next();
            System.out.println(row.getText());
        }
    }

    public void tapsearch() {
        search.click();
        searchtextbox.sendKeys("visual studio");
        searchtextbox.submit();
        cerrar.click();
    }

    public void printprices() {
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='c-channel-placement-price']/div/span/span"));
        price = prices.get(0).getText();
        System.out.println("Price 1: " + prices.get(0).getText());
        System.out.println("Price 2: " + prices.get(2).getText());
        System.out.println("Price 3: " + prices.get(4).getText());
    }

    public void taponvisualstudio() {
        WebElement element = driver.findElement(By.xpath("//div[@class='c-channel-placement-price']/div/span/span"));
        element.click();
    }

    public String enviarvalor() {
        return this.price;
    }

}
