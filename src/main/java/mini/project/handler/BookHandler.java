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
    book.setBookName(Prompt.inputString("도서명: "));
    book.setCompany(Prompt.inputString("출판사: "));
    book.setAuthor(Prompt.inputString("저자: "));
    book.setRegisteredDate(Prompt.inputDate("대여 일자: "));
    
    while (true) {
      String id = Prompt.inputString("아이디: ");
      
      if (id.length() == 0) { // id 미 입력 경우
        System.out.println("도서 대여를 취소합니다.");
        return;
      } else if (memberHandler.findByName(id) != null) { 
        member.setId(id); // 등록된 아이디와 일치할 경우
        System.out.printf("%s님, 대여가 완료되었습니다", id);
        break;
      }
      System.out.println("아이디가 일치하지 않습니다."); // 등록된 회원과 이름이 일치하지 않을 경우
    }
    
    bookList.add(book);
  }
 
  public void list() {
    System.out.println("[대여도서 정보]");

    Iterator<Book> iterator = bookList.iterator();

    while (iterator.hasNext()) {
      Book book = iterator.next();
      System.out.printf("도서 번호: %d\n,"
          + "도서명: %s\n,출판사: %s\n,저자: %s\n,대여 일자: %s\n,대여자: %s\n",
          book.getBookNo(),
          book.getBookName(),
          book.getCompany(),
          book.getAuthor(),
          book.getRegisteredDate());
          member.getName();
    }
  }
}
