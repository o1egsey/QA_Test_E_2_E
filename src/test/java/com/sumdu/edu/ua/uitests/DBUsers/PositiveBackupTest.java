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

// Test Case 35 - Positive Backup Test (Backup Page)
public class PositiveBackupTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void positiveBackup() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        String folderName = "/DBUsers/PositiveBackupTest";
        boolean check;
        DBPage positiveBackup = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .ClickCreateDB();


        PointPage pp = positiveBackup.clickBackupButton().
                positiveBackup(BACKUP_NAME);

        positiveBackup.capture(folderName);
        pp.capture(folderName);

        check = pp.backupObservationElementIsDisplayed();
        Assert.assertTrue(check);
    }

}

