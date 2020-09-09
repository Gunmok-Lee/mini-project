package mini.project.handler;

import java.util.Iterator;
import java.util.List;
import mini.project.domain.Member;
import mini.project.util.Prompt;

public class MemberHandler {
  List<Member> memberList;

  public MemberHandler(List<Member> list) {
    this.memberList = list;
  }

  public void add() {
    System.out.println("[회원가입]");

    Member member = new Member();
    while (true) {
      int count = 0;
      String id = Prompt.inputString("아이디 : ");
      for (int i = 0; i < memberList.size(); i++) {
        if (id.equals(memberList.get(i).getId())) {
          count++;
          System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
          break;
        } // end if
      } // end for
      if(count == 0) {
        member.setId(id);
        break;
      }
    } // end while
    member.setName(Prompt.inputString("이름 : "));
    member.setAge(Prompt.inputInt("나이 : "));
    member.setGender(Prompt.inputInt("성별(1: 남자/2: 여자) : "));
    member.setEmail(Prompt.inputString("이메일 : "));
    member.setPassword(Prompt.inputString("패스워드 : "));
    member.setTel(Prompt.inputString("전화번호 : "));
    member.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));

    memberList.add(member);
    System.out.println("회원가입을 축하합니다.");
  }

  public void list() {
    System.out.println("[회원 리스트]");

    Iterator<Member> iterator = memberList.iterator();

    while (iterator.hasNext()) {
      Member member = iterator.next();
      String genderLabel = null;
      if (member.getGender() == 1) {
        genderLabel = "남자";
      } else {
        genderLabel = "여자";
      }
      System.out.printf("아이디(%s), 이름(%s), 성별(%s), 가입일(%s)\n",
          member.getId(),
          member.getName(),
          genderLabel,
          member.getRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[회원 상세정보]");
    String id = Prompt.inputString("아이디 : ");
    String password = Prompt.inputString("패스워드 : ");
    Member member = findInformation(id, password);

    if (member == null) {
      return;
    }


    System.out.printf("아이디: %s\n", member.getId());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("나이: %d\n", member.getAge());
    String genderLabel = null;
    if (member.getGender() == 1) {
      genderLabel = "남자";
    } else {
      genderLabel = "여자";
    }
    System.out.printf("성별: %s\n", genderLabel);
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("가입일: %s\n", member.getRegisteredDate());
  }

  public void update() {
    System.out.println("[회원정보 수정]");
    String id = Prompt.inputString("아이디 : ");
    String password = Prompt.inputString("패스워드 : ");
    Member member = findInformation(id, password);

    if (member == null) {
      return;
    }

    String name = Prompt.inputString(
        String.format("이름 : [%s] => ", member.getName()));
    int age = Prompt.inputInt(
        String.format("나이 : [%d] => ", member.getAge()));
    String genderLabel = null;
    if (member.getGender() == 1) {
      genderLabel = "남자";
    } else {
      genderLabel = "여자";
    }
    int gender = Prompt.inputInt(
        String.format("성별 : [%s] =>  ", genderLabel));
    String email = Prompt.inputString(
        String.format("이메일 : [%s] => ", member.getEmail()));
    String newPassword = Prompt.inputString("패스워드 :  => ");
    String tel = Prompt.inputString(
        String.format("전화번호 : [%s] => ", member.getTel()));

    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setName(name);
    member.setAge(age);
    member.setGender(gender);
    member.setEmail(email);
    member.setPassword(newPassword);
    member.setTel(tel);

    System.out.println("회원정보를  변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원탈퇴]");
    String id = Prompt.inputString("아이디 : ");
    String password = Prompt.inputString("패스워드 : ");
    int index = indexOf(id, password);

    if (index == -1) {
      return;
    }

    if (index == -2) {
      return;
    }

    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("취소하였습니다..");
      return;
    }

    memberList.remove(index);
    System.out.println("삭제되었습니다.\n그동안 이용해 주셔서 감사합니다.");
  }

  public Member findByName(String name) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }

  public Member findById(String id) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (id.equals(member.getId())) {
        return member;
      }
    }
    return null;
  }

  private Member findInformation(String id, String password) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (id.equals(member.getId())) {
        if(password.equals(member.getPassword())) {
          return member;
        } else {
          System.out.println("잘못된 패스워드입니다.");
          return null;
        }
      }
    }
    System.out.println("존재하지 않는 아이디입니다.");
    return null;
  }

  private int indexOf(String id, String password) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (id.equals(member.getId())) {
        if(password.equals(member.getPassword())) {
          return i;
        } else {
          System.out.println("잘못된 패스워드입니다.");
          return -1;
        }
      }
    }
    System.out.println("존재하지 않는 아이디입니다.");
    return -2;
  }

}
