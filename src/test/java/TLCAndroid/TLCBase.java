package TLCAndroid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TLCBase {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService server;
	String userName = System.getenv("BROWSERSTACK_USERNAME");
	String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
	String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
	String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
	String app = System.getenv("BROWSERSTACK_APP_ID");
	
	@BeforeClass
	public void ConfigureAppium () throws MalformedURLException, InterruptedException
	{
	
DesiredCapabilities caps = new DesiredCapabilities();
    	
    	// Set your access credentials
    	caps.setCapability("browserstack.user", "YOUR_USERNAME");
    	caps.setCapability("browserstack.key", "YOUR_ACCESS_KEY");
    	
    	// Set URL of the application under test
    	caps.setCapability("app", "bs://ab990ebb5aa2bb23161aac4fb90cd6531f0117cd");
    	
    	// Specify device and os_version for testing
    	caps.setCapability("platformName", "android");
    	caps.setCapability("deviceName", "Samsung Galaxy S.*");
    	caps.setCapability("platformVersion", "1[012]");
        
    	caps.setCapability("automationName", "Appium");
    	
    	// Set other BrowserStack capabilities
    	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
    	browserstackOptions.put("appiumVersion", "2.0.1");
    	browserstackOptions.put("project", "AndroidAppium");
    	browserstackOptions.put("build", "browserstack-build-1");
    	browserstackOptions.put("name", "first_test");
    	browserstackOptions.put("buildTag", "reg");
    	browserstackOptions.put("networkLogs", "true");
    	browserstackOptions.put("debug", "true");
    	caps.setCapability("bstack:options", browserstackOptions);
    	
    	// Initialize the remote Webdriver using BrowserStack remote URL
    	// and desired capabilities defined above
        AndroidDriver driver = new AndroidDriver(
        		new URL("http://hub.browserstack.com/wd/hub"), caps);
         
        
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
        
        
        
        
        
		//HashMap<String, String> environment = new HashMap<String, String>();
		//environment.put("PATH", "C:\\Users\\TARANG\\AppData\\Roaming\\npm\\node_modules\\.bin" + System.getenv("PATH"));
		
		 //AppiumServiceBuilder builder = new AppiumServiceBuilder();
	     //builder
	     	//	 .withAppiumJS(new File("C:\\Users\\TARANG\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	        //   .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
	        // .usingPort(4723)
	        //     .withEnvironment(environment)
	        //     .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
	        //     .withLogFile(new File("AppiumLog.txt"));
	 
	   //  server = AppiumDriverLocalService.buildService(builder);
	     
	   //  System.out.println("Server started at :"+server.getUrl());
	   
	//	server.start();
	//	System.out.println("Server is Started.");
		
		//service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\TARANG\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			//	.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		//service.start();
		
	//	UiAutomator2Options options = new UiAutomator2Options();
	//	options.setDeviceName("TLCAndroid");
	//	options.setApp("C:\\Users\\TARANG\\eclipse-workspace\\AndroidAppium\\src\\test\\java\\resources\\TLCAndroidQA.apk");
	//	driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	Thread.sleep(5000);
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		//server.stop();
		System.out.println("Service stopped and TLC App opened Successfully.");
	}

}
