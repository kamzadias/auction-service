package com.example.auctionservice.service;

import com.example.auctionservice.model.Advertisement;
import java.util.List;

public interface AdvertisementService {
    List<Advertisement> findAll();
    List<Advertisement> findActiveAdvertisements();
    Advertisement saveAdvertisement(Advertisement advertisement);
    // Дополнительные методы для управления объявлениями
}
