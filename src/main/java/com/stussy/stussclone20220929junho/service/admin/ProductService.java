package com.stussy.stussclone20220929junho.service.admin;

import com.stussy.stussclone20220929junho.domain.Product;
import com.stussy.stussclone20220929junho.dto.admin.ProductAdditionReqDto;
import com.stussy.stussclone20220929junho.dto.admin.ProductListRespDto;

import java.util.List;

public interface ProductService {
    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;
    public List<ProductListRespDto> getProductList(int pageNumber, String category, String searchText) throws Exception;
}
