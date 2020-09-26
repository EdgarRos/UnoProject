package scripts;

import bsh.Capabilities;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.DetailsPage;
import pages.MainPage;
import pages.MicrosoftPage;

import javax.xml.datatype.Duration;
import java.util.concurrent.TimeUnit;

public class Validation {
    private WebDriver driver;

    @BeforeTest
    public void capabilities() {
        System.setProperty("webdriver.chrome.driver", "./src/driver/chromedriver1.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.microsoft.com/en-us");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }


    @Test
    public void execution() throws InterruptedException {
        MainPage principal = new MainPage(driver);
        MicrosoftPage microsoft = new MicrosoftPage(driver);
        DetailsPage details = new DetailsPage(driver);
        CartPage cart = new CartPage(driver);
        Assert.assertTrue(principal.nothint(), "The elements aren't on the page");
        principal.tap();
        Thread.sleep(4000);
        microsoft.clicmicrosoft();
        microsoft.printelements();
        microsoft.tapsearch();
        microsoft.printprices();
        microsoft.taponvisualstudio();
        Assert.assertTrue(details.compare(microsoft.enviarvalor()), "Price isn't the same");
        details.add();
        Assert.assertTrue(cart.compare(), "Price isn't the same");
        double price = cart.getprice();
        cart.selectnumber();
        Thread.sleep(2000);
        double newprice = cart.getprice();
        Assert.assertTrue(cart.compareprice(price, newprice), "Price is not correct");
    }

    @AfterTest
    public void down() {
        driver.close();
    }
}

