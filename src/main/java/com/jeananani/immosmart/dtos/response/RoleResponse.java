package com.jeananani.immosmart.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jeananani.immosmart.models.Role;
import com.jeananani.immosmart.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleResponse {

    private Long id;
    private RoleName roleName;

    public static RoleResponse fromEntity(Role role) {
        return  RoleResponse.builder()
                .id(role.getId())
                .roleName(role.getName())
                .build();
    }
}
