package main.java.com.beilu.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import main.java.com.beilu.demo.entity.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> listByUsername(String username);
    List<User> listByNickname(String nickname);
}
