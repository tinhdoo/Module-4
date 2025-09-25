package com.example.songapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    private Integer id;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z ]{5,800}$", message = "Tên bài hát phải đúng định dạng và không vượt quá 800 ký tự!")
    private String name;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z ]{5,300}$", message = "Tên nghệ sĩ phải đúng định dạng và không vượt quá 300 ký tự!")
    private String singer;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z ,]{5,1000}$", message = "Thể loại nhạc không vượt quá 1000 ký tự!")
    private String type;
}