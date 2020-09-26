package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sun.font.Script;

import java.sql.SQLOutput;
import java.util.List;

public class DetailsPage {
    WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    public DetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }
//

    @FindBy(id = "ProductPrice_productPrice_PriceContainer")
    private WebElement price;
    @FindBy(id = "buttonPanel_AddToCartButton")
    private WebElement add;
    @FindBy(xpath = "//div[@aria-label=\"Close\"]")
    private WebElement button;

    public boolean compare(String value) {
        if (value.equals(price.getText())) {
            System.out.println("Price is the same in detail view");
            return true;
        } else return false;
    }

    public void add() throws InterruptedException {
        Thread.sleep(4000);
        List<WebElement> lista = driver.findElements(By.xpath("//div[@aria-label=\"Close\"]"));
        button.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        add.click();
    }
}
