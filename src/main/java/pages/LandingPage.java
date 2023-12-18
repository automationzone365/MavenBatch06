package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage{
  //  WebDriver driver;

   @FindBy(css="#mf-newsletter-popup>div+div>a")
    private WebElement closenotificationLink;
    @FindBy(css=".extras-menu>li+li+li")
    private WebElement loginMenuLink;
    @FindBy(id="username")
    private WebElement userNameTextbox;

    @FindBy(id="password")
    private WebElement passwordTextbox;

    @FindBy(xpath="//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(xpath ="//p[text()[contains(.,'Hello')]]")
    private WebElement loggedinuserLabel;

    @FindBy(xpath ="(//a[text()='Log out'])[1]")
    private WebElement logoutLink;

    public LandingPage(WebDriver driver){
        super(driver);
    }

    public void closenotification(){
        wait.until(ExpectedConditions.visibilityOf(closenotificationLink));
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",closenotificationLink);
        closenotificationLink.click();
    }

    public void loadApplication(String url){
        driver.get(url);
    }

    public void loginMenuclick(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",loginMenuLink);
        loginMenuLink.click();
    }

    public void enterUsername(String username){
        wait.until(ExpectedConditions.elementToBeClickable(userNameTextbox)).sendKeys(username);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordTextbox)).sendKeys(password);
    }

    public void loginClick(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }


    public String getUserLoggedinLabel(){
      return   wait.until(ExpectedConditions.visibilityOf(loggedinuserLabel)).getText();
    }

    public void signOut(){
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",logoutLink);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",logoutLink);

    }
}
