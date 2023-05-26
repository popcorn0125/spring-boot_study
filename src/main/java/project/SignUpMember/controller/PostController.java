package project.SignUpMember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.SignUpMember.domain.Post;
import project.SignUpMember.service.PostService;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
//    @GetMapping("/post_write") // 버튼을 누르면 글을 작성하는 페이지가 나옴
//    public String postForm(){
//        return "/postForm";
//    }

    @PostMapping("/post_register") // 등록하기 버튼을 누르면 DB에 작성글 저장
    public String Register(@RequestBody Post post){

        postService.registerPost(post);

        return "success";
    }

    //수정버튼을 클릭하였을 때


}
