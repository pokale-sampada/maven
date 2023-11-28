package Com.ORANGE.Kavish.PageObjects;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_1 {

	WebDriver ldriver;

	public PO_1(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name = "username")
	WebElement ID;

	public void element(String id) {
		ID.sendKeys(id);
	}

	@FindBy(name = "password")
	WebElement loginP;

	public void lpass(String id) {
		loginP.sendKeys(id);
	}

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement button;

	public void lbutton() {
		button.click();
	}

}
