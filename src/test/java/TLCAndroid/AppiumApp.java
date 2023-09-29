package TLCAndroid;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AppiumApp extends TLCBase {

	@Test
	public void AppiumTest() throws MalformedURLException, InterruptedException 
	{
		
		//By allowButtonLocator = By.id("com.android.permissioncontroller:id/permission_allow_button");
		//driver.findElement(allowButtonLocator).click();

		// driver.findElement(By.xpath("(android.widget.Button[@text='Allow']")).click();

		// driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.theluxurycloset.tclapplication:id/button_login")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.theluxurycloset.tclapplication:id/textField_email")).sendKeys("tarangtest@yopmail.com");
		driver.findElement(By.id("com.theluxurycloset.tclapplication:id/textField_password")).sendKeys("test1234");
		//Thread.sleep(5000);
		driver.findElement(By.id("com.theluxurycloset.tclapplication:id/button_normal_login")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.id("com.theluxurycloset.tclapplication:id/tvNotReadyToSignUp")).click();
		
		Thread.sleep(5000);
//		List<WebElement> images = driver.findElements(By.id("countryImage"));
//		images.get(0).click();
//
//		images = driver.findElements(By.id("poster"));
//		images.get(1).click();
//
//		images = driver.findElements(By.id("product_item_image"));
//		images.get(0).click();
//
//		//driver.findElement(By.xpath("(//android.widget.Button)[2]")).click(); // Add to Bag
//		Thread.sleep(5000);
		//driver.findElement(By.xpath("(//android.widget.Button)[2]")).click(); // Go to Bag
		//driver.findElement(By.xpath("//android.widget.Button[@text='CHECKOUT']")).click(); // Cart
		//driver.findElement(By.xpath("//android.widget.Button[@text='CHECKOUT']")).click(); // Checkout address

		//driver.findElement(By.id("com.theluxurycloset.tclapplication:id/cardNumber")).sendKeys("4242424242424242");
		//driver.findElement(By.id("com.theluxurycloset.tclapplication:id/nameOnCard")).sendKeys("Tarang");
		//driver.findElement(By.id("com.theluxurycloset.tclapplication:id/expiryMMYY")).sendKeys("10/23");
		//driver.findElement(By.id("com.theluxurycloset.tclapplication:id/cvv")).sendKeys("100");

		//driver.findElement(By.id("com.theluxurycloset.tclapplication:id/button_buyNow")).click();
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys("Checkout1!");
		//driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();

		//driver.findElement(By.id("com.theluxurycloset.tclapplication:id/cashOnDelivery")).click();
		// //COD
		driver.quit();

	}

}
