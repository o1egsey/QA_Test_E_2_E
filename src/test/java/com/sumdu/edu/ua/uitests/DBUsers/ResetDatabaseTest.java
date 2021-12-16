package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.PointPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

// Test Case 38 - Checking the reset of the database to the backup state (Backup Page)
public class ResetDatabaseTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void resetDatabase() throws IOException {

        String foldername = "/DBUsers/resetDatabase";
        boolean error;
        LoginPage loginPage = new LoginPage(webDriver);

        PointPage resetDatabase = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB()
                .clickBackupButton()
                .positiveBackup(BACKUP_NAME)
                .resetDatabase();


        resetDatabase.capture(foldername);
        error = resetDatabase.resetObservationElementIsDisplayed();
        Assert.assertTrue(error);
    }
}

