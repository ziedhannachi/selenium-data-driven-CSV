/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package util;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Class Setup.
 */
public class Setup
{

    /** driver. */
    private static WebDriver driver;

    /**
     * methode Setup. Use below line to manage driver by WebDriverManager for chrome browser in our case You can use any
     * other driver of your choice
     *
     * @throws MalformedURLException the malformed URL exception
     */
    @Before
    public void setup() throws MalformedURLException
    {

        WebDriverManager.chromiumdriver().setup();
        setDriver(new ChromeDriver());
        getDriver().get("https://www.amazon.com/");

    }

    /**
     * methode Exit
     */
    @After
    public void exit()
    {
        getDriver().close();
        getDriver().quit();
    }

    /**
     * Accesseur de l attribut driver.
     *
     * @return driver
     */
    public static WebDriver getDriver()
    {
        return driver;
    }

    /**
     * Modificateur de l attribut driver.
     *
     * @param driver le nouveau driver
     */
    public static void setDriver(WebDriver driver)
    {
        Setup.driver = driver;
    }

}
