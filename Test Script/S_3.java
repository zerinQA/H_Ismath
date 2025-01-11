//Case 3: Verify registration without mandatory fields
package Pharmacy;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\libs\\selenium-jars\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://edgebook.wuaze.com/index.php");

        Thread.sleep(1000);

        driver.findElement(By.name("username")).sendKeys("User03");
        driver.findElement(By.name("password")).sendKeys("Password@123");
        driver.findElement(By.name("submit")).click();

        String errorMessage = driver.findElement(By.id("error")).getText();
        if (errorMessage.contains("Mandatory fields missing")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.quit();
    }
}
