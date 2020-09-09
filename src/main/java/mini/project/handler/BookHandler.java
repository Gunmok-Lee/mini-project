package mini.project.handler;

import java.util.Iterator;
import java.util.List;
import mini.project.domain.Book;
import mini.project.domain.Member;
import mini.project.util.Prompt;

public class BookHandler {
  
  List<Book> bookList;
  Member member;
  MemberHandler memberHandler;
  
  public BookHandler(MemberHandler memberHandler) {
    this.memberHandler = memberHandler;
  }
  public void add() {
    System.out.println("[대여 도서 등록]");
    
    Book book = new Book();
    book.setBookNo(Prompt.inputInt("도서 번호: "));
    book.setBookName(Prompt.inputString("도서 이름: "));
    book.setCompany(Prompt.inputString("출판사: "));
    book.setAuthor(Prompt.inputString("저자: "));
    book.setRegisteredDate(Prompt.inputDate("대여 일시: "));
    
    while (true) {
      String name = Prompt.inputString("대여자(미 입력 시 대여가 불가능합니다.): ");
      
      if (name.length() == 0) { // 대여자 미 입력 경우
        System.out.println("도서 대여를 취소합니다.");
        return;
      } else if (memberHandler.findByName(name) != null) { 
        member.setName(name); // 등록된 회원과 이름이 일치할 경우
        break;
      }
      System.out.println("등록된 회원이 아닙니다."); // 등록된 회원과 이름이 일치하지 않을 경우
    }
  }
 
  public void list() {
    System.out.println("[회원 리스트]");

    Iterator<Book> iterator = bookList.iterator();

    while (iterator.hasNext()) {
      Book book = iterator.next();
      System.out.printf("%d, %s, %s, %s, %s\n",
          book.getBookNo(),
          book.getBookName(),
          book.getCompany(),
          book.getAuthor(),
          book.getRegisteredDate());
    }
  }
  
}
