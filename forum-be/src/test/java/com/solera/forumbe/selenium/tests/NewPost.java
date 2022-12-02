package com.solera.forumbe.selenium.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import com.solera.forumbe.selenium.configurations.BrowserType;
import com.solera.forumbe.selenium.configurations.DriverFactory;

@SpringBootTest
public class NewPost {
    
    @BeforeAll
    public static void setUp(){
         System.setProperty("webdriver.chrome.driver",
         "C:\\Users\\Andrea.Colucci\\selenium-java-4.6.0\\chromeDriver\\chromedriver_win32\\chromedriver.exe");
    }

    @Test
    void test(){
        WebDriver webDriver = DriverFactory.getInstance().getDriver(BrowserType.CHROME);
        webDriver.get("http://localhost:3000/NewPost");

        WebElement title = webDriver.findElement(By.id("inputTitle"));

        title.sendKeys("Correct Title");

        WebElement button;//TODO the button id
    }
}
