package com.zerobase.fintech.controller;


import com.zerobase.fintech.domain.ProductResponseResult;
import com.zerobase.fintech.dto.AddProductInfoForm;
import com.zerobase.fintech.dto.ProductInfoDto;
import com.zerobase.fintech.entity.ProductInfo;
import com.zerobase.fintech.service.ProductInformationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/fintech/v1/product")
@RequiredArgsConstructor
public class ProductInformationController {

    private final ProductInformationService productInformationService;

    @ApiOperation(value = "상품 정보 조회 API", notes = "상품 정보를 조회하는 API")
    @GetMapping("/{organizationCode}")
    public ResponseEntity<?> getProductInfomation(@RequestParam @ApiParam(value = "기관코드") String organizationCode) {
        log.info("상품 정보 조회");
        return ResponseEntity.ok(productInformationService.getProductInfo(organizationCode).stream()
                .map(ProductInfoDto::from).collect(Collectors.toList()));
    }

    @ApiOperation(value = "상품 정보 수신 API", notes = "금융사로부터 상품 정보를 받는 API")
    @PostMapping("/information")
    public ProductResponseResult postProductInformation(@RequestBody AddProductInfoForm form) {
        log.info("상품 정보 입력");
        ProductInfo productInfo = productInformationService.addProduct(form);

        return new ProductResponseResult("00", "success");

    }

}
