package com.sumdu.edu.ua.uitests.profile;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import static com.sumdu.edu.ua.properties.Properties.*;

public class ChangeWebPasswordTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void changeWebPassword() throws IOException {
        String folderName = "/Profile/ChangeWebPasswordTest";
        boolean error;

        LoginPage loginPage = new LoginPage(webDriver);

        ProfilePage positiveChangePass = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .clickProfileButton()
                .changeWebPassword(WEB_PASSWORD, WEB_PASSWORD_1);

        positiveChangePass.capture(folderName);
        error = positiveChangePass.changePassObservationElementIsDisplayed();
        Assert.assertTrue(error);
    }
}
