package com.example.beans;

import com.example.exception.AppException;
import com.example.exception.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    private String name;
    private int age;

    public boolean validateAge() {
        if(age>110 || age<0) {
            throw new AppException(ErrorCodeEnum.VALIDATE_USER_AGE_FAILED);
        } else {
            return true;
        }

    }

}
