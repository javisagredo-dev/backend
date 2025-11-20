package cl.duocuc.huertohogar.backend.repository;

import cl.duocuc.huertohogar.backend.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    
}