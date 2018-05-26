import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends FSBase {

    @Test
    public void testTWCSignIn() throws InterruptedException {
        fsLogin();
        //Assert.assertEquals(driver.getTitle(), "Message Inbox | Secure Message Center");
    }
}