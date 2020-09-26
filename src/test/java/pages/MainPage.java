package pages;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage {
    WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    @FindBy(id = "shellmenu_1")
    private WebElement office;
    @FindBy(id = "shellmenu_2")
    private WebElement windows;
    @FindBy(id = "shellmenu_3")
    private WebElement surface;
    @FindBy(id = "shellmenu_4")
    private WebElement xbox;
    @FindBy(id = "shellmenu_5")
    private WebElement deals;
    @FindBy(id = "l1_support")
    private WebElement support;

    public boolean nothint() {
        boolean result = office.isDisplayed() && windows.isDisplayed() && surface.isDisplayed() && xbox.isDisplayed() && deals.isDisplayed() && support.isDisplayed();
        if (result) {
            System.out.println("All the elements are on the web");
        }
        return result;
    }

    public void tap() {
        windows.click();
    }

}


