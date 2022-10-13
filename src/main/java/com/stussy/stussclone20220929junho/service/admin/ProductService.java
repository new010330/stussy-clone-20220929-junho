package com.stussy.stussclone20220929junho.service.admin;

import com.stussy.stussclone20220929junho.domain.Product;
import com.stussy.stussclone20220929junho.dto.admin.ProductAdditionReqDto;

import java.util.List;

public interface ProductService {
    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;
    public List<Product> getProductList(int pageNumber, String category, String searchText) throws Exception;
}