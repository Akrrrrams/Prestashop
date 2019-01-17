package com.prestashop.utilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class TestBase {
    public static WebDriver driver;
    SoftAssert softAssert;


    @BeforeMethod
    public void beforeEachtest() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);



//        ChromeDriverManager.getInstance(CHROME).setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//
//        chromeOptions.addArguments("--headless");
//        driver = new ChromeDriver(chromeOptions);


    }


    public static void serach(String url) {
        driver.get("https://www.Google.com");
        WebElement search = driver.findElement(By.name("q"));

        //  Go to http://automationpractice.com/index.php
        search.sendKeys(url + Keys.ENTER);
        WebElement clickLink = driver.findElement(By.xpath("//*[@class='LC20lb']"));
        clickLink.click();
    }


    // this is headless driver method it checks the website whithout going to website
    public static void setup() {

        ChromeDriverManager.getInstance(CHROME).setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
