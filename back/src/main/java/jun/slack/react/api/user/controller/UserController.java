package jun.slack.react.api.user.controller;

import jun.slack.react.api.user.entities.User;
import jun.slack.react.api.user.entities.UserDTO;
import jun.slack.react.api.user.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/user")
@RestController
@Data
public class UserController {
    @Autowired
    private final UserService userService;

    //[GET]
    @GetMapping("/")
    public ResponseEntity<?> joinGet () {
        System.out.println("sign up ");
        //return userService.save(userDTO);
        return null;
    }

    //[post]
    @PostMapping("/")
    public ResponseEntity<?> join (@RequestBody UserDTO userDTO) {
        System.out.println("sign up ");
        return userService.save(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginGet(@RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        Optional<User> findUser = userService.getUserRepository().findByEmail(email);
        System.out.println("findmember "+findUser);
        if(findUser.isEmpty()){
            System.out.println("empty");
            return ResponseEntity.internalServerError().body("이메일 이 없습니다.");
        }
        if(!findUser.get().getPassword().equals(password) ){
            System.out.println("miss");
            return ResponseEntity.internalServerError().body("비밀번호 불일치.");
        }
        System.out.println("return ok");
        return ResponseEntity.ok().body(findUser.get());
    }

}
