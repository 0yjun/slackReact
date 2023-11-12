package jun.slack.react.user.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String password;

    public User(UserDTO userDTO){
        this.name = userDTO.getName();
        this.password = userDTO.getPassword();
    }

}