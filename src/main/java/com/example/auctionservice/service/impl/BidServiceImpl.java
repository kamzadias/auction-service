package com.example.auctionservice.service.impl;

import com.example.auctionservice.model.Bid;
import com.example.auctionservice.repository.BidRepository;
import com.example.auctionservice.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> findByAdvertisementId(Long advertisementId) {
        return bidRepository.findByAdvertisementId(advertisementId);
    }

    @Override
    public synchronized Bid placeBid(Bid bid) {
        // Логика обработки ставки
        // 1. Проверить текущую максимальную ставку для объявления
        // 2. Убедиться, что новая ставка выше текущей
        // 3. Обновить информацию о ставке

        // Пример логики:
        List<Bid> existingBids = bidRepository.findByAdvertisementId(bid.getAdvertisement().getId());
        if (!existingBids.isEmpty()) {
            Bid highestBid = existingBids.get(existingBids.size() - 1);
            if (bid.getAmount() <= highestBid.getAmount()) {
                throw new RuntimeException("Bid amount must be higher than the current highest bid.");
            }
        }
        return bidRepository.save(bid);
    }

    // Дополнительные методы
}
