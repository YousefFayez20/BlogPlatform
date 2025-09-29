package org.tasks.blogplatform.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    @Column
    private int readingTime;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    public Category category;

    @ManyToOne
    @JoinColumn(nullable = false,name = "author_id")
    public User user;

    @ManyToMany
    @JoinTable(name = "posts_tags",
    joinColumns = @JoinColumn(name = "post_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    PostStatus status;
    @PrePersist
    public void OnCreate(){
        this.updatedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void OnUpdate(){
        this.updatedAt = LocalDateTime.now();
    }






}
