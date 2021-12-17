package com.sumdu.edu.ua.uitests.DB;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import static com.sumdu.edu.ua.properties.Properties.*;

public class ChangeDBPasswordTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void changeWebPassword() throws IOException {
        String folderName = "/DB/ChangeDBPasswordTest";
        boolean error;

        LoginPage loginPage = new LoginPage(webDriver);

        ProfilePage positiveChangePass = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickProfileButton()
                .changeDBPassword(NEW_PASS);

        positiveChangePass.capture(folderName);
        error = positiveChangePass.changePassAlertIsDisplayed();
        Assert.assertTrue(error);
    }
}
