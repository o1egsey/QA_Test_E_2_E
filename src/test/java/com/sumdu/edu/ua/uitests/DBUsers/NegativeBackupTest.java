package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.*;

// Test Case 35 - Negative Backup Test (Backup Page)
public class NegativeBackupTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void negativeBackup() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean negativeBackup = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB()
                .clickBackupButton()
                .negativeBackup(BACKUP_NAME)
                .backupObservationElementIsDisplayed();

        Assert.assertTrue(negativeBackup);
    }
}

