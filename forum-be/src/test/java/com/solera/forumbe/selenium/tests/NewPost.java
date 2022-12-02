package com.solera.forumbe.selenium.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewPost {
    
    @BeforeAll
    public static void setUp(){
         System.setProperty("webdriver.chrome.driver",
         "C:\\Users\\Andrea.Colucci\\selenium-java-4.6.0\\chromeDriver\\chromedriver_win32\\chromedriver.exe");
    }

    @Test
    void test(){
        
    }
}
