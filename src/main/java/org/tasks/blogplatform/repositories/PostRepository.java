package org.tasks.blogplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tasks.blogplatform.domain.Post;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
