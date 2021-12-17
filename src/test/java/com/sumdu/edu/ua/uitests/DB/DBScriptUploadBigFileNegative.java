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

public class DBScriptUploadBigFileNegative extends BaseTest
{
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void dBScriptUploadPositiv() throws IOException {
        String folderName = "/DB/DBScriptUploadBigFileNegative";
        boolean error;

        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/script2.sql");

        ScriptPage userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS1)
                .ClickCreateDB()
                .clickScript()
                .upload("script2", file.getAbsolutePath());
        String url = webDriver.getCurrentUrl();

        userInformation.capture(folderName);
        error = userInformation.check();
        Assert.assertTrue(error);
    }
}
