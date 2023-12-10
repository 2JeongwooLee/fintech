package com.zerobase.fintech.service;

import com.zerobase.fintech.dto.AddProductInfoForm;
import com.zerobase.fintech.entity.ProductInfo;
import com.zerobase.fintech.repository.ProductInfoRepository;
import com.zerobase.fintech.repository.ProductListRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductInformationService {

    private final RedisService redisService;

    private final ProductInfoRepository productInfoRepository;

    private final ProductListRepository productListRepository;

    @Transactional
    public ProductInfo addProduct(AddProductInfoForm form) {
        ProductInfo productInfo = productInfoRepository.save(ProductInfo.of(form));
        redisService.put(Long.valueOf(productInfo.getOrgCd()), productInfo);
        return productInfo;
    }

    public List<ProductInfo> getProductInfo(String organizationCode) {

        return productInfoRepository.searchByOrgCd(organizationCode);
    }
}
