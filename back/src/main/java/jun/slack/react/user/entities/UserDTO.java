package jun.slack.react.user.entities;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String password;
}
