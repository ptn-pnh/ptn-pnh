package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "tab-maps")
    public WebElement maps;

    @FindBy(xpath = "//*[@class = 'input__control _bold']")
    public WebElement input_search;

    @FindBy(xpath = "//div[@class = 'small-search-form-view__icon _type_close']")
    public WebElement clear_search;

    @FindBy(xpath = "//a[@title = 'Restaurants']")
    public WebElement restaurants;

    @FindBy(xpath = "//*[. = 'Log in']")
    public WebElement login;

    @FindBy(xpath = "//input[@name = 'login']")
    public WebElement user;

    @FindBy(id = "passp-field-passwd")
    public WebElement password;

    @FindBy(xpath = "(//div[.='Photos']//parent::div[@class])[1]")
    public WebElement photos;

    @FindBy(xpath = "//span[. = 'Add photo']")
    public WebElement Addphotos;


    @FindBy(xpath = "//div[. = 'browser your computer']")
    public WebElement browse;

    @FindBy(xpath = "//span[. = 'Submit']")
    public WebElement submit;


    @FindBy(xpath = "(//div[@class='business-rating-edit-view__star _size_snippet'])")
    public WebElement oneStar;

    @FindBy(xpath = "//textarea")
    public WebElement textarea;

    @FindBy(xpath = "//span[. = 'OK']")
    public WebElement ok;

    @FindBy(xpath = "(//button)[1]")
    public WebElement navigateBack;


    public void informStupidPeople() throws InterruptedException, AWTException {
        WebDriverWait driver = new WebDriverWait(Driver.getDriver(), 10);
        String url = "http://Yandex.com/";
        Driver.getDriver().get(url);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().fullscreen();
        driver.until(ExpectedConditions.elementToBeClickable(login));
        login.click();
        Thread.sleep(1500);
        login.click();
        driver.until(ExpectedConditions.visibilityOf(user));
        user.sendKeys(""); // <- your username here for Yandex account
        login.click();
        password.sendKeys("" + Keys.ENTER); // <- your password here for Yandex account
        Thread.sleep(1000);
        Driver.getDriver().get(url);
        driver.until(ExpectedConditions.elementToBeClickable(maps));
        maps.click();
        driver.until(ExpectedConditions.visibilityOf(input_search));
        input_search.sendKeys("Moscow" + Keys.ENTER); // <- your username here for Yandex account
        Thread.sleep(2000);
        driver.until(ExpectedConditions.elementToBeClickable(clear_search));
        clear_search.click();
        driver.until(ExpectedConditions.visibilityOf(restaurants));
        restaurants.click();
        Thread.sleep(1000);
        int idx = 1;
        WebElement ele = Driver.getDriver().findElement(By.xpath("//li["+idx+"]"));
        ele.click();
        driver.until(ExpectedConditions.elementToBeClickable(photos));
        idx++;
        photos.click();
        driver.until(ExpectedConditions.elementToBeClickable(Addphotos));
        Addphotos.click();
        driver.until(ExpectedConditions.elementToBeClickable(browse));
        browse.click();

        StringSelection stringSelection = new StringSelection((System.getProperty("user.dir") + "\\Bird.jpg"));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Thread.sleep(1000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        submit.click();
        driver.until(ExpectedConditions.elementToBeClickable(oneStar));
        oneStar.click();
        textarea.clear();
        textarea.clear();
        textarea.sendKeys("Будте людьми! Похороните этих Украинских оккупантов по человечески хотя они этого и не достойны! Для поиска пленных раненных и убитых - https://t.me/rf200_now");
        driver.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        driver.until(ExpectedConditions.elementToBeClickable(ok));
        ok.click();
        driver.until(ExpectedConditions.elementToBeClickable(navigateBack));
        navigateBack.click();
        while (idx>=1){
            ele = Driver.getDriver().findElement(By.xpath("//li["+idx+"]"));
            ele.click();
            driver.until(ExpectedConditions.elementToBeClickable(photos));
            idx++;
            photos.click();
            driver.until(ExpectedConditions.elementToBeClickable(Addphotos));
            Addphotos.click();
            driver.until(ExpectedConditions.elementToBeClickable(browse));
            browse.click();

            stringSelection = new StringSelection((System.getProperty("user.dir") + "\\Bird.jpg"));
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Thread.sleep(1000);
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            submit.click();
//            driver.until(ExpectedConditions.elementToBeClickable(oneStar));
//            oneStar.click();
//            textarea.clear();
//            textarea.clear();
            textarea.sendKeys("");
            driver.until(ExpectedConditions.elementToBeClickable(submit));
            submit.click();
            driver.until(ExpectedConditions.elementToBeClickable(ok));
            ok.click();
            driver.until(ExpectedConditions.elementToBeClickable(navigateBack));
            navigateBack.click();
        }
    }
}
