package jun.slack.react.api.user.service;

import jakarta.transaction.Transactional;
import jun.slack.react.api.user.entities.User;
import jun.slack.react.api.user.entities.UserDTO;
import jun.slack.react.api.user.repository.UserRepository;
import lombok.Data;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional
    public ResponseEntity<?> save(UserDTO userDTO){
        User user = new User(userDTO);
        try {
            userRepository.save(user);
        }catch (DuplicateKeyException e){
            return ResponseEntity.internalServerError().body("내부 오류 발생");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("중복 외 오류");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
