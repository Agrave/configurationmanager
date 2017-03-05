package exam.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMogilnikov on 05.03.2017.
 */
public class HomePage {
    private WebElement bugListTable;
    private WebElement footer;
    private WebElement bugRecord;
    private List<BugRecord> bugList;
    private WebDriver driver;
    private PagingToolbar toolbar;
    private Wait wait;

    private By bugListTableLocator = By.cssSelector("table[class*='x-grid-table'");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        List<WebElement> bugListT;
        bugList = new ArrayList<>();
        bugListTable = driver.findElement(bugListTableLocator);
        bugListT = bugListTable.findElements(By.cssSelector("tr[class*='x-grid-row'"));

        for (WebElement e : bugListT) {
            bugList.add(new BugRecord(e));
        }
        toolbar = new PagingToolbar(driver.findElement(By.cssSelector("div[id^='pagingtoolbar']")));
    }

    public WebElement getBugListTable() {
        return bugListTable;
    }

    public int bugsCount() {
        return bugList.size();
    }

    public BugRecord getBugByName(String name) {
        for (BugRecord br : bugList) {
            if (br.getName().equalsIgnoreCase(name)) return br;
        }
        return null;
    }

    public boolean ifPresent(String name) {
        if (getBugByName(name) != null) return true;
        return false;
    }

    public HomePage addBugViaForm(String name, String description) {
        By formLocator = By.id("bugs__add_form");

        toolbar.buttonAddInFormClick();
        wait.until(ExpectedConditions.elementToBeClickable(formLocator));

        AddBugForm form = new AddBugForm(driver.findElement(formLocator));
        form.enterName(name);
        form.enterDescription(description);
        form.submit();

//        toolbar.buttonRefreshClick();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        wait.until(ExpectedConditions.presenceOfElementLocated(bugListTableLocator));
        return new HomePage(driver);
    }

    public HomePage deleteBugByName(String name) {
        By msgBoxLocator = By.cssSelector("div[id^='messagebox']");
        if (ifPresent(name)) {
            getBugByName(name).select();
            toolbar.buttonDeleteClick();
            wait.until(ExpectedConditions.elementToBeClickable(msgBoxLocator));
            WebElement msgBox = driver.findElement(msgBoxLocator);
            msgBox.findElement(By.id("button-1010")).findElement(By.cssSelector("button")).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(bugListTableLocator));
        return new HomePage(driver);
    }

    public HomePage addBugViaAddButton(String name, String description) {

        By editNameLocator = By.cssSelector("div[class^='x-editor']");

        toolbar.buttonAddClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(editNameLocator));
        driver.findElement(editNameLocator)
                .findElement(By.cssSelector("input"))
                .sendKeys(name);

        bugListTable = driver.findElement(bugListTableLocator);
        WebElement bugInProgers = bugListTable.findElement(By.cssSelector("tr[class*='grid-dirty-record'"));
        bugInProgers.click();

        bugInProgers = bugListTable.findElement(By.cssSelector("tr[class*='grid-dirty-record'"));
        Actions action = new Actions(driver);
        action.moveToElement(
                bugInProgers.findElement(By.cssSelector("td[class*='x-grid-cell-gridcolumn-1021'"))
                        .findElement(By.tagName("div")))
                .doubleClick().build().perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(editNameLocator));
        driver.findElements(editNameLocator).get(1)
                .findElement(By.cssSelector("textarea"))
                .sendKeys(description);

        bugInProgers = bugListTable.findElement(By.cssSelector("tr[class*='grid-dirty-record'"));
        bugInProgers.click();

        toolbar.buttonApplyClick();

        stopFor(3);
        System.out.println("zzzz");
        return new HomePage(driver);
    }

    private void stopFor(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
