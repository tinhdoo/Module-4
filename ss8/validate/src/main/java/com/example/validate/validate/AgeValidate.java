package com.example.validate.validate;

import com.example.validate.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidate implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (userDto.getAge() == null) {
            errors.rejectValue("age", "", "Ngày sinh không được để trống");
            return;
        }

        int years = Period.between(userDto.getAge(), LocalDate.now()).getYears();
        if (years < 18) {
            errors.rejectValue("age", "", "Phải đủ 18 tuổi");
        }
    }

}
