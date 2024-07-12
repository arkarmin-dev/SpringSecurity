package com.myCompany.MyWebApp.persistance.entity;

import com.myCompany.MyWebApp.web.form.UserForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 45, nullable = false, name = "user_name")
    private String userName;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 15, nullable = false)
    private String password;

    public User(UserForm userForm) {
        this.id = userForm.getId();
        this.userName = userForm.getUserName();
        this.email = userForm.getEmail();
        this.password = userForm.getPassword();
    }
}
