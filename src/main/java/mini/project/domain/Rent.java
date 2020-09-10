package mini.project.domain;

import java.sql.Date;

public class Rent {

  private Date registeredDate; // 대여 일자
  
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
}
 