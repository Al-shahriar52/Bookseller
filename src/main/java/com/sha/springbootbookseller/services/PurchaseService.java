package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.repository.IPurchaseHistoryRepository;

import com.sha.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseService implements IPurchaseService{

    private final IPurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseService(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }
    @Override

    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }
    @Override

    public List<IPurchaseItem> findPurchasedItemsOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
