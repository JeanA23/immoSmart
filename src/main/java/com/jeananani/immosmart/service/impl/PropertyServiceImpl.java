package com.jeananani.immosmart.service.impl;

import com.jeananani.immosmart.dtos.request.PropertyRequest;
import com.jeananani.immosmart.dtos.response.PropertyResponse;
import com.jeananani.immosmart.models.Property;
import com.jeananani.immosmart.models.User;
import com.jeananani.immosmart.repositories.PropertyRepository;
import com.jeananani.immosmart.repositories.UserRepository;
import com.jeananani.immosmart.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;


    /**
     *
     *
     *
     * @param request
     * @return
     */
    @Override
    public PropertyResponse createProperty(PropertyRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String email = auth.getName();


        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + email));
        System.out.println("User trouvé : " + user.getId());

        Property property1 = buildNewProperty(request);
        property1.setUser(user);

        Property saveProperty = propertyRepository.save(property1);
        return PropertyResponse.fromEntity(saveProperty);
    }

    /**
     *
     * Mise à jour des informations de la propriété
     *
     * @param propertyId l'identifiant de la propriété
     * @param request la requête de création
     * @return la propriété modifiée
     */
    @Override
    public PropertyResponse updateProperty(Long propertyId, PropertyRequest request) {

       // Property propertyFromDto = convertToEntity(request);

        Property propertyExist =  propertyRepository.findById(propertyId).orElse(null);


        propertyExist.setTitle(request.getTitle());
        propertyExist.setDescription(request.getDescription());
        propertyExist.setPrice(request.getPrice());

        Property updateProperty = propertyRepository.save(propertyExist);


        return PropertyResponse.fromEntity(updateProperty);
    }

    /**
     *
     * @param userId
     * @param search
     * @param minPrice
     * @param maxPrice
     * @param category
     * @param type
     * @param numberOfRoom
     * @param location
     * @param pageable
     * @param principal
     * @return
     */
    @Override
    public Page<PropertyResponse> findAll(Long userId, String search, Double minPrice, Double maxPrice,
                                          String category, String type, String numberOfRoom, String location, Pageable pageable, Principal principal) {

        Specification<Property> spec = Specification.allOf();

        if (Objects.nonNull(userId)) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner").get("email"), principal.getName()));
        }


        if (Objects.nonNull(search)) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.and(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("location")), "%" + search.toLowerCase() + "%")
                    )
            );
        }

        if (Objects.nonNull(minPrice)) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
        }

        if (Objects.nonNull(maxPrice)) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }

        if (Objects.nonNull(category)) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), category));
        }

        if (Objects.nonNull(type)) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type));
        }

        if (Objects.nonNull(numberOfRoom)) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("numberOfRoom"), numberOfRoom));
        }

        if (Objects.nonNull(location)) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("location"), location));
        }

        var props = propertyRepository.findAll(spec, pageable);

        if (Objects.nonNull(principal)) {
            props = props.map(p -> {
                p.setFavorite(p.getFavorites().stream().anyMatch(
                        f -> f.getUser().getEmail().equals(principal.getName())
                ));
                return p;
            });
        }

        return props.map(PropertyResponse::fromEntity);
    }

    @Override
    public Property findById(Long id) {

        return propertyRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Property property) {

        propertyRepository.delete(property);

    }


    /**
     *Construit de nouvelle propriété à partir de la requête de création
     *
     *
     * @param request la requête de création
     * @return la nouvelle propriété construite
     *
     */
    private Property buildNewProperty(PropertyRequest request) {

        return Property.builder()
                .title(request.getTitle())
                .price(request.getPrice())
                .location(request.getLocation())
                .description(request.getDescription())
                .category(request.getCategory())
                .subCategory(request.getSubCategory())
                .type(request.getType())
                .status(request.getStatus())
                .numberOfRoom(request.getNumberOfRoom())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();

    }

    // Conversion DTO -> Entity
    private Property convertToEntity(PropertyRequest propertyRequest) {
        Property property = new Property();

        property.setTitle(propertyRequest.getTitle());
        property.setDescription(propertyRequest.getDescription());
        property.setPrice(propertyRequest.getPrice());
        property.setType(propertyRequest.getType());

        return property;
    }
}
