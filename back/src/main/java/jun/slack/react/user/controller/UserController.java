package jun.slack.react.user.controller;

import jun.slack.react.user.entities.UserDTO;
import jun.slack.react.user.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("users")
@Controller
@Data
public class UserController {
    @Autowired
    private final UserService userService;
    @PostMapping("/")
    public ResponseEntity join (UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok().build();
    }
}
