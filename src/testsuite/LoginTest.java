package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {
    String baseurl = "https://courses.ultimateqa.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.linkText("Sign In"));

        String actualMsg = verifyText(By.xpath("//h1[normalize-space()='Welcome Back!']"));
        Assert.assertEquals("Welcome Back!", actualMsg);
    }

    @Test
    public void verifyTheErrorMessage() {
        clickOnElement(By.xpath("//section//a[normalize-space()='Sign In']"));
        sendTextToElement(By.xpath("//input[@type='email']"), "kishan-0204@yahoo.co.in");
        sendTextToElement(By.xpath("//input[@type='password']"), "123456");
        clickOnElement(By.xpath("//input[@value='Sign in']"));

        String actualMsg1 = verifyText(By.xpath("//li[@role='alert']"));
        Assert.assertEquals("Invalid email or password.", actualMsg1);

        //sendTextToElement(By.xpath("//input[@id='user"),);
        // clickOnElement(By.xpath("//li[@role='alert']"));

    }

    @After
    public void testDown() {
        closeBrowser();
    }
}