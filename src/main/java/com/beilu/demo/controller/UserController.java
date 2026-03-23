package main.java.com.beilu.demo.controller;

import com.beilu.demo.common.Result;
import com.beilu.demo.entity.User;
import com.beilu.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") 
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<User>> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Result.error("用户不存在"));
        }
        return ResponseEntity.ok(Result.success(user));
    }


    @PostMapping
    public ResponseEntity<Result<User>> create(@RequestBody User user) {
        boolean saved = userService.save(user);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED) 
                    .body(Result.success(user));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Result.error("新增失败"));
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Result<User>> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        boolean updated = userService.updateById(user);
        if (updated) {
            return ResponseEntity.ok(Result.success(user));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Result.error("更新失败，用户不存在"));
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Result<Void>> delete(@PathVariable Long id) {
        boolean removed = userService.removeById(id);
        if (removed) {
            return ResponseEntity.ok(Result.success());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Result.error("删除失败，用户不存在"));
        }
    }


    @GetMapping
    public ResponseEntity<Result<List<User>>> list() {
        List<User> users = userService.list();
        return ResponseEntity.ok(Result.success(users));
    }

   
    @GetMapping("/search/username")
    public ResponseEntity<Result<List<User>>> searchByUsername(@RequestParam String keyword) {
        List<User> users = userService.listByUsername(keyword);
        return ResponseEntity.ok(Result.success(users));
    }

  
    @GetMapping("/search/nickname")
    public ResponseEntity<Result<List<User>>> searchByNickname(@RequestParam String keyword) {
        List<User> users = userService.listByNickname(keyword);
        return ResponseEntity.ok(Result.success(users));
    }
}