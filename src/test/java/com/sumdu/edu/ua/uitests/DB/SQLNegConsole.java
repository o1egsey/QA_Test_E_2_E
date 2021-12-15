package com.sumdu.edu.ua.uitests.DB;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS1;

public class SQLNegConsole extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void dbRunScript() {
        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/script.sql");

        boolean userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS1)
                .ClickCreateDB()
                .clickSQL()
                .enterCommmand("\n" +
                        "CREATE TABLE Customers\n" +
                        "(\n" +
                        "    Id INT,\n" +
                        "    Age INT,\n" +
                        "    FirstName NVARCHAR(20)\n" +
                        "    LastName NVARCHAR(20),\n" +
                        "    Email VARCHAR(30),\n" +
                        "    Phone VARCHAR(20)\n" +
                        ")")
                .resultSQL();

        String url = webDriver.getCurrentUrl();
        Assert.assertTrue(userInformation);
    }
}