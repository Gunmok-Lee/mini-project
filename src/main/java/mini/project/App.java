/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mini.project;

import java.util.LinkedList;
import java.util.List;
import mini.project.domain.Book;
import mini.project.domain.Member;
import mini.project.handler.BookHandler;
import mini.project.handler.MemberHandler;
import mini.project.handler.RentHandler;
import mini.project.util.Prompt;

public class App {

  public static void main(String[] args) {

    List<Member> memberList = new LinkedList<>();
    MemberHandler memberHandler = new MemberHandler(memberList);

    List<Book> bookList = new LinkedList<>();
    BookHandler bookHandler = new BookHandler(bookList, memberHandler);
    RentHandler rentHandler = new RentHandler(bookList, memberHandler, bookHandler);

    System.out.println("안녕하십니까? \n비트도서관 대여 관리 시스템 입니다.");
    System.out.println();
    loop:
      while (true) {
        System.out.println("1: 도서 관리, 2: 회원 관리, 3: 대여 관리, 0: 종료\n");
        String command = Prompt.inputString("명령을 입력하세요. > ");
        switch (command) {
          case "1" : {
            System.out.println("[도서관리]\n"
                + "1: 도서 등록, 2: 도서 리스트, 3: 도서정보 수정, 4: 도서정보 삭제");
            String commandBook = Prompt.inputString("도서관리 명령을 입력하세요. > ");
            switch (commandBook) {
              case "1" : bookHandler.add(); break;
              case "2" : bookHandler.list(); break;
              case "3" : bookHandler.update(); break;
              case "4" : bookHandler.delete(); break;
              default :
                System.out.println("존재하지 않는 명령입니다. 초기 화면으로 돌아갑니다.");
            }
          } break ;
          case "2": {
            System.out.println("\n[회원 관리]\n"
                + "1: 회원가입, 2: 회원 간이 명부, 3: 회원 상세정보, 4: 회원정보 수정\n"
                + "5: 회원 삭제, 6: 아이디 찾기, 7: 패스워드 찾기\n");
            String commandMember = Prompt.inputString("회원관리 명령을 입력하세요. > ");
            switch (commandMember) {
              case "1": memberHandler.add(); break;
              case "2": memberHandler.list(); break;
              case "3": memberHandler.detail(); break;
              case "4": memberHandler.update(); break;
              case "5": memberHandler.delete(); break;
              case "6": memberHandler.searchId(); break;
              case "7": memberHandler.searchPassword(); break;
              default :
                System.out.println("존재하지 않는 명령입니다. 초기화면으로 돌아갑니다.");
            }
          } break;
          case "3": {
            System.out.println("[대여 관리]\n"
                + "1: 대여하기, 2: 반납하기, 3: 대여 가능 도서조회, 4: 대여 중인 도서조회, ");
            String commandRent = Prompt.inputString("대여 관리 명령을 입력하세요. > ");
            switch (commandRent) {
              case "1" : rentHandler.add(); break;
              case "2" : rentHandler.delete(); break;
              case "3" : rentHandler.searchRentAble(); break;
              case "4" : rentHandler.rentImpossible(); break;
              default :
                System.out.println("존재하지 않는 명령입니다. 초기 화면으로 돌아갑니다.");
            }
          } break;

          case "0" : {
            System.out.println("이용해 주셔서 감사합니다.");}
          break loop;
          default:
            System.out.println("존재하지 않는 명령입니다.다시 입력해주세요.");
        }
        System.out.println();
      }
    Prompt.close();
  } 
}
