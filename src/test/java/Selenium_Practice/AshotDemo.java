package Selenium_Practice;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AshotDemo extends TestBase{
	AshotDemo(){
		super();
	}
	@BeforeMethod
	public void setup() {
		
		initialize();
		
	}
	
	@Test
	public void fullScreenshotTest()
	{
		driver.get("https://www.softwaretestingmaterial.com");
		
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	    try {
			ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D:///FullPageScreenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
