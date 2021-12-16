package com.sumdu.edu.ua.uitests.login;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.HomePage;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.properties.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

public class LoginTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveLoginTest() throws IOException {
        String s = "/login/LoginTest";
        LoginPage loginPage = new LoginPage(webDriver);
        HomePage userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS);

        userInformation.capture(s);
        String label = userInformation.getUserInformationLabel();
        Assert.assertEquals("oleg.anischenko00+b@gmail.com",label, "User nicks are not equals");
    }


}



