package week2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TripozaHotel {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.tripozo.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//div[@class='ant-tabs-tab-btn'])[2]")).click();
		driver.findElement(By.xpath("(//input[@id='CityData'])[1]")).sendKeys("Goa");
		driver.findElement(By.xpath("//span[text()='Goa']")).click();

		driver.findElement(By.xpath("(//div[text()='13'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='14'])[1]")).click();

		driver.findElement(
				By.xpath("(//button[@class='ant-btn ant-btn-default search-inputs tg-primary-btn f-hvcenter'])[2]"))
				.click();

		driver.findElement(By.xpath("//span[text()='Air Conditioning']")).click();
		driver.findElement(By.xpath("//span[text()='Laundry Facility']")).click();
		driver.findElement(By.xpath("//span[text()='Parking']")).click();
		driver.findElement(By.xpath("//span[text()='Restaurant']")).click();

		driver.findElement(By.xpath("(//ul[@class=\"ant-rate ant-rate-disabled starRating\"])[5]")).click();
		driver.findElement(By.xpath("(//span[text()='Choose'])[1]")).click();

		String text = driver.findElement(By.xpath("//p[@class='pl-2']")).getText();
		System.out.println(text);

		String s = "Check In : 13 Oct 2023";

		if (s.equals(text)) {
			System.out.println("Check-in-Date Verified");
		}

		else {
			System.out.println("Not Verified");
		}
		driver.findElement(By.xpath("//button[@class='blocklink nowrap blnk-small blnkB fs12 pdl5 rnd5']")).click();

		// driver.findElement(By.xpath("(//p[text()='Superior Room
		// Assonora'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='ant-btn ant-btn-default'])[1]")).click();

		File src = driver.getScreenshotAs(OutputType.FILE);

		// Step 2
		File des = new File("./snap/img.png");

		// Step 3
		FileUtils.copyFile(src, des);

	}

}
