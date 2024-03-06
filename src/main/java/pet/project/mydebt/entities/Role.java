package pet.project.mydebt.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRole;

    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authorities_roles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorities;

}
