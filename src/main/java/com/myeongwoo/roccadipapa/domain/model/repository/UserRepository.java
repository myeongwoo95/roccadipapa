package com.myeongwoo.roccadipapa.domain.model.repository;

import com.myeongwoo.roccadipapa.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);
}
