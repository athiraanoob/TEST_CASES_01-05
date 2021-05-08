package package_Name;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("http://iarchtaps.com:8080/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/child::li/following-sibling::li/a/child::em/child::span/span")).click();
      driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("456389870");
      driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
      Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[contains(@class,'x-form-item x-tab-item')]//div[contains(@class,'x-form-element')]//input[@name='firstName']")).sendKeys("Athi");;
        //driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
      String str=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).getText();
      driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
      driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
      driver.findElement(By.linkText("Find Leads")).click();
     
      //int m=Integer.parseInt(str);
      driver.findElement(By.xpath("//input[@name='id']")).sendKeys(""+str+"");
      driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
      Thread.sleep(6000);
      File src=driver.getScreenshotAs(OutputType.FILE);
      File des=new File("./1.png");
      FileUtils.copyFile(src, des);
      Thread.sleep(2000);
      driver.quit();
      
      
      
      
	}

}
