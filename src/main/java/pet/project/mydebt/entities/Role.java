package pet.project.mydebt.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
