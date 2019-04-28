import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SlurpTest {
    public static WebDriver driver = null;

    @BeforeClass
    public static void test1(){
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //opening  the web app
        driver.get("C:\\Users\\ragha\\Documents\\Raghavi_UXUI\\Website_-_Food\\Website_-_Food\\Website_-_Food.html");

    }
    @Test
    public void aTitleTest(){
        //maximize the window
        driver.manage().window().maximize();
        //get the Moqup Title
        String title = driver.getTitle();

        //Assert for the title name
        Assert.assertEquals(title,"Moqups");
    }
    @Test
    public void bHomePageCheck() throws InterruptedException{

    }
    @Test
    public void cLoginPageCheck() throws InterruptedException{
        //Assert for Slurp Title
        returnPageName("#breadcrumbs > div > span.project-title.view-mode.ellipsis.hint--bottom", "Website - Food", "Slurp Title matches", "Something Wrong - Slurp Title not matching");
        //check if its in home page
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "HomePage", "Yes its in the HomePage", "Something wrong - Not in the home page");

        //click on Login-In Button
        Actions action = new Actions(driver);

        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(10)");
        Thread.sleep(2000);

        //check if its in login page
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "Log In", "Yes its in the Log In", "Something wrong - Not in the Log In page");

        //check if login url is valid
        checkUrl("http://Slurp.com/Login", "Login Url Matches -  http://Slurp.com/Login");


    }

    @Test
    public void dsignUpCheck() throws InterruptedException{
        //click on Sign-up link
        Actions action = new Actions(driver);

        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(4)");
        Thread.sleep(2000);

        //check if its in signUp page
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "Sign Up", "Yes its in the Sign Up", "Something wrong - Not in the Sign Up page");

        //check if Sign Up url is valid
        checkUrl("http://Slurp.com/signup", "Sign Up Url Matches -  http://Slurp.com/signup");

    }

    @Test
    public void ehomePage() throws InterruptedException{
        Actions action = new Actions(driver);

        //Click on the Slurp Icon to go to Home Page
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(4)");
        Thread.sleep(1000);

        //check if its in home page
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "HomePage", "Yes its in the HomePage", "Something wrong - Not in the home page");

    }

    @Test
    public void freservationPage() throws InterruptedException{
        Actions action = new Actions(driver);

        //click on reservation tab
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(2)");
        Thread.sleep(2000);

        //check if its in Restaurants page
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "Restaurants", "Yes its in the Restaurants", "Something wrong - Not in the Restaurants page");

        //check if Restaurants url is valid
        checkUrl("http://www.slurp.com/restaurants", "Restaurants Url Matches -  http://www.slurp.com/restaurants");
    }

    @Test
    public void greserveQdobaTable() throws InterruptedException{
        Actions action = new Actions(driver);

        //click on Qdoba Restaurant
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(9)");
        Thread.sleep(2000);

        //check if its in reserve Table page
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "ReserveTable", "Yes its in the ReserveTable", "Something wrong - Not in the ReserveTable page");

        //check if qdoba reserve table url is valid
        checkUrl("http://www.slurp.com/qdoba/reservetable", "qdoba reserve table Url Matches - http://www.slurp.com/qdoba/reservetable");

    }

    @Test
    public void hsrollTest() throws InterruptedException{
        Actions action = new Actions(driver);
        //scroll down to the date
        WebElement element = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(27) > svg > svg"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);

        //click on date icon
        for(int i=0;i<=1;i++) {
            clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(10)");
            Thread.sleep(1000);
        }

        //click on person icon
        for(int i=0;i<=1;i++) {
            clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(8)");
            Thread.sleep(1000);
        }

        //click on time icon
        for(int i=0;i<=1;i++) {
            clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(9)");
            Thread.sleep(1000);
        }
        //scroll up to the tabs
        WebElement tabs = driver.findElement(By.cssSelector("#canvas-stage > div:nth-child(5) > a:nth-child(3)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabs);
        Thread.sleep(1000);


    }

    @Test
    public void iOrderTest() throws InterruptedException{
        Actions action = new Actions(driver);
        //click on orders tab
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(3)");
        Thread.sleep(2000);

        //check if its in orders page
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "Order", "Yes its in the Order Page", "Something wrong - Not in the Order page");

        //check if orders url is valid
        checkUrl("http://www.slurp.com/order", "qdoba reserve table Url Matches - http://www.slurp.com/order");

    }

    @Test
    public void jQdobaClick() throws InterruptedException {
        Actions action = new Actions(driver);

        //click on Qdoba Restaurant
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(9)");
        Thread.sleep(2000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);


        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(7)");
        Thread.sleep(1000);



    }

    @Test
    public void kFoodTruckTest() throws InterruptedException{
        Actions action = new Actions(driver);
        //click on Food Truck
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(15)");
        Thread.sleep(1000);

        //Click on each tab in the foodTruck
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(2)");
        Thread.sleep(3000);
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(4)");
        Thread.sleep(3000);
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(3)");
        Thread.sleep(3000);

    }

    @Test
    public void lFoodTruck2() throws InterruptedException{
        Actions action = new Actions(driver);
        //Click on the inner tab
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(7)");
        Thread.sleep(3000);

        //scroll through the page
        WebElement scrollOrder1 = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(8)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollOrder1);
        Thread.sleep(500);
        WebElement scrollOrder2 = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(9)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollOrder2);
        Thread.sleep(500);
        WebElement scrollOrder3 = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(10)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollOrder3);
        Thread.sleep(500);
        WebElement scrollOrder4 = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(11)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollOrder4);
        Thread.sleep(500);

    }

    @Test
    public void mBlogTest() throws InterruptedException{
        Actions action = new Actions(driver);

        //click on Blogs Option
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(4)");
        Thread.sleep(2000);

        //check if its in Blogs page
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "Blogs", "Yes its in the Blogs", "Something wrong - Not in the Blogs page");

        //check if Blogs url is valid
        checkUrl("http://www.slurp.com/blogs", "Blogs Url Matches -  http://www.slurp.com/blogs");

        //scroll through the blogs page
        WebElement so1 = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(43) > svg > foreignObject > div > p"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", so1);
        Thread.sleep(500);
        WebElement so2 = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(59) > svg > foreignObject > div > p"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", so2);
        Thread.sleep(500);
        WebElement so3 = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(22) > svg > foreignObject > div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", so3);
        Thread.sleep(500);

    }

    @Test
    public void nDealsPage() throws InterruptedException{
        Actions action = new Actions(driver);
        //click on Deals Option
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(7)");
        Thread.sleep(2000);

        //check if its in Deals page
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "Major Deals", "Yes its in the Deals", "Something wrong - Not in the Deals page");

        //check if Deals url is valid
        checkUrl("http://www.slurp.com/deals", "Deal Url Matches -  http://www.slurp.com/deals");

        //scroll through the deals page
        WebElement so5 = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(3) > svg > svg"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", so5);
        Thread.sleep(500);

    }

    @Test
    public void oBusinessPage() throws InterruptedException{
        Actions action = new Actions(driver);

        //click on the slurp icon
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(2)");
        Thread.sleep(1000);


        //click on the business page link
        clickAction(action, "#canvas-stage > div:nth-child(5) > a:nth-child(12)");
        Thread.sleep(1000);

        //check if its in the business page
        checkUrl("http://www.slurp.com/business", "Business Url Matches -  http://www.slurp.com/business");

    }

    @Test
    public void pCartTest() throws InterruptedException{
         Actions action = new Actions(driver);
         clickAction(action,"#canvas-stage > div:nth-child(5) > a");
        //click on cart icon
        clickAction(action,"#canvas-stage > div:nth-child(5) > a:nth-child(6)");

        checkUrl("http://www.slurp.com/cart", "Cart Url Matches -  http://www.slurp.com/cart");
        returnPageName("#breadcrumbs > div > span.current-page-title.view-mode.ellipsis.hint--right", "Cart", "Yes its in the Cart Page", "Something wrong - Not in the Cart page");


    }
        private static void clickAction(Actions action, String s) {
        WebElement webElement = driver.findElement(By.cssSelector(s));
        action.moveToElement(webElement);
        action.click();
        action.perform();
    }

    private static void checkUrl(String s, String s2) {
        String url = " ";
        url = driver.findElement(By.cssSelector("#canvas-stage > svg > svg > g > g > g:nth-child(1) > svg > svg > foreignObject:nth-child(6) > div > a")).getText();
        Assert.assertEquals(url.trim(),s);
        if (url.trim().equalsIgnoreCase(s)) {
            System.out.println(s2);
        } else {
            System.err.println("Something wrong - Url doesnt Matches" + url);
        }
    }

    private static void returnPageName(String s, String page, String s2, String s3) {
        String pageName = " ";
        pageName = driver.findElement(By.cssSelector(s)).getText();
        Assert.assertEquals(pageName,page);
        if (pageName.equalsIgnoreCase(page)) {
            System.out.println(s2);
        } else {
            System.err.println(s3);
        }
    }
}
