package com.myeongwoo.roccadipapa.domain.model.entity;

import com.myeongwoo.roccadipapa.application.request.UserSignupRequest;
import com.myeongwoo.roccadipapa.domain.model.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "users")
@DynamicUpdate
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(UserSignupRequest userSignupRequest) {
        this.username = userSignupRequest.getUsername();
        this.password = userSignupRequest.getPassword();
        this.role = UserRole.ROLE_USER;
    }
}
