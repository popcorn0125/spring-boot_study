package project.SignUpMember.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.SignUpMember.Mapper.PostMapper;
import project.SignUpMember.domain.Post;

@Service
public class PostService {

    private final PostMapper postMapper;

    //private Post post;

    @Autowired
    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Transactional
    public void registerPost(Post post) {
        postMapper.registerPost(post);
    }
}
