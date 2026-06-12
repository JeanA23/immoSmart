package com.jeananani.immosmart.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jeananani.immosmart.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
   // private String fullName;
    private String email;
    private String phone;
    private List<RoleResponse> role;
    private Boolean enabled;
    private Boolean emailVerified;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

    public static UserResponse fromEntity(User user) {

        List<RoleResponse> roles =  user.getRoles()
                .stream()
                .map(RoleResponse::fromEntity)
                .toList();

        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(roles)
                .enabled(user.getEnabled())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
