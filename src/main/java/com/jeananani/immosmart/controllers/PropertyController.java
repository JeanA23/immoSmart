package com.jeananani.immosmart.controllers;

import com.jeananani.immosmart.dtos.request.PropertyRequest;
import com.jeananani.immosmart.dtos.response.ApiResponse;
import com.jeananani.immosmart.dtos.response.PageResponse;
import com.jeananani.immosmart.dtos.response.PropertyResponse;
import com.jeananani.immosmart.models.Property;
import com.jeananani.immosmart.service.PropertyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/immoSmart/properties")
public class PropertyController {

    private final PropertyService propertyService;



    @PostMapping("/create")
    public ResponseEntity<@NonNull ApiResponse<PropertyResponse>> savePropertyResponse(@RequestBody PropertyRequest request, @AuthenticationPrincipal UserDetails userDetails){

        PropertyResponse property = propertyService.createProperty(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Utilisateur créé avec succès", property));
    }

    @GetMapping
    public ResponseEntity<PageResponse<PropertyResponse>> findAll(

            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "numberOfRoom", required = false) String numberOfRoom,
            @RequestParam(value = "location", required = false) String location,

            @PageableDefault(
                    size = 50,
                    direction = Sort.Direction.DESC,
                    sort = {"createdAt"})

            Pageable pageable,
            Principal principal
    ) {
        Page<PropertyResponse> props = propertyService.findAll(
                userId,
                search,
                minPrice,
                maxPrice,
                category,
                type,
                numberOfRoom,
                location,
                pageable,
                principal

        );

        return ResponseEntity.ok(PageResponse.of(props));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyResponse> findById(@PathVariable Long id){

        Property prop = propertyService.findById(id);

     return ResponseEntity.ok(PropertyResponse.fromEntity(prop));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<PropertyResponse> updatePropertyResponse(@PathVariable Long id, @RequestBody PropertyRequest request){

        return ResponseEntity.ok(propertyService.updateProperty(id, request));
    }

}
