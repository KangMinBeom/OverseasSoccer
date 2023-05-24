package com.example.soccer.repository;

import com.example.soccer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Autowired
//    private SqlSessionTemplate sql;

    Optional<User> findByEmail(String email);

}
