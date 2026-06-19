package com.jeananani.immosmart.dtos.response;

import com.jeananani.immosmart.enums.PropertyStatus;
import com.jeananani.immosmart.models.Property;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyResponse {

    private long id;

    private String title;
    private double price;
    private String location;
    private String description;

   // private List<String> pictures;
    private long userId;
    private String category;
    private String subCategory;
    private String type;

   // private PropertyOfferStatus offerStatus;
    private PropertyStatus status;
    private int numberOfRoom;
    private double latitude;
    private double longitude;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isFavorite;

    public static PropertyResponse fromEntity(Property property) {

        return PropertyResponse.builder()
                .id(property.getId())
                .title(property.getTitle())
                .price(property.getPrice())
                .location(property.getLocation())
                .description(property.getDescription())
                .userId(property.getUser().getId())
                .category(property.getCategory())
                .subCategory(property.getSubCategory())
                .type(property.getType())
                .status(property.getStatus())
                .numberOfRoom(property.getNumberOfRoom())
                .latitude(property.getLatitude())
                .longitude(property.getLongitude())
                .createdAt(property.getCreatedAt())
                .updatedAt(property.getUpdatedAt())
                .isFavorite(property.isFavorite())
                .build();
    }
}
