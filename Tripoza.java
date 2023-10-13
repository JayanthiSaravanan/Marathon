package week2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tripoza {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.tripozo.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//div[@class='ant-tabs-tab-btn']")).click();
		driver.findElement(By.xpath("//input[@id='search-form_origin']")).sendKeys("MAA");
		driver.findElement(By.xpath("//span[text()='Chennai']")).click();
		driver.findElement(By.xpath("//input[@id='search-form_destination']")).sendKeys("GOX");
		driver.findElement(By.xpath("(//span[text()='Goa'])[1]")).click();

		driver.findElement(By.xpath("//input[@class='calBtn']")).click();
		driver.findElement(By.xpath("//span[text()='Search']")).click();

		driver.findElement(By.xpath("(//input[@class='ant-checkbox-input'])[3]")).click();
		driver.findElement(By.xpath("(//span[@class='fs11 mgu2 nowrap'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Air India']")).click();
		String text = driver.findElement(By.xpath("//div[text()='Air India']")).getText();

		System.out.println(text);

		String s = "Air India";

		if (s.equals(text)) {
			System.out.println("Displayed airlines are verified");
		} else {
			System.out.println("Not verified");
		}
		driver.findElement(By.xpath("//button[@class=\'choose-button tpz-btn nowrap\']")).click();
		String text2 = driver.findElement(By.xpath("//span[text()='Refundable']")).getText();

		System.out.println(text2);

		String s1 = "Refundable";

		if (s1.equals(text2)) {
			System.out.println("verified");
		} else {
			System.out.println("Not verified");
		}

		driver.findElement(By.xpath("//span[text()='Flight Info']")).click();
		Thread.sleep(2000);
		
	    File src = driver.getScreenshotAs(OutputType.FILE);
		
		//Step 2
		File des = new File("./snap/img.png");
		
		//Step 3
		FileUtils.copyFile(src,des);
		
		/* 
		 * driver.findElement(By.xpath("//span[@class='ant-modal-close-x']")).click();
		 * driver.findElement(By.xpath("//span[text()='Fare Info']")).click();
		 * 
		 * Thread.sleep(2000); File source1 = driver.getScreenshotAs(OutputType.File);
		 * 
		 * File destination1 = new File("./SnapShots/pic.png");
		 * 
		 * FileUtil.copyFile(source1, destination1);
		 */

		driver.findElement(By.xpath("//span[@class='ant-modal-close-x']")).click();
		driver.close();

	}

}
