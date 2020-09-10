package mini.project.domain;

import java.sql.Date;

public class Book {
  private int bookNo; // 도서번호
  private String bookName; // 도서이름
  private String company; // 출판사
  private String author; // 저자
  private String rentAble;//대여가능여
  private String rentOwner;//대여자
  private Date rentDate;//대여일

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
  public String getRentAble() {
    return rentAble;
  }
  public void setRentAble(String rentAble) {
    this.rentAble = rentAble;
  }
  public Date getRentDate() {
    return rentDate;
  }
  public void setRentDate(Date rentDate) {
    this.rentDate = rentDate;
  }
  public String getRentOwner() {
    return rentOwner;
  }
  public void setRentOwner(String rentOwner) {
    this.rentOwner = rentOwner;
  }
}
