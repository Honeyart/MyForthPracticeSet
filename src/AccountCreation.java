import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AccountCreation {
    @Test
    public void testCase() {

        System.setProperty("Webdriver.chrome.driver", "/home/onwardhealth/Workspace/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");
        //Click Signin
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //driver.quit();
		///Enter email Adres
		driver.findElement(By.id("email_create")).sendKeys(RandomStringUtils.randomAlphabetic(5)+"@mailinator.com");

		//Click Create Account Button
		driver.findElement(By.id("SubmitCreate")).click();

		WebDriverWait wait=new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
		//enter firstname
		driver.findElement(By.id("customer_firstname")).sendKeys("Test");

		//enter firstname
		driver.findElement(By.id("customer_lastname")).sendKeys("Test");

		//enter password
		driver.findElement(By.id("passwd")).sendKeys("Test@123");


		//Handel DropDOwn
		WebElement ele=driver.findElement(By.id("days"));
		Select s=new Select(ele);
		s.selectByValue("9");

		//select months
		new Select(driver.findElement(By.id("months"))).selectByValue("9");

		//Select Year
		new Select(driver.findElement(By.id("years"))).selectByValue("2017");

		//Enter Address
		driver.findElement(By.id("address1")).sendKeys("test");

		//Enter City
		driver.findElement(By.id("city")).sendKeys("city");

		//select state
		new Select(driver.findElement(By.id("id_state"))).selectByValue("5");


		//enter zipcode
		driver.findElement(By.id("postcode")).sendKeys("11111");

		//enter phone number
		driver.findElement(By.id("phone_mobile")).sendKeys("1111111111");

		//enter alias
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("test");

		driver.findElement(By.id("submitAccount")).click();


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='info-account']")));

		//Get Text From App
		String actualText=driver.findElement(By.xpath("//p[@class='info-account']")).getText();

		System.out.println(actualText);

		String expectedText="Welcome to your account. Here you can manage all of your personal information and orders.";



		if(expectedText.equals(actualText))
			System.out.println("Test Case Pass");
		else
			System.out.println("Test case fail");

		//driver.quit();

    }


}

