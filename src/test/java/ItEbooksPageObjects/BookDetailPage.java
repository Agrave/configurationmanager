package ItEbooksPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by AMogilnikov on 23.02.2017.
 */
public class BookDetailPage {
    private WebDriver driver;

    private WebElement title;
    private WebElement description;
    private WebElement publisher;
    private WebElement author;
    private WebElement isbn;
    private WebElement datePublished;
    private WebElement numberOfPages;
    private WebElement fileSize;
    private WebElement inLanguage;
    private WebElement bookFormat;

    public BookDetailPage(WebDriver driver) {
        this.driver = driver;
        title = driver.findElement(By.cssSelector("h1[itemprop='name']"));
        WebElement ebookView = driver.findElement(By.cssSelector("table[class='ebook_view']"));
        description = ebookView.findElement(By.cssSelector("[itemprop='description']"));
        publisher = ebookView.findElement(By.cssSelector("[itemprop='publisher']"));
        author = ebookView.findElement(By.cssSelector("[itemprop='author']")).findElement(By.xpath("following-sibling::*"));
        isbn = ebookView.findElement(By.cssSelector("[itemprop='isbn']"));
        datePublished = ebookView.findElement(By.cssSelector("b[itemprop='datePublished']"));
        numberOfPages = ebookView.findElement(By.cssSelector("b[itemprop='numberOfPages']"));
        inLanguage = ebookView.findElement(By.cssSelector("b[itemprop='inLanguage']"));
        bookFormat = ebookView.findElement(By.cssSelector("b[itemprop='bookFormat']"));
        fileSize = ebookView.findElement(By.xpath("../table/tbody/tr/td[2]/table/tbody/tr[8]/td[2]/b"));
//        /html / body / table / tbody / tr[2] / td / div[2]
//       / html / body / table / tbody / tr[2] / td / div[2]|/table/tbody/tr/td[2]/table/tbody/tr[8]/td[2]/b
    }

    public WebElement title() {
        return title;
    }

    public WebElement description() {
        return description;
    }

    public WebElement publisher() {
        return publisher;
    }

    public WebElement author() {
        return author;
    }

    public WebElement isbn() {
        return isbn;
    }

    public WebElement datePublished() {
        return datePublished;
    }

    public WebElement numberOfPages() {
        return numberOfPages;
    }

    public WebElement fileSize() {
        return fileSize;
    }

    public WebElement inLanguage() {
        return inLanguage;
    }

    public WebElement bookFormat() {
        return bookFormat;
    }

    @Override
    public String toString() {
        return "BookDetailPage{" +
                "title=" + title().getText() + "\n" +
                ", description=" + description().getText() + "\n" +
                ", publisher=" + publisher().getText() + "\n" +
                ", author=" + author().getText() + "\n" +
                ", isbn=" + isbn().getText() + "\n" +
                ", datePublished=" + datePublished().getText() + "\n" +
                ", numberOfPages=" + numberOfPages().getText() + "\n" +
                ", fileSize=" + fileSize().getText() +"\n"+
                ", inLanguage=" + inLanguage().getText() + "\n" +
                ", bookFormat=" + bookFormat().getText() + "\n" +
                '}';
    }
}
