package package_Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("http://iarchtaps.com:8080/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
        driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a/img")).click();
        Set<String> st=driver.getWindowHandles();
        List<String> li=new ArrayList<String>(st);
        driver.switchTo().window(li.get(1));
        driver.findElement(By.xpath("//input[@id='ext-gen25']")).sendKeys("10169");
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td/div/child::a")).click();
         driver.switchTo().window(li.get(0));
        driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a/child::img")).click();
        //Thread.sleep(2000);
         st=driver.getWindowHandles();
         li.addAll(st);
        System.out.println(li.size());
        driver.switchTo().window(li.get(3));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']/child::div/child::input")).sendKeys("10173");
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td/div/child::a")).click();
        driver.switchTo().window(li.get(0));
        driver.findElement(By.xpath("//a[text()='Merge']")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
        driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10169");
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        driver.quit();
	}

}
