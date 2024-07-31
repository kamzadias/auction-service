package com.example.auctionservice.service;

import com.example.auctionservice.model.Bid;
import java.util.List;

public interface BidService {
    List<Bid> findByAdvertisementId(Long advertisementId);
    Bid placeBid(Bid bid);
    // Дополнительные методы для управления ставками
}
