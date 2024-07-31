package com.example.auctionservice.service.impl;

import com.example.auctionservice.model.Advertisement;
import com.example.auctionservice.repository.AdvertisementRepository;
import com.example.auctionservice.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }

    @Override
    public List<Advertisement> findActiveAdvertisements() {
        return advertisementRepository.findByStatus("ACTIVE");
    }

    @Override
    public Advertisement saveAdvertisement(Advertisement advertisement) {
        if (advertisement.getCurrentPrice() == null) {
            advertisement.setCurrentPrice(advertisement.getMinimumPrice());
        }
        return advertisementRepository.save(advertisement);
    }

    // Дополнительные методы
}
