package com.greatminds.ayni.authentication.domain.model.aggregates;

import com.greatminds.ayni.authentication.domain.model.valueobjects.EmailAddress;
import com.greatminds.ayni.authentication.domain.model.valueobjects.Password;
import com.greatminds.ayni.authentication.domain.model.valueobjects.Username;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "users")
public class User extends AbstractAggregateRoot<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private Username username;

    @Embedded
    private EmailAddress email;

    @Embedded
    private Password password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Setter
    @Getter
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password){
        this.username = new Username(username);
        this.password = new Password(password);
        this.email = new EmailAddress(email);
    }

    public User() {}


    public String getUsername() { return this.username.username(); }
    public String getEmail() { return this.email.email(); }
    public String getPassword() { return this.password.password(); }
}
