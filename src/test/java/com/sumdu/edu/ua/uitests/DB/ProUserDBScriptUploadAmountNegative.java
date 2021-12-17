package com.sumdu.edu.ua.uitests.DB;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.ScriptPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS1;

public class ProUserDBScriptUploadAmountNegative extends BaseTest
{
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void basicUserdBScriptUploadPositiv() throws IOException {
        String folderName = "/DB/ProUserDBScriptUploadAmountNegative";
        boolean error;

        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/script.sql");

        ScriptPage userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS1)
                .clickProfileButton()
                .UpgradeRole()
                .BackToHomePage()
                .ClickCreateDB()
                .clickScript()
                .upload("script_1", file.getAbsolutePath())
                .upload("script_2", file.getAbsolutePath())
                .upload("script_3", file.getAbsolutePath())
                .upload("script_4", file.getAbsolutePath())
                .upload("script_5", file.getAbsolutePath());
        String url = webDriver.getCurrentUrl();

        userInformation.capture(folderName);
        error = userInformation.scriptAmountErrorIsDisplayed();
        Assert.assertTrue(error);
    }
}
