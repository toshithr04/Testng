package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.IOException;

public class Main {

    @Test(dataProvider = "readExcel", dataProviderClass = DataProvidedExcel.class )
    public void login(String username, String password) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        System.out.println("hi");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@name = \"username\"]")).sendKeys(username);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name = \"password\"]")).sendKeys(password);


    }
}
