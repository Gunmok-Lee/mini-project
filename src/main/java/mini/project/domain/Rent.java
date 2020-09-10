package mini.project.domain;

import java.sql.Date;

public class Rent {
  private String rentOwner;//대여자
  private Date rentDate;//대여일

  public String getRentowner() {
    return rentOwner;
  }
  public void setRentowner(String rentowner) {
    this.rentOwner = rentowner;
  }
  public Date getRentDate() {
    return rentDate;
  }
  public void setRentDate(Date rentDate) {
    this.rentDate = rentDate;
  }


}
