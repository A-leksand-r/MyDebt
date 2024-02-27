package pet.project.mydebt.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @ManyToMany
    @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @OneToMany(mappedBy = "idDonor", fetch = FetchType.LAZY)
    private List<Loan> loans;

}
