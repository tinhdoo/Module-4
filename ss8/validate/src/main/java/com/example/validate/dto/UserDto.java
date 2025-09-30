package com.example.validate.dto;

import com.example.validate.validate.UniqueEmail;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;

    @Pattern(regexp = "^[A-Za-zÀ-ỹà-ỹ\\\\s]{3,10}$", message = "Tên phải viết hoa chữ cái đầu và nằm trong khoản từ 3-10!")
    @Column(name = "firstName")
    private String firstName;

    @Pattern(regexp = "^[A-Za-zÀ-ỹà-ỹ\\\\s ]{2,10}$", message = "Họ phải viết hoa chữ cái đầu và nằm trong khoản từ 2-10!")
    @Column(name = "lastName")
    private String lastName;

    @Pattern(regexp = "^(0|\\\\+84)[0-9]{9}$", message = "Số điện thoại phải viết đúng định dạng 0xxxxxxxxx")
    @Column(name = "phoneNumber")
    private String phoneNumber;


    @Column(name = "age")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate age;

    @Email(message = "Email không hợp lệ")
    @UniqueEmail
    @Column(name = "email")
    private String email;

}