
package testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Regression","master"})
    public void verify_account_registration() {
        logger.info("***** Starting TC001_AccountRegistrationTest *******");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("**** Clicked on My Account Link  ****");

            hp.clickRegister();
            logger.info("**** Clicked on Register Link  ****");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            logger.info("**** Providing Customer details  ****");

            regpage.setFirstName(randomstring().toUpperCase());
            regpage.lastname(randomstring().toUpperCase());
            regpage.setEmail(randomstring() + "@gmail.com");
            regpage.setTelephone(randomNumber());

            String password = randomAlphaNumberic();

            regpage.setPassword(password);
            regpage.setConfirmPassword(password);
            regpage.setradioNewsletterNo();
            regpage.setcheckPrivacypolicy();
            regpage.clickContinue();

            logger.info("**** Validating Expected message  ****");
            String confmsg = regpage.getConfirmationMsg();
            AssertJUnit.assertEquals(confmsg, "Your Account Has Been Created!");
        } catch (Exception e) {
            logger.error("Test Failed....");
            logger.debug("Debug logs...");
            AssertJUnit.fail();
        }

        logger.info("*** Finished TC001_AccountRegistrationTest ******");
    }
}
