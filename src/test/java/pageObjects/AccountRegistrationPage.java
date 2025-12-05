package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(xpath="//input[@id='input-firstname']")
WebElement inputFirstName;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement inputLastName;
@FindBy(xpath="//input[@id='input-email']")
WebElement inputEmail;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement inputTelephone;
@FindBy(xpath="//input[@id='input-password']")
WebElement inputPassword;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement inputConfirmPassword;
@FindBy(xpath="//input[@value='0']")
WebElement radioNewsletterNo;
@FindBy(xpath="//input[@name='agree']")
WebElement checkPrivacyPolicy;
@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
//@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;


public void setFirstName(String fname)
{
	inputFirstName.sendKeys(fname);
	
}

public void lastname(String lname)
{
inputLastName.sendKeys(lname);	
}

public void setEmail(String email)
{
inputEmail.sendKeys(email);	
}
public void setTelephone(String tele)
{
inputTelephone.sendKeys(tele);	
}
public void setPassword(String pwd)
{
inputPassword.sendKeys(pwd);	
}
public void setConfirmPassword(String cpwd)
{
inputConfirmPassword.sendKeys(cpwd);
}
public void setradioNewsletterNo()
{
radioNewsletterNo.click();	
}
public void setcheckPrivacypolicy()
{
checkPrivacyPolicy.click();	
}
public void clickContinue()
{
	//sol1
btnContinue.click();	
//sol2
//btnContinue.submit();
//sol3
//Actions act-new Action(driver)
//act.movetoElement(btnContinue).click().perform();
//sol4
//JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("arguments[0].click();",btnContinue);
//sol5
//btncontinue.sendKeys(Keys.RETURN);
//sol6
//ebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//myWait.untill(ExpectedConditions.elementToBeClickable(btnContinue));
}

public String getConfirmationMsg() {
try {
	return msgConfirmation.getText();
  }catch (Exception e){
     return(e.getMessage());			
	
    }

}

}
