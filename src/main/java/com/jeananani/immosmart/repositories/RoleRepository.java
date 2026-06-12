package com.jeananani.immosmart.repositories;

import com.jeananani.immosmart.enums.RoleName;
import com.jeananani.immosmart.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Recherche un rôle par son nom.
     *
     * @param name le nom du rôle
     * @return un Optional contenant le rôle si trouvé
     */
    Optional<Role> findByName(RoleName name);

    /**
     * Vérifie l'existence d'un rôle par son nom.
     *
     * @param name le nom du rôle à vérifier
     * @return true si le rôle existe, false sinon
     */
    boolean existsByName(RoleName name);
}
