import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class BaiKiemTra1 {
    WebDriver driver = new ChromeDriver(); //Mở trình duyệt chrome

    @Test
    public void Case() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://cms.anhtester.com/login");
        Thread.sleep(2000);

        //Login
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1000);

        //CLick vào menu
        driver.findElement(By.xpath("//span[text()='Products']")).click();
        driver.findElement(By.xpath("//span[text()='Category']")).click();
        driver.findElement(By.xpath("//span[text()='Add New category']")).click();

        //case 1
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);

        //case 2
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Nguyen Thu Ha");
        driver.findElement(By.xpath("//div[text()='No Parent']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li//a//span[text()='Sport shoes']")).click();
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("0345923535");
        driver.findElement(By.xpath("//div[text()='Physical']")).click();
        driver.findElement(By.xpath("//li//a//span[text()='Digital']")).click();
        Thread.sleep(1000);

        //chọn ảnh
        driver.findElement(By.xpath("//div[@class='form-control file-amount'][normalize-space()='Choose File']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("drink");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@class='img-fit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Add Files']")).click();
        Thread.sleep(1000);

        //chọn icon
        driver.findElement(By.xpath("//div[@class='form-control file-amount'][normalize-space()='Choose File']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("cooking");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@title='cookingrice.png']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Add Files']")).click();
        Thread.sleep(1000);

        //Nhập Meta title
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("HiHi");
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("HiHi");
        Thread.sleep(1000);

        //Chọn Filtering Attributes
        driver.findElement(By.xpath("//div[text()='Nothing selected']")).click();
        driver.findElement(By.xpath("//li//a//span[text()='Fabric']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

    }

    @Test
    public void Verify() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Nguyen Thu Ha");
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        String categoryName = "Nguyen Thu Ha";
        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(3000);
        String getCategoryName = driver.findElement(By.xpath("//td[normalize-space()='Nguyen Thu Ha']")).getText();
        Assert.assertEquals(categoryName, getCategoryName, "FAILED. Category Name not match.");
        Thread.sleep(3000);

        driver.quit();
    }

}
