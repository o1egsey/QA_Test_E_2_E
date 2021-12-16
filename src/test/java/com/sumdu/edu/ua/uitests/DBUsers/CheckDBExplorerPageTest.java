package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.TablePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

// Test Case 33 - Database Explorer Page Check (Database Page)
public class CheckDBExplorerPageTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void checkDBExplorerPage() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/script3.sql");
        String folderName = "/DBUsers/CheckDBExplorerPageTest";
        boolean error;

        TablePage checkDBExplorerPage = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB()
                .clickScript()
                .upload("script 3", file.getAbsolutePath())
                .runScript()
                .dBExplorerClick();

        checkDBExplorerPage.capture(folderName);

        error = checkDBExplorerPage.positiveCheckDisplayTableData();

        Assert.assertTrue(error);
    }

}
