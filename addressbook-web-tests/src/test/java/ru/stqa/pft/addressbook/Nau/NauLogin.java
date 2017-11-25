package ru.stqa.pft.addressbook.Nau;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.HelperBase;

import java.util.concurrent.TimeUnit;

public class NauLogin {
    ChromeDriver wd;

    @BeforeMethod
    public void  setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://my.nau.io/auth/login");
        login();
    }

    private void login() {
        wd.findElement(By.xpath("/html/body/div/section/div[1]/form/div[2]/input")).click();
        wd.findElement(By.xpath("/html/body/div/section/div[1]/form/div[2]/input")).clear();
        wd.findElement(By.xpath("/html/body/div/section/div[1]/form/div[2]/input")).sendKeys("ya_stepanova@mail.ru");
        wd.findElement(By.xpath("/html/body/div/section/div[1]/form/div[3]/input")).click();
        wd.findElement(By.xpath("/html/body/div/section/div[1]/form/div[3]/input")).clear();
        wd.findElement(By.xpath("/html/body/div/section/div[1]/form/div[3]/input")).sendKeys("11111111");
        wd.findElement(By.xpath("/html/body/div/section/div[1]/form/div[4]/div[2]/button")).click();
    }

    @Test
    public void testNauLogin() {
        goToProfile();
    }

    private void goToProfile() {
        wd.findElement(By.xpath("/html/body/header/div/div[3]/a")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public static  boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}

