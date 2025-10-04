package org.tasks.blogplatform.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
    private int status;
    private String message;
    private List<FieldError> errors;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class FieldError {
        private String field;
        private String message;
    }
}
