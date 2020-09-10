package mini.project.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Book {
  private int bookNo; // 도서번호
  private String bookName; // 도서이름
  private String company; // 출판사
  private String author; // 저자
  private Date registeredDate; // 대여 일자
  private Date currentDate; // 대여 일자
   
  public int getBookNo() {
    return bookNo;
  }
  public void setBookNo(int bookNo) {
    this.bookNo = bookNo;
  }
  public String getBookName() {
    return bookName;
  }
  public void setBookName(String bookName) {
    this.bookName = bookName;
  }
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public void setChangeDate(Date registeredDate) { // Date => String 변경
    Date dates = new Date(System.currentTimeMillis());
    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(dates);
    this.currentDate = registeredDate;
  }
  public Object getChangeDate() {
    return currentDate;
  }
} 
