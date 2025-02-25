package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class UserForm {


    @NotBlank(message = "Username Is required")
    @Size(min = 3 , message = "Min 3 Char required")
    private String name;
    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email is Required")
    private String email;
    @NotBlank(message = "Password Is required")
    @Size(min = 6, message = "Min 6 Char is Required")
    private String password;

    @NotBlank(message="About Is Required")
    private String about;
    @Size(min = 8,max = 12,message = "Invalid Phone Number")
    private String phoneNumber;



}
