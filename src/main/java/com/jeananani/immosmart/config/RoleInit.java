package com.jeananani.immosmart.config;

import com.jeananani.immosmart.enums.RoleName;
import com.jeananani.immosmart.models.Role;
import com.jeananani.immosmart.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoleInit implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    @NullMarked
    public void run(String... args) {
        log.info("Initialisation des rôles dans la base de données...");
        initializeRoles();
        log.info("Initialisation des rôles terminés.");
    }

    private String getDescription(RoleName roleName) {
        return switch (roleName) {
            case ROLE_ADMIN -> "Administrateur";
            case ROLE_SELLER -> "Vendeur (Propriétaire)";
            case ROLE_USER -> "Utilisateur (Client)";
        };
    }

    private void initializeRoles() {
        for (RoleName roleName : RoleName.values()) {
            if (!roleRepository.existsByName(roleName)) {
                Role role = Role.builder()
                        .name(roleName)
                        .description(getDescription(roleName))
                        .build();
                roleRepository.save(role);
                log.debug("Rôle créé: {}", roleName);
            } else {
                log.debug("Rôle déjà existant: {}", roleName);
            }
        }
    }
}
