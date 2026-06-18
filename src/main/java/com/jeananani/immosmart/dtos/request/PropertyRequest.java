package com.jeananani.immosmart.dtos.request;

import com.jeananani.immosmart.enums.PropertyStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyRequest {

    private String title;
    private double price;
    private String location;
    private String description;
   // private List<String> pictures;
    private String category;
    private String subCategory;
    private String type;
   // private String offerStatus;
    private PropertyStatus status;
    private int numberOfRoom;
    private double latitude;
    private double longitude;
}
