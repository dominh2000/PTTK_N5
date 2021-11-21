/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.book;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class Book implements Serializable{
    private String isbn;
    private int categoryId;
    private int publisherId;
    private List<Author> author;
    private Publisher publisher;
    private Category category;
    
    private String title;
    private String summary;
    private Date publicatioDate;
    private int numOfPages;
    private String language;
    private String dimensions;
    private float weight;
    private String edition;

    public Book() {
    }

    public Book(String isbn, int categoryId, int publisherId, String title, String summary, Date publicatioDate, int numOfPages, String language, String dimensions, float weight, String edition) {
        this.isbn = isbn;
        this.categoryId = categoryId;
        this.publisherId = publisherId;
        this.title = title;
        this.summary = summary;
        this.publicatioDate = publicatioDate;
        this.numOfPages = numOfPages;
        this.language = language;
        this.dimensions = dimensions;
        this.weight = weight;
        this.edition = edition;
    }
    
    public Book(String isbn, List<Author> author, Publisher publisher, Category category, String title, String summary, Date publicatioDate, int numOfPages, String language, String dimensions, float weight, String edition) {
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.title = title;
        this.summary = summary;
        this.publicatioDate = publicatioDate;
        this.numOfPages = numOfPages;
        this.language = language;
        this.dimensions = dimensions;
        this.weight = weight;
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPublicatioDate() {
        return publicatioDate;
    }

    public void setPublicatioDate(Date publicatioDate) {
        this.publicatioDate = publicatioDate;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
    
    
}
