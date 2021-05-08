package package_Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002 {

	public static void main(String[] args) throws InterruptedException {
		StringBuffer v=new StringBuffer();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("http://iarchtaps.com:8080/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Find Leads")).click();
       driver.findElement(By.xpath("//div[contains(@class,'x-form-item x-tab-item')]//div[contains(@class,'x-form-element')]//input[@name='firstName']")).sendKeys("Athi");;
       driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
       Thread.sleep(2000);

       String text = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).getText();
       System.out.println("*****"+text);
       driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
       String txt=driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
       //System.out.println(txt);
       if(txt.equals("View Lead"))
       {
    	   System.out.println("You were in current page");
       }
       else
       {
    	   System.out.println("You were not in intented page");
       }
       driver.findElement(By.className("subMenuButton")).click();
       driver.findElement(By.xpath("//div[@class='fieldgroup-body']/child::table/child::tbody/child::tr/child::td/following-sibling::td/child::input")).clear();
       driver.findElement(By.xpath("//div[@class='fieldgroup-body']/child::table/child::tbody/child::tr/child::td/following-sibling::td/child::input")).sendKeys("NewCompany");
       driver.findElement(By.className("smallSubmit")).click();
       String s=driver.findElement(By.id("viewLead_companyName_sp")).getText();
       System.out.println(s);
       for(int i=0;i<=s.length();i++)
       {
    	   if(s.charAt(i)!=' ')
    	   {
    		  v.append(s.charAt(i));
    	   }
    	   else
    	   {
    		   break;
    	   }
       }
       System.out.println(v);
       
       if((v.toString()).equals("NewCompany"))
       {
    	   System.out.println("Updation Happend,Company Changed");
       }
      // driver.findElement(By.linkText("10221")).click();
	}

}
