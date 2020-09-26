package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CartPage {
    WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    @FindBy(xpath = "//span[@class=\"_3fnVqdke c-paragraph-4\"]/span/strong/span")
    private WebElement price3;
    public boolean compare() {
        boolean result = false;
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='x-screen-reader']"));
        if (price.get(0).getText().equals(price.get(1).getText()) && price.get(0).getText().equals(price3.getText())) {
            result = true;
            System.out.println("Prices are similars in the cart");
        }
        return result;
    }

    public double getprice() {
        String numero=price3.getText().replace("$", "");
        return Double.parseDouble(numero.replace(",", ""));
    }

    public void selectnumber() {
        new Select(driver.findElement(By.xpath("//select[@aria-label=\"Visual Studio Professional Subscription  Quantity selection\"]"))).selectByValue("20");
    }

    public boolean compareprice(double currentprice, double newprice) {
        boolean result = false;
        double oldprice = currentprice * 20;
        if (oldprice == newprice) {
            result = true;
            System.out.println("Price is correct");
        }
        return result;
    }
}
