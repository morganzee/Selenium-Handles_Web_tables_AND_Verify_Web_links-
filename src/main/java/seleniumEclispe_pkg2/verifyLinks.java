package seleniumEclispe_pkg2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;

public class verifyLinks {
    public static WebDriver driver;

    public static void main (String[] args) {
        String browser = "Chrome";

    if (browser.toUpperCase().equals("CHROME")) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\chrome driver\\chromedriver.exe");
            driver = new ChromeDriver(); }
    else if (browser.toUpperCase().equals("EDGE")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\Edge driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
                //Url of the application
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
                 //Get browser page title
        String browsertitle = driver.getTitle();
        System.out.println("Page title: " + browsertitle);

                //This holds the link for header links on the homepage
        List<WebElement> headerlinks = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
                //START : Compare expected linktext and actual linktext
        ArrayList<String> expvalues = new  ArrayList<String>();
        expvalues.add("Home"); expvalues.add("Register"); expvalues.add("WebTable"); expvalues.add("SwitchTo"); expvalues.add("Widgets");
        expvalues.add("Interactions"); expvalues.add("Video"); expvalues.add("WYSIWYG"); expvalues.add("More"); expvalues.add("Practice Site");

            // Retrieve link text during run time
        ArrayList<String> actvalues = new ArrayList<>();
            //This gets text of each link using for loop and the getText, as we have ten links on the browser
    for(WebElement l1 : headerlinks ){
            System.out.println(l1.getText());
            actvalues.add(l1.getText().trim()); // this trims text space
        }
            // This logic does the compare and prints out
    if(expvalues.equals(actvalues)){
            System.out.println("status passed : Expected equals actual"); }
    else{
            System.out.println("status failed : Expected not equals actual");
        }
            //END : Compare expected linktext and actual linktext
       driver.quit();
    }
}
