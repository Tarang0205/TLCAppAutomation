package TLCAndroid;

import java.io.File;
import java.io.FileNotFoundException;
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
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.util.Map;
import java.util.Iterator;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TLCBase {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService server;
	
	
	@BeforeClass
	public void ConfigureAppium () throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
	    HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
	 
	    // Set your access credentials
	    browserstackOptions.put("userName", "tarangvashisht_QoygJT");
	    browserstackOptions.put("accessKey", "quwKyFvRyAeW4LoPRqzd");
	 
	    // Set other BrowserStack capabilities
	    browserstackOptions.put("appiumVersion", "1.22.0");
	    browserstackOptions.put("projectName", "TLC Project");
	    browserstackOptions.put("buildName", "TLC-build-1");
	    browserstackOptions.put("sessionName", "TLC_1");
	 
	    // Passing browserstack capabilities inside bstack:options
	    caps.setCapability("bstack:options", browserstackOptions);
	 
	    // Set URL of the application under test
	    caps.setCapability("app", "bs://ab990ebb5aa2bb23161aac4fb90cd6531f0117cd");
	 
	    // Specify device and os_version for testing
	    caps.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("platformVersion", "12.0");
	
	 
	    // Initialise the remote Webdriver using BrowserStack remote URL
	    // and desired capabilities defined above
	    driver = new AndroidDriver(
	      new URL("http://hub.browserstack.com/wd/hub"),
	      caps
	    );
//	
//		JSONParser parser = new JSONParser();
//        JSONObject config = (JSONObject) parser.parse(new FileReader("C:\\Users\\TARANG\\eclipse-workspace\\AndroidAppium\\src\\test\\java\\resources\\first.conf.json"));
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        JSONArray envs = (JSONArray) config.get("environments");
//        Map<String, String> envCapabilities = (Map<String, String>) envs.get(0);
//        Iterator it = envCapabilities.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
//        }
//        
//        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
//        it = commonCapabilities.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            if(capabilities.getCapability(pair.getKey().toString()) == null){
//                capabilities.setCapability(pair.getKey().toString(), pair.getValue());
//            }
//        }
//
//        String username = System.getenv("BROWSERSTACK_USERNAME");
//        if(username == null) {
//            username = (String) config.get("username");
//        }
//
//        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
//        if(accessKey == null) {
//            accessKey = (String) config.get("access_key");
//        }
//        
//        String app = System.getenv("BROWSERSTACK_APP_ID");
//        if(app != null && !app.isEmpty()) {
//          capabilities.setCapability("app", app);
//        }
//
//        driver = new AndroidDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
//    }
//        
//        
        
//		HashMap<String, String> environment = new HashMap<String, String>();
//		environment.put("PATH", "C:\\Users\\TARANG\\AppData\\Roaming\\npm\\node_modules\\.bin" + System.getenv("PATH"));
//		
//		 AppiumServiceBuilder builder = new AppiumServiceBuilder();
//	     builder
//	     		 .withAppiumJS(new File("C:\\Users\\TARANG\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//	           .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
//	         .usingPort(4723)
//	             .withEnvironment(environment)
//	             .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
//	             .withLogFile(new File("AppiumLog.txt"));
//	 
//	     server = AppiumDriverLocalService.buildService(builder);
//	     
//	     System.out.println("Server started at :"+server.getUrl());
//	   
//		server.start();
//	System.out.println("Server is Started.");
//		
//		//service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\TARANG\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//			//	.withIPAddress("127.0.0.1").usingPort(4723).build();
//		
//		//service.start();
//		
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("TLCAndroid");
//		options.setApp("C:\\Users\\TARANG\\eclipse-workspace\\AndroidAppium\\src\\test\\java\\resources\\TLCAndroidQA.apk");
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Thread.sleep(5000);
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		//server.stop();
		System.out.println("Service stopped and TLC App opened Successfully.");
	}

}
