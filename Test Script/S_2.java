//Case 2: Verify registration with invalid email
package Pharmacy;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\libs\\selenium-jars\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://edgebook.wuaze.com/index.php");

        Thread.sleep(1000);

        driver.findElement(By.name("username")).sendKeys("User02");
        driver.findElement(By.name("email")).sendKeys("user.com"); // Invalid email
        driver.findElement(By.name("password")).sendKeys("Password@123");
        driver.findElement(By.name("submit")).click();

        String errorMessage = driver.findElement(By.id("error")).getText();
        if (errorMessage.contains("Invalid email format")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.quit();
    }
}
