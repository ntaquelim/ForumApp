package com.solera.forumbe.selenium.configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    
    private static DriverFactory driverFactory = new DriverFactory();

    private DriverFactory(){}

    public static DriverFactory getInstance(){
        return driverFactory;
    }

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver(BrowserType type){

        switch(type){
            case CHROME:
                threadLocal.set(new ChromeDriver());
                break;
            case FIREFOX:
                threadLocal.set(new FirefoxDriver());
                break;
            default://By default we choose chrome
                threadLocal.set(new ChromeDriver());
                break;
        }

        return threadLocal.get();
    }
}
