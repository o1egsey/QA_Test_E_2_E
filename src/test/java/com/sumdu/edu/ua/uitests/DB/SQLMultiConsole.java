package com.sumdu.edu.ua.uitests.DB;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.SQLPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS1;

public class SQLMultiConsole extends BaseTest
{
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void dbRunScript() throws IOException {
        String folderName = "/DB/SQLMultiConsole";
        boolean error;

        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/script.sql");

        SQLPage userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS1)
                .ClickCreateDB()
                .clickSQL()
                .enterCommmand("\n" +
                        "CREATE TABLE Customers\n" +
                        "(\n" +
                        "    Id INT,\n" +
                        "    Age INT,\n" +
                        "    FirstName NVARCHAR(20),\n" +
                        "    LastName NVARCHAR(20),\n" +
                        "    Email VARCHAR(30),\n" +
                        "    Phone VARCHAR(20)\n" +
                        ")")
                .enterCommmand("CREATE TABLE table2\n" +
                        "(\n" +
                        "    Id INT,\n" +
                        "    Age INT,\n" +
                        "    FirstName NVARCHAR(20),\n" +
                        "    Email VARCHAR(30),\n" +
                        "    Phone VARCHAR(20)\n" +
                        ")")
                .runCommand();
        String url = webDriver.getCurrentUrl();

        userInformation.capture(folderName);
        error = userInformation.resultSQL();
        Assert.assertTrue(error);
    }
}
