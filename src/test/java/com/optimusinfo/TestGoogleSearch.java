package GoogleSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.*;

public class TestGoogleSearch {

    public static void main(String[] args) {


    	        WebDriver driver=new FirefoxDriver();
    	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	        driver.get("http://www.google.com");
    	        //Maximize the Browser window
    	        driver.manage().window().maximize();

    	        //Get the current page URL and store the value in variable 'str'
    	        String str = driver.getCurrentUrl();

    	        //Print the value of variable in the console
    	        System.out.println("The current URL is " + str);
                driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    	        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("coelacanths");
    	        driver.findElement(By.xpath("//button[@name='btnG']")).click();
    	        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    	        driver.findElement(By.partialLinkText("Wikipedia")).click();
    	        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
    	        
    	        String currentURL = null;
                WebDriverWait wait = new WebDriverWait(driver, 10);
    	        
    	        ExpectedCondition e = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                    return (d.getCurrentUrl() != str);
                    }
                };

                wait.until(e);
                currentURL = driver.getCurrentUrl();
                System.out.println("The current URL has changed to: " + currentURL);
                
    	        /*
    	        String str2 = driver.getCurrentUrl();
    	        System.out.println("The current URL has changed to: " + str2);
    	        */
    	   }
}
