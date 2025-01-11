//Case 7: Verify excessively long username
package Pharmacy;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC7 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\libs\\selenium-jars\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://edgebook.wuaze.com/index.php");

        Thread.sleep(1000);

        // Using an excessively long username
        String longUsername = "a".repeat(101); // Creating a username with 101 characters
        driver.findElement(By.name("username")).sendKeys(longUsername);
        driver.findElement(By.name("email")).sendKeys("user07@example.com");
        driver.findElement(By.name("password")).sendKeys("Password@123");
        driver.findElement(By.name("submit")).click();

        // Verifying the error message
        String errorMessage = driver.findElement(By.id("error")).getText();
        if (errorMessage.contains("Username exceeds maximum length")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.quit();
    }
}
