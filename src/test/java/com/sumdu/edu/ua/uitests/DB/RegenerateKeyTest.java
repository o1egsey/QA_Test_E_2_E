package com.sumdu.edu.ua.uitests.DB;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.ProfilePage;
import com.sumdu.edu.ua.properties.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegenerateKeyTest extends BaseTest
{
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveLoginTest() throws IOException {
        String folderName = "/DB/RegenerateKeyTest";
        boolean error;

        LoginPage loginPage = new LoginPage(webDriver);
        String [] keysOld, keysNew;
        ProfilePage profilePage = loginPage
                .open()
                .login(Properties.ELEPHANT_LOGIN, Properties.ELEPHANT_PASS)
                .clickProfileButton();
        keysOld = profilePage.getKeyValue();
        profilePage.regenerate();
        keysNew = profilePage.getKeyValue();

        profilePage.capture(folderName);
        error = keysNew.equals(keysOld);
        Assert.assertFalse(error);
    }
}
