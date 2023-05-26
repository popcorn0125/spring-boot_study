package project.SignUpMember.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.SignUpMember.DefaultRes;
import project.SignUpMember.ResponseMessage;
import project.SignUpMember.StatusCode;
import project.SignUpMember.domain.Member;
import project.SignUpMember.domain.login_member;
import project.SignUpMember.service.MemberService;

import java.util.List;

@RestController // 해당 클래스를 컨트롤러로 동작하게 한다.
@Component // Spring의 컴포넌트 스캔 과정에서 자동으로 검색되어 스프링 애플리케이션 컨텍스트에 빈으로 등록.
           // 등록된 빈은 스프링 애플리케이션이나 다른 컴포넌트와의 상호작용을 위해 사용될 수 있음.
public class MemberController {
    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //private PasswordEncoder passwordEncoder;


    @PostMapping("/register") // 데이터를 서버로 전송.
    public String register(@RequestBody Member member){
        //String inputpw = member.getPassword();
        //String encodepw = passwordEncoder.encode(inputpw);
        //member.setPassword(encodepw);

        memberService.joinMember(member);
        return "success";
    }

    @PostMapping("/id_check_btn") // userid 중복 체크
    public ResponseEntity check_id(@RequestBody Member member){
        String check_userid = member.getUserid();
        //System.out.println(check_userid);

        if (memberService.isUserIdExists(check_userid)) { // 아이디 중복일 때
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.NO_USE_ID, check_userid), HttpStatus.OK); //중복이라면 사용할 수 없다라고 출력.
        }
        else{ // 중복이 아닐 때
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.USE_ID, check_userid), HttpStatus.OK); // 아이디 사용 가능 출력.
        }
    }

    @PostMapping("/Log_in") // 아이디와 비밀번호를 입력하고 로그인 버튼을 클릭
    public ResponseEntity login (@RequestBody Member member){
        String userid = member.getUserid(); // 입력한 아이디를 저장
        String password = member.getPassword(); // 입력한 비밀번호 저장

        login_member loginMember = memberService.getMember(userid); //
        if(loginMember != null && memberService.passwordcheck(loginMember, password)){ // 아이디 입력하는 곳과 비밀 번호가 일치하다면
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, loginMember), HttpStatus.OK); // 로그인 성공
        }
        else{ // 아이디 입력하는 곳이 빈 공간이거나 비밀 번호가 일치하지 않는다면
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_FAIL, loginMember), HttpStatus.OK); // 로그인 실패

        }
    }
}
//    @GetMapping("/home")
//    public String test(Member member){
//        return "Get Mapping :" + member.print();
//    }

//    public String Login_member(@RequestBody Member member){
//        String userid = member.getUserid();
//        String password = member.getPassword();
//
//        login_member new_member = memberService.getMember(userid);
//        if (new_member != null && memberService.passwordcheck(new_member, password)) {
//            // 로그인 성공
//            return "로그인 성공";
//        }
//        else {
//            return "로그인 실패";
//        }
//
//    }

//    #아이디 중복 확인
//    public ResponseEntity check_id(@RequestBody Member member){
//        String check_userid = member.getUserid();
//        Member check_id = memberService.findUserid(check_userid);
//
//        System.out.println(check_userid);
//
//
//
//        if (memberService.check_Userid(member, check_userid)) {
//            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.NO_USE_ID, check_userid), HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.USE_ID, check_userid), HttpStatus.OK);
//        }