package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;
import static com.sumdu.edu.ua.properties.Properties.BACKUP_NAME;

// Test Case 35 - Positive Backup Test (Backup Page)
public class PositiveBackupTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void positiveBackup() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean positiveBackup = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB()
                .clickBackupButton()
                .positiveBackup(BACKUP_NAME)
                .backupObservationElementIsDisplayed();

        Assert.assertTrue(positiveBackup);
    }
}

