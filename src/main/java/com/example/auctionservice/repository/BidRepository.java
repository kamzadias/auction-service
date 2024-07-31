package com.example.auctionservice.repository;

import com.example.auctionservice.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByAdvertisementId(Long advertisementId);
}
