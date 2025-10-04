package org.tasks.blogplatform.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.tasks.blogplatform.domain.Category;
import org.tasks.blogplatform.domain.Post;
import org.tasks.blogplatform.domain.PostStatus;
import org.tasks.blogplatform.domain.dtos.CategoryDto;
import org.tasks.blogplatform.domain.dtos.CreateCategoryRequest;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface CategoryMapper {
    @Mapping(target = "postCount", source = "posts",qualifiedByName = "CalculatePostCount")
    CategoryDto toDto(Category category);

    @Named("CalculatePostCount")
    default long CalculatePostCount(java.util.List<Post> posts){
        if(posts == null){
            return 0;
        }
        return posts.stream().filter(post -> PostStatus.PUBLISHED.equals((post.getStatus()))).count();
    }
    Category toEntity(CreateCategoryRequest createCategoryRequest);
}
