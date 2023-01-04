/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package test;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.Setup;

/**
 * Class DataDrivenTestingUsingCSVLineaire
 */
public class DataDrivenTestingUsingCSVLineaire
{
    
    /** csv path. 
     * Provide test data CSV file path
     * */
    String CSV_PATH = "src/test/resources/data/TestData.csv";

    /** driver. */
    static WebDriver driver;

    /** csv reader. */
    private CSVReader csvReader;

    /** csv cell. */
    String[] csvCell;

    /**
     * methode Setup
     * Use below line to manage driver by WebDriverManager for chrome browser in our case
     * You can use any other driver of your choice
     *
     * @throws MalformedURLException the malformed URL exception
     */
    @Before
    public void setup() throws MalformedURLException
    {
        
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

    }

    /**
     * methode Data read CSV
     *
     * @throws CsvValidationException the csv validation exception
     * @throws IOException            Signal qu'une execption de type I/O s'est produite.
     */
    @Test
    public void dataRead_CSV() throws CsvValidationException, IOException
    {

        // Create an object of CSVReader
        csvReader = new CSVReader(new FileReader(CSV_PATH));

        Setup.getDriver().findElement(By.id("nav-link-accountList")).click();
        Setup.getDriver().findElement(By.id("createAccountSubmit")).click();

        // You can use while loop like below, It will be executed until the last linein CSV used.
        while ((csvCell = csvReader.readNext()) != null)
        {
            String CustomerName = csvCell[0];
            String CustomerEmail = csvCell[1];
            String CustomerPassword = csvCell[2];
            String CustomerConfirmPassword = csvCell[3];

            Setup.getDriver().findElement(By.id("ap_customer_name")).clear();
            Setup.getDriver().findElement(By.id("ap_customer_name")).sendKeys(CustomerName);
            Setup.getDriver().findElement(By.id("ap_email")).clear();
            Setup.getDriver().findElement(By.id("ap_email")).sendKeys(CustomerEmail);
            Setup.getDriver().findElement(By.id("ap_password")).clear();
            Setup.getDriver().findElement(By.id("ap_password")).sendKeys(CustomerPassword);
            Setup.getDriver().findElement(By.id("ap_password_check")).clear();
            Setup.getDriver().findElement(By.id("ap_password_check")).sendKeys(CustomerConfirmPassword);
            Setup.getDriver().findElement(By.id("continue")).click();

        }

    }

    /**
     * methode Exit.
     */
    @After
    public void exit()
    {
        driver.close();
        driver.quit();
    }

}
