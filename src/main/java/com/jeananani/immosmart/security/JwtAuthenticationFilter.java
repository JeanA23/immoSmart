package com.jeananani.immosmart.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
/**
 * OncePerRequestFilter s'exécute une seule fois par requête HTTP :
 * récupérer le JWT dans l’en‑tête
 * vérifier qu’il est valide
 * extraire l’email
 * charger l’utilisateur
 * dire à Spring Security : “Cet utilisateur est authentifié”
 *
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    @NullMarked
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        try {
            String jwt = extractJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)) {
                String email = jwtTokenProvider.getEmailFromToken(jwt);

                log.debug("Token JWT valide pour l'utilisateur: {}", email);

                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                //Représente un utilisateur authentifié dans Spring.
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                //C’est la ligne qui dit à Spring “Cet utilisateur est authentifié pour cette requête.”
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //C’est la “mémoire de sécurité” de Spring pour la requête en cours.
                // Il contient l’utilisateur authentifié, ses rôles, et les détails de la requête.
                SecurityContextHolder.getContext().setAuthentication(authentication);

                log.debug("Authentification réussie pour: {}", email);
            }
        } catch (Exception ex) {
            log.error("Impossible de définir l'authentification utilisateur: {}", ex.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    /**
     * Supprime le Bearer du token
     * @param request requête
     * @return le token sans Bearer
     */
    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }
}
