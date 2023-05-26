package project.SignUpMember.Mapper;


import project.SignUpMember.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import project.SignUpMember.domain.login_member;

@Mapper // Mapper 인터페이스로 인식
public interface MemberMapper {

    void joinMember(Member member);
    public login_member getMember(String userid);

    public Member findUserid(String member);

}
