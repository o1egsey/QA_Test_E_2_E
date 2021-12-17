package com.sumdu.edu.ua.uitests.profile;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import static com.sumdu.edu.ua.properties.Properties.*;

public class DeleteAccountTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void deleteUserAccount() throws IOException {
        String folderName = "/Profile/DeleteAccountTest";
        boolean error;

        LoginPage loginPage = new LoginPage(webDriver);

        ProfilePage deleteUserAccount = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .clickProfileButton()
                .deleteUserAcc();

        deleteUserAccount.capture(folderName);
        error = deleteUserAccount.deleteAccObservationElementIsDisplayed();
        Assert.assertTrue(error);
    }
}
