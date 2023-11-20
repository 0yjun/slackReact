package jun.slack.react.api.user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String nickname;
    private String password;
}
