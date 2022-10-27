package com.stussy.stussclone20220929junho.repository;

import com.stussy.stussclone20220929junho.domain.CollectionProduct;
import com.stussy.stussclone20220929junho.domain.ProductDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

import java.util.List;
import java.util.Map;
@Mapper
public interface ShopRepository {
    public List<CollectionProduct> getCollectionList(Map<String, Object> map) throws Exception;
    public List<ProductDetail> getProduct(int groupId) throws Exception;
}