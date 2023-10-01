import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchGoogle {
    WebDriver driver;
    @Given("Open Browser")
    public void openBrowser() {
            final String dir = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
    }

    @And("Click Login")
    public void clickLogin() throws InterruptedException {
            driver.get("https://app.jubelio.com/login");
            Thread.sleep(3000);
    }

    @And("Fill Login Form")
    public void fillLoginForm() throws InterruptedException{
            // Input Email
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("qa.rakamin.jubelio@gmail.com");
            Thread.sleep(2000); // waiting time for processing input email 2s

            // Input Password
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Jubelio123!");
            Thread.sleep(2000); // waiting time for processing input Password 2s

            // Click button login
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(5000);//Waiting process login
    }

    @Then("Lakukan Login")
    public void lakukanLogin() {
        // Mengambil element yang nantinya dipakai untuk validasi jika user sudah berhasil login dan di redirect kedalam system jubelio
        WebElement Pengaturan = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div[1]/h1"));
        Pengaturan.isDisplayed();

        System.out.println(Pengaturan.getText());
        // Expected nya akan muncul wording Pengaturan
    }
}
