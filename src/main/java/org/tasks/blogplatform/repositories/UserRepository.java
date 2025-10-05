package org.tasks.blogplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tasks.blogplatform.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
