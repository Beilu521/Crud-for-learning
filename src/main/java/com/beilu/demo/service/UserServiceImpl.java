package main.java.com.beilu.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import main.java.com.beilu.demo.entity.user;
import main.java.com.beilu.demo.mapper.UserMapper;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, user> implements UserService {
    @Autowired
    private UserMapper userMapper;

   @Override
    public List<User> listByUsername(String username) {
        if (!StringUtils.hasText(username)) {
            return Collections.emptyList(); 
        }
        return userMapper.selectByUsername(username);
    }

        @Override
    public List<User> listByNickname(String nickname) {
        if (!StringUtils.hasText(nickname)) {
            return Collections.emptyList();
        }
        return userMapper.selectByNickname(nickname);
    }
}
