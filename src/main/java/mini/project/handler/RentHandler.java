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

    Book rent = new Book();
    rent.setRentDate(Prompt.inputDate("대여 일자: "));

    while(true) {
      int no = Prompt.inputInt("도서 번호: ");

      if(Integer.toString(no) == null) {
        System.out.println("도서 번호를 입력하세요.");
        continue;
      } else {
        break;
      }
    }

    while (true) {
      String id = Prompt.inputString("아이디: ");

      if (id.length() == 0) { // id 미 입력 경우
        System.out.println("아이디를 입력하세요.");
        continue;
      } else if (memberHandler.findById(id) != null) {
        System.out.printf("%s님은 대여가 가능합니다\n", id);
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    System.out.println("대여가 완료되었습니다.");
    bookList.add(rent);
  }

  public void delete() {
    System.out.println("[도서 반납]");
    int bookNo = Prompt.inputInt("도서 번호: ");
    int index = indexOf(bookNo);
    
    if(index == -1) {
      System.out.println("해당 도서 번호가 없습니다.");
      return;
    }
    
    String response = Prompt.inputString("반납하시겠습니까?(y/N) ");
    if(!response.equalsIgnoreCase("y")) {
      System.out.println("도서 반납을 취소하였습니다.");
      return;
    }
    
    bookList.remove(index);
    System.out.println("도서를 반납하였습니다.");
  }

  public void searchRentAble() {
    System.out.println("[대여 가능 도서목록]");
    bookHandler.findByBookInfo();
  }

  public void rentImpossible() {
    System.out.println("[대여중 도서목록]");
    bookHandler.findByBookInfo();

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
