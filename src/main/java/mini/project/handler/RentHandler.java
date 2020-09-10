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
          System.out.printf("%s님은 대여가 가능합니다", id);
          break;
        }
        System.out.println("아이디가 일치하지 않습니다.");
      }
      
    System.out.println("대여가 완료되었습니다.");
    bookList.add(rent);
  }
  
  public void delete() {
    
    
  }
  
  public void searchRentAble() {
    System.out.println("[대여 가능 도서목록]");
    bookHandler.findByBookInfo();
  }
}
