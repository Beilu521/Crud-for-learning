package main.java.com.beilu.demo.mapper;

import java.util.List;

import main.java.com.beilu.demo.entity.user;

@Mapper
public interface UserMapper extends BaseMapper<user> {
    List<User> selectByUsername(@Param("username") String username);
    List<User> selectByNickname(@Param("nickname") String nickname);
}
    
