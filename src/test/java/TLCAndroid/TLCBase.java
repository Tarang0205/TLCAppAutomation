package TLCAndroid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TLCBase {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService server;
	
	@BeforeClass
	public void ConfigureAppium () throws MalformedURLException, InterruptedException
	{
	
		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("PATH", "C:\\Users\\TARANG\\AppData\\Roaming\\npm\\node_modules\\.bin" + System.getenv("PATH"));
		
		 AppiumServiceBuilder builder = new AppiumServiceBuilder();
	     builder
	     		 .withAppiumJS(new File("C:\\Users\\TARANG\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	             .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
	             .usingPort(4723)
	             .withEnvironment(environment)
	             .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
	             .withLogFile(new File("AppiumLog.txt"));
	 
	     server = AppiumDriverLocalService.buildService(builder);
	     
	     System.out.println("Server started at :"+server.getUrl());
	   
		server.start();
		System.out.println("Server is Started.");
		
		//service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\TARANG\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			//	.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		//service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("TLCAndroid");
		options.setApp("C:\\Users\\TARANG\\eclipse-workspace\\AndroidAppium\\src\\test\\java\\resources\\TLCAndroidQA.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		server.stop();
		System.out.println("Service stopped and TLC App opened Successfully.");
	}

}
