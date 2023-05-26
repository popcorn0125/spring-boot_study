package project.SignUpMember.domain;
public class Member {

//    private Integer id;
    private String userid; // 사용자 id
    private String password; // 사용자 비밀번호
    private String name; // 이름
    private String email; // 이메일
    private String phonenumber; //폰 넘버

    public Member() {}
    public Member( String userid, String password, String name, String email, String phonenumber) {

//        this.id = id;
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;

    }
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}

//import lombok.Data;
//@Data
//    public String print(){
//        return "id:"+getId()+"userid:"+getUserid()+"password:"+getPassword()+"name:"+getName()+"email:"+getEmail();
//    }
