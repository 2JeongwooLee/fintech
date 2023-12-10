package com.zerobase.fintech.dto;

import com.zerobase.fintech.entity.ProductInfo;
import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoDto {
    private ProductInfo data;
    private String responseCode;
    private String responseMessage;

    public static ProductInfoDto from(ProductInfo productInfo) {
        return ProductInfoDto.builder()
                .data(productInfo)
                .responseCode("00")
                .responseMessage("success")
                .build();
    }
}