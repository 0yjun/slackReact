package jun.slack.react.api.user.controller;

import brave.internal.Nullable;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jun.slack.react.api.user.entities.User;
import jun.slack.react.api.user.entities.UserDTO;
import jun.slack.react.api.user.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Optional;

@RequestMapping("/api/user")
@RestController
@Data
public class UserController {
    @Autowired
    private final UserService userService;

    //[GET]
    @GetMapping("/login")
    public ResponseEntity<?> joinGet (HttpServletRequest request, @Nullable @CookieValue String userEmail) {
        if(userEmail != null){
            Optional<User> findUser = userService.findByEmail(userEmail);
            if(findUser.isPresent()){
                return ResponseEntity.ok().body(findUser.get());
            }
        }

        return null;
    }

    @PostMapping("/logout")
    public void logout (HttpServletResponse response, @Nullable @CookieValue String userEmail) {
        Cookie cookie = new Cookie("userEmail", userEmail);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    //[post]
    @PostMapping("/")
    public ResponseEntity<?> join (@RequestBody UserDTO userDTO) {
        System.out.println("sign up ");
        return userService.save(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginGet(HttpServletResponse response, @RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        Optional<User> findUser = userService.findByEmail(email);
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

        HttpHeaders headers = new HttpHeaders();
        headers.add("Set-Cookie","user2="+findUser.get());
        response.addCookie(new Cookie("userEmail", findUser.get().getEmail()));
        //response.addCookie(new Cookie("user",findUser.get().toString()));
        return ResponseEntity.ok().header(String.valueOf(headers)).body(findUser.get());
    }

}
