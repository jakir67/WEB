import org.openqa.selenium.By;

public class FSBase extends Base {
    public String signInLinkXpath = "//*[@id=\"app\"]/div/header/nav[1]/div/button";
    public String userNameFieldXPath = ".c-form-field.c-form-field--email>label>input";
    public String passwordFieldXpath = ".c-form-field.c-form-field--password>label>input";
    public String signInButtonXpath = ".c-btn.c-btn--primary";


    public String userName = "footlockertesting@gmail.com";
    public String password = "Test@1234";

    public void fsLogin() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath(signInLinkXpath)).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(userNameFieldXPath)).sendKeys(userName);
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(passwordFieldXpath)).sendKeys(password);
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(signInButtonXpath)).click();
        Thread.sleep(5000);
    }
}