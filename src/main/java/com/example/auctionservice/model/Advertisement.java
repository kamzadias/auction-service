package com.example.auctionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double minimumPrice;
    private Double currentPrice;
    private String status; // "ACTIVE" или "INACTIVE"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Дополнительные поля, такие как изображение, дата создания и т.д.
}
