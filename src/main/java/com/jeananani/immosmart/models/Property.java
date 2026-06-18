package com.jeananani.immosmart.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jeananani.immosmart.enums.PropertyStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
//@Where(clause = "status != 'DELETED'")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private double price;

    private String location;

    private String description;

    private String category;

    private String subCategory;

    private String type;

    @Enumerated(EnumType.STRING)
    @ColumnDefault(value = "'ACTIVE'")
    private PropertyStatus status;

    private int numberOfRoom;

    private double latitude;

    private double longitude;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    private User user;


}
