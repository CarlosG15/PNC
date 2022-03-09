package objDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class objDriver {

    private WebDriver driver;
    public String URL;
    public WebDriverWait objWait;

    public objDriver(WebDriver driver) {
        this.driver = driver;
        URL="https://www.pnc.com/en/personal-banking.html";
    }

    public WebDriver openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlos.gallardo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver pagePNC(){
        driver.get(URL);
        return driver;
    }

    public WebElement credentials(final String strLocator){
        WebElement credential = driver.findElement(By.xpath(strLocator));
        return credential;
    }

    public WebElement vWallet(){
        try {
            driver.switchTo().frame("center");
            WebElement wallet = driver.findElement(By.xpath("//a[contains(text(),'Virtual')]"));
            return wallet;
        }
        catch (Exception wallet){
            System.out.println("WebElement is not recognized");
            return null;
        }
    }

    public boolean Click(final String strLocator){
        WebElement clickable;
        objWait = new WebDriverWait(driver, 10);
        clickable = objWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(strLocator))));
        clickable.click();
        return false;
    }

    public void close(){
        driver.close();
        driver.quit();
    }

}
