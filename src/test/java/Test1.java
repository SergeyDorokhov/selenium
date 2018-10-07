import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;

/**
 * Created by Doroh on 07.10.2018.
 */
public class Test1 {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void succesAuthorised() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@value='Login']")).click();
        String title = driver.findElement(By.xpath("//title")).getAttribute("innerText");
        Assert.assertThat(title, is("My Store"));
    }

    @After
    public void finish() {
        driver.quit();
        driver = null;
    }
}