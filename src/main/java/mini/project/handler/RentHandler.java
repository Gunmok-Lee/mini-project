package mini.project.handler;

import java.util.List;
import mini.project.domain.Book;
import mini.project.util.Prompt;
public class RentHandler {

  List<Book> bookList;
  MemberHandler memberHandler;
  BookHandler bookHandler;

  public RentHandler(List<Book> list, MemberHandler memberHandler, BookHandler bookHandler) {
    this.bookList = list;
    this.memberHandler = memberHandler;
    this.bookHandler = bookHandler;
  }

  public void add() {
    System.out.println("[도서 대여]");
    int bookNo = Prompt.inputInt("도서 번호: ");
    int index = indexOf(bookNo);
    Book book = bookList.get(index);

    if(index == -1) {
      System.out.println("해당 도서 번호가 없습니다.");
      return;
    }

    String id = Prompt.inputString("아이디: ");
    if (memberHandler.findById(id) == null) {
      System.out.println("등록된 회원이 아닙니다.");
      return;
    }

    String response = Prompt.inputString("대여하시겠습니까?(y/N) ");
    if(!response.equalsIgnoreCase("y")) {
      System.out.println("도서 대여를 취소하였습니다.");
      return;
    }
    book.setRentOwner(id);
    book.setRentDate(new java.sql.Date(System.currentTimeMillis()));
    book.setRentAble("no");
    System.out.println("도서를 대여하였습니다.");
  }

  public void delete() {
    System.out.println("[도서 반납]");
    int bookNo = Prompt.inputInt("도서 번호: ");
    int index = indexOf(bookNo);
    Book book = bookList.get(index);

    if(index == -1) {
      System.out.println("해당 도서 번호가 없습니다.");
      return;
    }

    String response = Prompt.inputString("반납하시겠습니까?(y/N) ");
    if(!response.equalsIgnoreCase("y")) {
      System.out.println("도서 반납을 취소하였습니다.");
      return;
    }

    book.setRentOwner(null);
    book.setRentDate(null);
    book.setRentAble("ok");
    System.out.println("도서를 반납하였습니다.");
  }

  public void searchRentAble() {
    System.out.println("[대여 가능 도서목록]");
    bookHandler.findByBookInfo();
  }

  public void rentImpossible() {
    System.out.println("[대여중 도서목록]");
    bookHandler.findRentingInfo();

  }

  private int indexOf(int no) {
    for (int i = 0; i < bookList.size(); i++) {
      Book book = bookList.get(i);
      if (book.getBookNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
