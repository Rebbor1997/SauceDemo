import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SauceDemo {
    @Test
    public void SelectorTest() throws  InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.className("btn_action"));
        login.click();
        WebElement search = driver.findElement(By.tagName("select"));
        WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
        menu.click();
        Thread.sleep(3000);
        WebElement menuButton1 = driver.findElement(By.linkText("ABOUT"));
        Thread.sleep(3000);
        WebElement menuButton2 = driver.findElement(By.partialLinkText("RESET"));
        driver.quit();
    }
    @Test
    public void XPathSelectorTest() throws InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        // 1.Поиск по атрибуту
        WebElement userName = driver.findElement(By.xpath("//*[@placeholder='Username']"));
        // 2.Поиск по тексту
        WebElement byText = driver.findElement(By.xpath("//*[text() = 'Accepted usernames are:']"));
        // Вход в аккаунт
        WebElement name = driver.findElement(By.id("user-name"));
        name.sendKeys("standard_user");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.className("btn_action"));
        login.click();
        // 3.Поиск по частичному совпадению атрибута
        WebElement byTagAndPartialValue = driver.findElement(By.xpath("//meta[contains(@content, 'Sauce')]"));
        // 4. Поиск через  following
        WebElement getALlElementsAfterCurrent = driver.findElement(By.xpath("//*[@class = 'primary_header']/following::div"));
        // 5. Поиск через preceding
        WebElement getALlElementsBeforeCurrent = driver.findElement(By.xpath("//*[@class = 'inventory_item_name']/preceding::div"));
        WebElement button = driver.findElement(By.className("inventory_item_name"));
        button.click();
        // 5. Поиск по частичному совпадению текста
        WebElement byContainsText = driver.findElement(By.xpath("//*[contains(text(), 'Labs Backpack')]"));
        // 6. Поиск через ancestor
        WebElement getParentBy = driver.findElement(By.xpath("//*[. = 'Sauce Labs Backpack']/ancestor::body"));
        // 7. Поиск через descendant
        WebElement getChildBy = driver.findElement(By.xpath("//*[@class = 'inventory_details']/descendant::*[@class = 'inventory_details_price']"));
        // 8. Поиск через parent
        WebElement getChildBy1 = driver.findElement(By.xpath("//*[. = 'Sauce Labs Backpack']/parent::div"));
        // 9. Поиск элемента с условием AND
        WebElement byTwoAttributes = driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory' and @data-test='add-to-cart-sauce-labs-backpack']"));
        driver.quit();
    }
    @Test
    public void CssSelectorTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement byClass = driver.findElement(By.cssSelector(".login_wrapper-inner"));
        WebElement byClasses = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        WebElement childClass = driver.findElement(By.cssSelector(".login_wrapper .login-box"));
        WebElement byID = driver.findElement(By.cssSelector("#login-button"));
        //Вход в аккаунт
        WebElement name = driver.findElement(By.id("user-name"));
        name.sendKeys("standard_user");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.className("btn_action"));
        login.click();

        WebElement byTag = driver.findElement(By.cssSelector("ul"));
        WebElement byTagClass = driver.findElement(By.cssSelector("div.header_container"));
        WebElement byAttributeWithValue = driver.findElement(By.cssSelector("[alt='Sauce Labs Bike Light']"));
        //Выбор товара
        WebElement button = driver.findElement(By.className("inventory_item_name"));
        button.click();

        WebElement elementWithPartialValue = driver.findElement(By.cssSelector("[alt *= 'Footer']"));
        WebElement elementStartsFromValue = driver.findElement(By.cssSelector("[alt^= 'Sauce']"));
        WebElement elementFinishFromValue = driver.findElement(By.cssSelector("[alt $= 'Backpack']"));
        WebElement elementPartialValue = driver.findElement(By.cssSelector("[alt ~= 'Labs']"));
        WebElement elementPartialStartValue = driver.findElement(By.cssSelector("[rel |= 'apple']"));
        driver.quit();
    }
}
