/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package test;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import page.DataDrivenTestingUsingCSVPage;
import util.Setup;

/**
 * Class DataDrivenTestingUsingCSV
 */
public class DataDrivenTestingUsingCSV extends Setup
{

    /** csv path. */
    // Provide test data CSV file path
    String CSV_PATH = "src/test/resources/data/TestData.csv";

    /** csv reader. */
    private CSVReader csvReader;

    /** csv cell. */
    String[] csvCell;

    /** data driven testing using CSV page. */
    private final DataDrivenTestingUsingCSVPage dataDrivenTestingUsingCSVPage;

    /**
     * Instanciation de atlas step definition.
     */
    public DataDrivenTestingUsingCSV()
    {
        this.dataDrivenTestingUsingCSVPage = new DataDrivenTestingUsingCSVPage();
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

        dataDrivenTestingUsingCSVPage.createAccount();

        // You can use while loop like below, It will be executed until the last linein CSV used.
        while ((csvCell = csvReader.readNext()) != null)
        {
            String CustomerName = csvCell[0];
            String CustomerEmail = csvCell[1];
            String CustomerPassword = csvCell[2];
            String CustomerConfirmPassword = csvCell[3];

            dataDrivenTestingUsingCSVPage.fillName(CustomerName);
            dataDrivenTestingUsingCSVPage.fillEmail(CustomerEmail);
            dataDrivenTestingUsingCSVPage.fillPassword(CustomerPassword);
            dataDrivenTestingUsingCSVPage.fillPasswordCheck(CustomerConfirmPassword);

            dataDrivenTestingUsingCSVPage.clickOnContinue();

        }

    }

}
