package com.solera.forumbe.selenium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import com.solera.forumbe.selenium.configurations.BrowserType;
import com.solera.forumbe.selenium.configurations.DriverFactory;

@SpringBootTest
public class HomePage {

    @BeforeAll
    public static void setUp(){
         System.setProperty("webdriver.chrome.driver",
         "C:\\Users\\Andrea.Colucci\\selenium-java-4.6.0\\chromeDriver\\chromedriver_win32\\chromedriver.exe");
        }

    @Test
    void homePage_ClickFirstButton_NewPostPage(){
        WebDriver webDriver = DriverFactory.getInstance().getDriver(BrowserType.CHROME);
        webDriver.get("http://localhost:3000");

        WebElement firstButton = webDriver.findElement(By.id("thread1"));
        firstButton.click();

        String resultUrl = webDriver.getCurrentUrl();
        assertEquals("http://localhost:3000/NewPost", resultUrl);

        webDriver.quit();
    }

    @Test
    void homePage_ClickSecondButton_NewPostPage(){
        WebDriver webDriver = DriverFactory.getInstance().getDriver(BrowserType.CHROME);
        webDriver.get("http://localhost:3000");

        WebElement secondButton = webDriver.findElement(By.id("thread2"));
        secondButton.click();

        String resultUrl = webDriver.getCurrentUrl();
        assertEquals("http://localhost:3000/NewPost", resultUrl);

        webDriver.quit();
    }

    @Test
    void homePage_ClickThirdButton_NewPostPage(){
        WebDriver webDriver = DriverFactory.getInstance().getDriver(BrowserType.CHROME);
        webDriver.get("http://localhost:3000");

        WebElement thirdButton = webDriver.findElement(By.id("thread3"));
        thirdButton.click();

        String resultUrl = webDriver.getCurrentUrl();
        assertEquals("http://localhost:3000/NewPost", resultUrl);

        webDriver.quit();
    }
}
