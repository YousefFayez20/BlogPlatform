package org.tasks.blogplatform.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(unique = true,nullable = false)
    private String name;
    //many posts can be attached to one category
    //post should have one category
    @OneToMany(mappedBy = "category")
    public List<Post> posts = new ArrayList<>();
    //the initialization of the posts collection with new ArrayList<>() prevents null pointer exceptions when accessing collection

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(Id, category.Id) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name);
    }
}
