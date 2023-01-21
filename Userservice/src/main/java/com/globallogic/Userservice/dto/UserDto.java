package com.globallogic.Userservice.dto;

import com.globallogic.Userservice.model.Address;
import com.globallogic.Userservice.model.Company;
import com.globallogic.Userservice.model.Geo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int userId;
    @NotBlank(message = "Name can not be blank")
    private String name;
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "kindly enter valid email id")
    private String email;
    @NotBlank(message = "username can not be blank")
    private String userName;
    private Address address;
    @NotBlank(message = "phone number can not be blank")
    @Pattern(regexp = "^\\d{10}$", message = "Kindly enter valid 10 digit number")
    private String phone;
    private Geo geo;
    private Company company;
}
