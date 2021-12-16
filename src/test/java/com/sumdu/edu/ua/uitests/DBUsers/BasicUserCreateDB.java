package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.DBPage;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.properties.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import static com.sumdu.edu.ua.properties.Properties.*;

public class BasicUserCreateDB extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveBasicUserDBCreation() throws IOException{

        String foldername = "/DBUsers/positiveBasicUserDBCreation";
        boolean error;
        LoginPage loginPage = new LoginPage(webDriver);
        DBPage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB();


        fineUpgrade.capture(foldername);
        error = fineUpgrade.dBObservationElementIsDisplayed();
        Assert.assertTrue(error);
    }
}

