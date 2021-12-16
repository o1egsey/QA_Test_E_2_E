package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.DBPage;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.PointPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

// Test Case 35 - Negative Backup Test (Backup Page)
public class NegativeBackupTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void negativeBackup() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        String s = "/DBUsers/NegativeBackupTest";
        boolean check;
        DBPage positiveBackup = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .ClickCreateDB();

        positiveBackup.capture(s);
        PointPage pp = positiveBackup.clickBackupButton()
                .positiveBackup(BACKUP_NAME);

        pp.capture(s);

        check = pp.backupObservationElementIsDisplayed();
        Assert.assertTrue(check);
    }

}

