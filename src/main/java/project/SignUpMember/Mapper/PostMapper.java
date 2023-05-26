package project.SignUpMember.Mapper;

import org.apache.ibatis.annotations.Mapper;
import project.SignUpMember.domain.Post;

@Mapper
public interface PostMapper {

    void registerPost(Post post);
}
