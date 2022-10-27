package com.stussy.stussclone20220929junho.service;

import com.stussy.stussclone20220929junho.dto.shop.CollectionListRespDto;
import com.stussy.stussclone20220929junho.dto.shop.ProductDetailRespDto;

import java.util.List;

public interface ShopService {
    public List<CollectionListRespDto> getCollections(String category, int page) throws Exception;
    public ProductDetailRespDto getProductDetails(int groupId) throws Exception;
}