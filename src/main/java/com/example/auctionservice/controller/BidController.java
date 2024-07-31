package com.example.auctionservice.controller;

import com.example.auctionservice.model.Bid;
import com.example.auctionservice.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/advertisement/{advertisementId}")
    public ResponseEntity<List<Bid>> getBidsByAdvertisement(@PathVariable Long advertisementId) {
        List<Bid> bids = bidService.findByAdvertisementId(advertisementId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bid> placeBid(@RequestBody Bid bid) {
        try {
            Bid savedBid = bidService.placeBid(bid);
            return new ResponseEntity<>(savedBid, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Дополнительные методы для управления ставками
}
