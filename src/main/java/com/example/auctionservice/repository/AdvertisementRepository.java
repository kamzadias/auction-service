package com.example.auctionservice.repository;

import com.example.auctionservice.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findByStatus(String status);
}
