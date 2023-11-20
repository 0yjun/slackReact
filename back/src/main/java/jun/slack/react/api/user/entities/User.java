package jun.slack.react.api.user.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, unique = true, length = 30)
    private String nickname;

    @Column(nullable = false, length = 100)
    private String password;

    @Builder
    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.email = userDTO.getEmail();
        this.nickname = userDTO.getNickname();
        this.password = userDTO.getPassword();
    }

    //@OneToMany(mappedBy = "owner")
    //private List<Workspace> ownedWorkspaces;

    //@ManyToMany(mappedBy = "members")
    //private List<Workspace> workspaces;

    //@ManyToMany(mappedBy = "members")
   //private List<Channel> channels;

    //@OneToMany(mappedBy = "user")
    //private List<ChannelChat> channelChats;

    // getters and setters
}