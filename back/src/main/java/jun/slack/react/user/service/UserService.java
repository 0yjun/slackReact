package jun.slack.react.user.service;

import jakarta.transaction.Transactional;
import jun.slack.react.user.entities.User;
import jun.slack.react.user.entities.UserDTO;
import jun.slack.react.user.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void save(UserDTO userDTO){
        User user = new User(userDTO);
        userRepository.save(user);
    }
}
