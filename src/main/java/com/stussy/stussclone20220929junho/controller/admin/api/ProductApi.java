package com.stussy.stussclone20220929junho.controller.admin.api;

import com.stussy.stussclone20220929junho.aop.annotation.LogAspect;
import com.stussy.stussclone20220929junho.aop.annotation.ValidAspect;
import com.stussy.stussclone20220929junho.domain.Product;
import com.stussy.stussclone20220929junho.dto.CMRespDto;
import com.stussy.stussclone20220929junho.dto.admin.ProductAdditionReqDto;
import com.stussy.stussclone20220929junho.dto.admin.ProductModificationReqDto;
import com.stussy.stussclone20220929junho.dto.validation.ValidationSequence;
import com.stussy.stussclone20220929junho.exception.CustomInternalServerErrorException;
import com.stussy.stussclone20220929junho.service.admin.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @ValidAspect
    @LogAspect
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@Validated(ValidationSequence.class) ProductAdditionReqDto productAdditionReqDto, BindingResult bindingResult) throws Exception {

//        String productName = productAdditionReqDto.getName();
//        for(int i = 0; i < 20; i++) {
//            if(i % 4 == 0){
//                productAdditionReqDto.setName(productName + "-" + (i + 1));
//            }
//            productService.addProduct(productAdditionReqDto);
//        }
//        return ResponseEntity
//                .created(null)
//                .body(new CMRespDto<>(1, "Successfully", null));

        return ResponseEntity
                .created(null)
                .body(new CMRespDto<>(1, "Successfully", productService.addProduct(productAdditionReqDto)));
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProductList(@RequestParam int page,
                                            @RequestParam @Nullable String category,
                                            @RequestParam @Nullable String searchValue) throws Exception {

        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", productService.getProductList(page, category, searchValue)));
    }

    @LogAspect
    @ValidAspect
    @PostMapping("/product/modification")
    public ResponseEntity<?> updateProduct(@Valid ProductModificationReqDto productModificationReqDto, BindingResult bindingResult) throws Exception {

        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", productService.updateProduct(productModificationReqDto)));
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) throws Exception {
        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", productService.deleteProduct(productId)));
    }
}