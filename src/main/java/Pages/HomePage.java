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
        String[] strings={"some","Locations","Order Status"};

        for (int i = 1; i < 9; i++) {
            //String s = driver.findElement(By.xpath("/html/body/link rel=\"stylesheet\"/app-root/div[3]/footer/app-footer/div/div/div[1]/div/div/app-espot-molecule/div/div[2]/div/app-espot-molecule/div/div[2]/div/div[3]/ul/li["+i+"]/a")).getText();
            String s=driver.findElement(By.cssSelector("div.footer-wrapper footer.section.globalFooter div.footer-espot.block-section-center div.desktopOnly div.row div.col-12 div.col-12 div.links.row:nth-child(3) div.col-sm-3.p-0:nth-child(3) ul:nth-child(2) li:nth-child("+i+") > a:nth-child(1)\n" +
                    "\n")).getText();
            System.out.println(s+"\n");
           int j=0;
           while (j<strings.length)
           {
               System.out.println("\nExcpected outcome "+strings[j]);
               System.out.println("\nActual Outcome "+s);
               j++;
           }


        }
    }
}