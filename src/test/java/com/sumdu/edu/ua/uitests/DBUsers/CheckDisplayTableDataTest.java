package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.TablePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;

// Test Case 34 - Display Table Data Check (Database Page)
public class CheckDisplayTableDataTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void checkDisplayTableData() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/script3.sql");
        String folderName = "/DBUsers/CheckDisplayTableDataTest";
        boolean error;

        TablePage checkDisplayTableData = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB().clickScript()
                .upload("sdf", file.getAbsolutePath())
                .runScript()
                .dBExplorerClick()
                .ClickdbTableName();
        checkDisplayTableData.capture(folderName);
        error = checkDisplayTableData.positiveCheckDisplayTablenInfo();

        Assert.assertTrue(error);
    }

}
