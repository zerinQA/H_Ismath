//Case 1: Verify registration with valid data
package Pharmacy;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\libs\\selenium-jars\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://edgebook.wuaze.com/index.php");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("User01");
        driver.findElement(By.name("email")).sendKeys("user01@example.com");
        driver.findElement(By.name("password")).sendKeys("Password@123");
        driver.findElement(By.name("submit")).click();
        String acting_url = driver.getCurrentUrl();
        String desired_url = "http://edgebook.wuaze.com/welcome.php";
        if (acting_url.equals(desired_url)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.quit();
    }
}
