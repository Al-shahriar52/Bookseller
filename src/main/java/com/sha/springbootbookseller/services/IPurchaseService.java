package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItemsOfUser(Long userId);
}
