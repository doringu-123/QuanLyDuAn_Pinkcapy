package com.tuyendung.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.tuyendung.entity.User;
import com.tuyendung.exception.JobPortalException;
import com.tuyendung.utility.Utilities;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Id
    private String id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    @Indexed(unique = true)
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    private AccountType accountType;

    public User toEntity() {
        User user = new User();
        if (this.id != null) user.setId(String.valueOf(this.id));
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setAccountType(this.accountType);
        return user;
    }

    public void setId(String id) {
        this.id = id;
    }
}
