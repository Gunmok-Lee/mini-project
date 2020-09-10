package mini.project.handler;

import java.util.List;
import mini.project.domain.Rent;
public class RentHandler {

  List<Rent> rentList;
  MemberHandler memberHandler;
  BookHandler bookHandler;
  Rent rent;

  public RentHandler(List<Rent> list, MemberHandler memberHandler, BookHandler bookHandler) {
    this.rentList = list;
    this.memberHandler = memberHandler;
  }

  public void rent() {
    System.out.println("[도서 대여]");

    Object object = new Object();

  }

  public void searchRentAble() {
    System.out.println("[대여 가능 도서목록]");
    bookHandler.findByBookInfo();
  }
}
