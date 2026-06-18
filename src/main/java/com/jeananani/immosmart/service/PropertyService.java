package com.jeananani.immosmart.service;

import com.jeananani.immosmart.dtos.request.PropertyRequest;
import com.jeananani.immosmart.dtos.response.PropertyResponse;
import com.jeananani.immosmart.models.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;

public interface PropertyService {

    PropertyResponse createProperty(PropertyRequest property);

    PropertyResponse updateProperty(Long propertyId, PropertyRequest request);

    Page<PropertyResponse> findAll(Long userId, String search, Double minPrice, Double maxPrice, String category,
                                   String type, String numberOfRoom, String location, Pageable pageable, Principal principal);

    Property findById(Long id);

    void delete(Property property);
}
