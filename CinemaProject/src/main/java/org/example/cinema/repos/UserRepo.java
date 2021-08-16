package org.example.cinema.repos;

import org.example.cinema.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

}
