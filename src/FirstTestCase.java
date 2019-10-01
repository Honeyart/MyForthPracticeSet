import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestCase {
    @Test
    public void setup() {
        System.out.println("This is the first test case");
    }

    @Test
    public void login() {
        System.out.println("This is the second test case");
       // Assert.fail();
    }

    @Test
    public void logout() {
        System.out.println("This is the third test case");
    }
}
