package ru.stqa.pft.addressbook.Nau;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NauRegistration {
    ChromeDriver wd;

    @BeforeMethod
    public void  setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://tokensale.nau.io/ru/");
        registration();
    }

    private void registration() {
        wd.findElement(By.xpath("/html/body/div[1]/header/div/div/div[4]/a[2]")).click();
        wd.findElement(By.xpath("//*[@id=\"inputEmail\"]")).click();
        wd.findElement(By.xpath("//*[@id=\"inputEmail\"]")).clear();
        wd.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("tst1@mail.ru");
        wd.findElement(By.xpath("//*[@id=\"inputFirstName\"]")).click();
        wd.findElement(By.xpath("//*[@id=\"inputFirstName\"]")).clear();
        wd.findElement(By.xpath("//*[@id=\"inputFirstName\"]")).sendKeys("test1");
        wd.findElement(By.xpath("//*[@id=\"inputLastName\"]")).click();
        wd.findElement(By.xpath("//*[@id=\"inputLastName\"]")).clear();
        wd.findElement(By.xpath("//*[@id=\"inputLastName\"]")).sendKeys("test1");
        wd.findElement(By.xpath("//*[@id=\"password\"]")).click();
        wd.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        wd.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("11111111");
        wd.findElement(By.xpath("//*[@id=\"matchPassword\"]")).click();
        wd.findElement(By.xpath("//*[@id=\"matchPassword\"]")).clear();
        wd.findElement(By.xpath("//*[@id=\"matchPassword\"]")).sendKeys("11111111");
        wd.findElement(By.xpath("//*[@id=\"registration_form\"]/div[8]/div/button")).click();
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
