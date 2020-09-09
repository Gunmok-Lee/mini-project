package mini.project.handler;

import java.util.List;
import com.eomcs.util.Prompt;
import mini.project.domain.Member;

public class MemberHandler {
  List<Member> memberList;

  public MemberHandler(List<Member> list) {
    this.memberList = list;
  }

  public void add() {
    System.out.println("[회원 가입]");

    Member member = new Member();
    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("이메일? "));
    member.setPassword(Prompt.inputString("암호? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setTel(Prompt.inputString("전화? "));
    member.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));

    memberList.add(member);
  }
}
