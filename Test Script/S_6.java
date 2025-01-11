//Case 6: Verify special characters in username
package Pharmacy;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\libs\\selenium-jars\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://edgebook.wuaze.com/index.php");

        Thread.sleep(1000);

        // Using a username with special characters
        driver.findElement(By.name("username")).sendKeys("User@123");
        driver.findElement(By.name("email")).sendKeys("user06@example.com");
        driver.findElement(By.name("password")).sendKeys("Password@123");
        driver.findElement(By.name("submit")).click();

        // Verifying the error message
        String errorMessage = driver.findElement(By.id("error")).getText();
        if (errorMessage.contains("Special characters are not allowed in username")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.quit();
    }
}
