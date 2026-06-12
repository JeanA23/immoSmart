package com.jeananani.immosmart.security;

import com.jeananani.immosmart.models.User;
import com.jeananani.immosmart.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    @NullMarked
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Chargement de l'utilisateur par email: {}", email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.warn("Utilisateur non trouvé avec l'email: {}", email);
                    return new UsernameNotFoundException("Utilisateur non trouvé avec l'email: " + email);
                });

        log.debug("Utilisateur trouvé: {} avec rôle: {}", user.getEmail(), user.getRoles());
        return UserDetailsImpl.build(user);
    }
}
