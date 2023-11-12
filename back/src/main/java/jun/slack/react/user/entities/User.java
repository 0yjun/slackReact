package jun.slack.react.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user")
public class User {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String password;
}