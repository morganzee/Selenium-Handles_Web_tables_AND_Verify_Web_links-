package seleniumEclispe_pkg2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.ArrayList;

public class handleWebTables {

    public static WebDriver driver;
    public static void main (String[] args) {

        String browser = "chrome";

        if (browser.toUpperCase().equals("CHROME")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\chrome driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser.toUpperCase().equals("EDGE")){
            System.setProperty("webdriver.edge.driver","C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\Edge driver\\msedgedriver.exe");
            driver = new EdgeDriver(); }

                 //This url is used for a prompt
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();

        String browsertitle = driver.getTitle();
        System.out.println("Page title: " + browsertitle);

                // Row and column size, "size" would give you the numbers of rows and columns elements
        int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
                System.out.println("Number of rows in the web table : " + rows);
        int cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th")).size();
             System.out.println("Number of columns in the web table : " + cols);

                //Expected cell values of the web table
        ArrayList<String> expValues = new ArrayList<String>();
        expValues.add("Company"); expValues.add("Contact"); expValues.add("Country"); expValues.add("Alfreds Futterkiste"); expValues.add("Maria Anders");
        expValues.add("Germany"); expValues.add("Centro comercial Moctezuma"); expValues.add("Francisco Chang"); expValues.add("Mexico"); expValues.add("Ernst Handel");
        expValues.add("Roland Mendel"); expValues.add("Austria"); expValues.add("Island Trading"); expValues.add("Helen Bennett"); expValues.add("UK");
        expValues.add("Laughing Bacchus Winecellars"); expValues.add("Yoshi Tannamuri"); expValues.add("Canada"); expValues.add("Magazzini Alimentari Riuniti"); expValues.add("Giovanni Rovelli");
        expValues.add("Italy");
                //Expected cell values of the web table
        ArrayList<String> actValues = new ArrayList<String>();
                //This is to iterate the rows and columns and retrieve actual value during run time
        for(int i=1;i<=rows;i++) {
            for (int j = 1; j <= cols; j++) {
                if (i == 1) {
                    String cellvalue = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/th[" + j + "]")).getText();
                    System.out.print(cellvalue + " | ");
                    actValues.add(cellvalue.trim());
                } else {
                    String cellvalue = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                    System.out.print(cellvalue + " | ");
                    actValues.add(cellvalue.trim());
                }
            }
                 //This print next row after each
            System.out.println();
        }
        if(expValues.equals(actValues)){
            System.out.println("status passed : Expected values retrieved during run time equals actual value"); }
        else{
            System.out.println("status passed : Expected values retrieved during run time not equals actual value");
        }
        driver.quit();
    }
}
