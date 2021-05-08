package package_Name;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("http://iarchtaps.com:8080/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/child::li/following-sibling::li/following-sibling::li/a/child::em/child::span/span")).click();
        driver.findElement(By.name("emailAddress")).sendKeys("aaa@gmail.com");
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(2000);
        String str=driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[3]/child::div/a")).getText();
        driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]/child::div/a")).click();
        driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
        String str1=driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
        if(str1.equals("Duplicate Lead"))
        {
        	System.out.println("We are going to duplicate the intented one");
        }
        driver.findElement(By.className("smallSubmit")).click();
       String str2=driver.findElement(By.id("viewLead_firstName_sp")).getText();
      // StringBuffer str3=new StringBuffer();
      /* for(int i=0;i<=str2.length();i++)
       {
    	 if(str2.charAt(i)!='(')
    	 {
    		 str3.append(str2.charAt(i));
    	 }
    	 else
    	 {
    		 break;
    	 }
       }*/
       System.out.println((str2.toString()).trim()+str);
        if(((str2.toString()).trim()).equals(str))
        {
        	System.out.println("This is the duplicate of same company");
        }
        

	}

}
