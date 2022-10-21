package com.stussy.stussclone20220929junho.service.admin;

import com.stussy.stussclone20220929junho.domain.Product;
import com.stussy.stussclone20220929junho.dto.admin.ProductAdditionReqDto;
import com.stussy.stussclone20220929junho.dto.admin.ProductListRespDto;
import com.stussy.stussclone20220929junho.dto.admin.ProductModificationReqDto;

import java.util.List;

public interface ProductService {
    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;
    public List<ProductListRespDto> getProductList(int pageNumber, String category, String searchText) throws Exception;
    public boolean updateProduct(ProductModificationReqDto productModificationReqDto) throws Exception;
    public boolean deleteProduct(int productId) throws Exception;

}