package com.jeananani.immosmart.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignRolesRequest {

    @NotNull(message = "Un ou plusieurs rôles est obligatoire")
    List<Long> roleIds;
}
