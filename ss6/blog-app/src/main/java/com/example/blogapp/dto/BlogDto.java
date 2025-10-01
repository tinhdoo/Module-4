package com.example.blogapp.dto;

import com.example.blogapp.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {

        private Integer id;

        @NotBlank(message = "Tiêu đề không được để trống")
        @Size(min = 5, max = 100, message = "Tiêu đề phải từ 5 đến 100 ký tự")
        private String title;

        @NotBlank(message = "Nội dung không được để trống")
        private String content;

        @NotBlank(message = "Tác giả không được để trống")
        private String author;

        private LocalDate date;

        @NotBlank(message = "Trạng thái không được để trống")
        private String status;

        @NotNull(message = "Danh mục không được để trống")
        private Integer categoryId;

}
