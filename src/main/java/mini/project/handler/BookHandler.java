package mini.project.handler;

import java.util.Iterator;
import java.util.List;
import mini.project.domain.Book;
import mini.project.domain.Rent;
import mini.project.util.Prompt;

public class BookHandler {

  List<Book> bookList;
  MemberHandler memberHandler;
  Book book;

  public BookHandler(List<Book> list, MemberHandler memberHandler) {
    this.bookList = list;
    this.memberHandler = memberHandler;
  }

  public void add() {
    System.out.println("[도서 등록]");

    Book book = new Book();
    book.setBookNo(Prompt.inputInt("도서 번호: "));
    book.setBookName(Prompt.inputString("도서명: "));
    book.setCompany(Prompt.inputString("출판사: "));
    book.setAuthor(Prompt.inputString("저자: "));
    book.setRentAble("ok");



    bookList.add(book);
  }

  public void list() {
    System.out.println("[도서 목록]");

    Iterator<Book> iterator = bookList.iterator();

    while (iterator.hasNext()) {
      Book book = iterator.next();
      System.out.printf(" 도서 번호: %d\n 도서명: %s\n 출판사: %s\n"
          + " 저자: %s\n",
          book.getBookNo(),
          book.getBookName(),
          book.getCompany(),
          book.getAuthor());
    }
  }

  public void update() {
    System.out.println("[도서정보 수정]");
    int bookNo = Prompt.inputInt("도서 번호: ");
    Book book = findByNo(bookNo);

    if(book == null) {
      System.out.println("해당 번호의 도서가 없습니다.");
      return;
    }

    String bookName = Prompt.inputString(
        String.format("도서명: [%s] => ", book.getBookName()));
    String company = Prompt.inputString(
        String.format("출판사: [%s] => ", book.getCompany()));
    String author = Prompt.inputString(
        String.format("저자: [%s] => ", book.getAuthor()));

    book.setBookName(bookName);
    book.setCompany(company);
    book.setAuthor(author);

    System.out.println("도서정보를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[도서정보 삭제]");
    int bookNo = Prompt.inputInt("도서 번호: ");
    int index = indexOf(bookNo);

    if (index == -1) {
      System.out.println("해당 번호의 도서 번호가 없습니다.");
      return;
    }

    String response = Prompt.inputString("삭제하시겠습니까?(y/N) ");
    if(!response.equalsIgnoreCase("y")) {
      System.out.println("도서 정보삭제를 취소하였습니다.");
      return;
    }

    bookList.remove(index);
    System.out.println("도서 정보를 삭제하였습니다.");
  }
  //-------------------------------------------------rent관련 메서드
  public void rent() {
    System.out.println("[도서 대여]");

    Rent rent = new Rent();
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
    rentList.add(rent);
  }

  public void searchRentAble() {
    System.out.println("[대여 가능 도서목록]");
    findByBookInfo();
  }

  public void rentImpossible() {
    System.out.println("[대여중 도서목록]");
    findByBookInfo("no");

  }

  private Book findByNo(int no) {
    for (int i = 0; i < bookList.size(); i++) {
      Book book = bookList.get(i);
      if (book.getBookNo() == no) {
        return book;
      }
    }
    return null;
  }

  public void findByBookInfo() {
    for (int i = 0; i < bookList.size(); i++) {
      Book book = bookList.get(i);
      String able = "ok";
      if (able.equals(book.getRentAble())) {
        System.out.println("==========================");
        System.out.printf("도서번호: %s\n", book.getBookNo());
        System.out.printf("도서명: %s\n", book.getBookName());
        System.out.printf("출판사: %s\n", book.getCompany());
        System.out.printf("저자: %s\n", book.getAuthor());
        return;
      }
    }
    return;
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