package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.PointPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

// Test Case 39 - Remove the backup (Backup Page)
public class RemoveBackupTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void removeDatabase() throws IOException {

        String foldername = "/DBUsers/removeDatabase";
        boolean error;
        LoginPage loginPage = new LoginPage(webDriver);

        PointPage removeDatabase = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB()
                .clickBackupButton()
                .positiveBackup(BACKUP_NAME)
                .removeDatabase();


        removeDatabase.capture(foldername);
        error = removeDatabase.removeObservationElementIsDisplayed();
        Assert.assertTrue(error);
    }
}
