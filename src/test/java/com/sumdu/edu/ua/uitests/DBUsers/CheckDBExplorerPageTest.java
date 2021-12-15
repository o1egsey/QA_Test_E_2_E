package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.*;

// Test Case 33 - Database Explorer Page Check (Database Page)
public class CheckDBExplorerPageTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void checkDBExplorerPage() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean checkDBExplorerPage = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB()
                .positiveCheckDBExplorerPage();

        Assert.assertTrue(checkDBExplorerPage);
    }
}
