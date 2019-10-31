package TestCases;

import BaseClass.Base;
import Pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FootercontentsTest extends Base {

    HomePage hm;

    public FootercontentsTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        Start();
        hm= new HomePage();
    }

    @Test
    public void ValidatingFooterContentsTest() throws InterruptedException {
        hm.Footercontents();
    }



    @AfterMethod
    public void teardown()
    {
        driver.close();
        //driver.quit();
    }

}
