package org.tasks.blogplatform.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    @Column(nullable = false,unique = true)
    private String name;


    // Sets prevent duplicate associations between posts and tags.
    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();
/*
\In a many-to-many relationship, we need to carefully consider cascade operations.
 Tags and posts have independent lifecycles - deleting a post shouldn't delete its tags, and deleting a
 tag shouldn't delete associated posts.
 */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(Id, tag.Id) && Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name);
    }
}
