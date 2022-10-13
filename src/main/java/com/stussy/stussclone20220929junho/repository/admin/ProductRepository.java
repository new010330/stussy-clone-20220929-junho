package com.stussy.stussclone20220929junho.repository.admin;

import com.stussy.stussclone20220929junho.domain.Product;
import com.stussy.stussclone20220929junho.domain.ProductImgFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {
    public int saveProduct(Product product) throws Exception;
    public int saveImgFiles(List<ProductImgFile> product_img_files) throws Exception;
    public List<Product> getProductList(Map<String, Object> map) throws Exception;
}