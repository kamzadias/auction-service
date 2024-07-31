package com.example.auctionservice.controller;

import com.example.auctionservice.model.Advertisement;
import com.example.auctionservice.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public ResponseEntity<List<Advertisement>> getAllAdvertisements() {
        List<Advertisement> advertisements = advertisementService.findAll();
        return new ResponseEntity<>(advertisements, HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Advertisement>> getActiveAdvertisements() {
        List<Advertisement> advertisements = advertisementService.findActiveAdvertisements();
        return new ResponseEntity<>(advertisements, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement savedAdvertisement = advertisementService.saveAdvertisement(advertisement);
        return new ResponseEntity<>(savedAdvertisement, HttpStatus.CREATED);
    }

    // Дополнительные методы для управления объявлениями
}
