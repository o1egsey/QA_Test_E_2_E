package com.sumdu.edu.ua.uitests.DB;

        import com.sumdu.edu.ua.BaseTest;
        import com.sumdu.edu.ua.pageobject.pages.LoginPage;
        import org.testng.Assert;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.Test;

        import java.io.File;

        import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
        import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS1;

public class DBDeleteScript extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void dBScriptUploadPositiv() {
        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/script.sql");

        boolean userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS1)
                .ClickCreateDB()
                .clickScript()
                .upload("script", file.getAbsolutePath())
                .deleteScript()
                .checkDeletion();
        String url = webDriver.getCurrentUrl();
        Assert.assertTrue(userInformation);
    }
}

