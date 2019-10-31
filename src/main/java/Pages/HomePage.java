package Pages;

import BaseClass.Base;
import Utilities.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Base {
    @FindBy(xpath = "//img[@class='image']")
    WebElement HeaderLogo;

    @FindBy(xpath = "//input[@placeholder='Search for contact lenses']")
    WebElement searchbox;

    @FindBy(xpath = "//img[@class='img-responsive cart-icon']")
    WebElement CartIcon;

    @FindBy(xpath = "//footer[@class='section globalFooter']")
    WebElement footer;

    TestUtil tt;





    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public java.lang.String Pagetitle() {
        return driver.getTitle();
    }

    public boolean LogoValidate() {
        return HeaderLogo.isDisplayed();
    }

    public boolean SearchBoxValidate() {
        return searchbox.isDisplayed();
    }

    public boolean CartIconValidate() {
        return CartIcon.isDisplayed();
    }

    public void Footercontents() throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView();", footer);
        Thread.sleep(3000);
        String[] strings={"Locations","Order Status"};

        for (int i = 1; i < 9; i++) {
            java.lang.String s = driver.findElement(By.xpath("/html/body/link rel=\"stylesheet\"/app-root/div[3]/foot" +
                    "er/app-footer/div/div/div[1]/div/div/app-espot-molecule/div/div[2]/div/app-espot-molecule/div/" +
                    "div[2]/div/div[3]/ul/li[" + i + "]")).getText();
            System.out.println(s+"\n");
            for (int j = 0; j < strings.length; j++) {
                Assert.assertEquals(s,strings[j]);
            }


        }
    }
}