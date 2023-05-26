package project.SignUpMember.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.SignUpMember.Mapper.MemberMapper;
import project.SignUpMember.domain.Member;
import project.SignUpMember.domain.login_member;

@Service // 이 클래스가 서비스 클래스라는 걸 알려줌
public class MemberService {

    private final MemberMapper memberMapper;
    private Member member;
    @Autowired // 빈을 찾아 자동으로 주입
    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    private final PasswordEncoder passwordEncoder;
    @Transactional //메서드 실행 전에 트랜잭션을 시작하고, 메서드 실행 중에 예외가 발생하지 않으면 트랜잭션을 커밋하고, 예외가 발생하면 트랜잭션을 롤백합니다.
    public void joinMember(Member member) {
        String inputpw = member.getPassword();
        String encodepw = passwordEncoder.encode(inputpw);
        member.setPassword(encodepw);
        memberMapper.joinMember(member) ;
    }

    @Transactional
    public Member findUserid(String member) {
        try{

            Member check_member = memberMapper.findUserid(member);
            return check_member;
        }
        catch (Exception e){
            return null;
        }
    }

    @Transactional
    public login_member getMember(String userid){
        try{
            login_member member = memberMapper.getMember(userid);
            return member;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean isUserIdExists(String userid){ // 해당 아이디가 있는지 확인

        return memberMapper.findUserid(userid) != null;
    }

    public boolean passwordcheck(login_member member, String inputPW) {
        String storedPW = member.getPassword();

        //비밀번호 비교
        return passwordEncoder.matches(inputPW, storedPW);
    }
}

//    public boolean passwordcheck(login_member member, String inputPW) {
//        String storedPW = member.getPassword();
//        //비밀번호 비교
//        return storedPW.equals(inputPW);
//    }

