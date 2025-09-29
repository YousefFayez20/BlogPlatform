package org.tasks.blogplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tasks.blogplatform.domain.Tag;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}
