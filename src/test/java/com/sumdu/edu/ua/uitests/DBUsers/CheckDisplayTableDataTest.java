package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;

// Test Case 34 - Display Table Data Check (Database Page)
public class CheckDisplayTableDataTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void checkDisplayTableData() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean checkDisplayTableData = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB()
                .clickDataExplorerButton()
                .positiveCheckDisplayTableData();

        Assert.assertTrue(checkDisplayTableData);
    }
}
