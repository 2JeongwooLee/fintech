package com.zerobase.fintech.entity;

import com.zerobase.fintech.dto.AddProductInfoForm;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PRODUCT_INFO")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orgCd;
    private String prodCd;
    private String prodNm;
    private Double prodMinIntr;
    private Double prodMaxIntr;

    public static ProductInfo of(AddProductInfoForm form) {
        return ProductInfo.builder()
                .orgCd(form.getOrganizationCode())
                .prodCd(form.getProductCode())
                .prodNm(form.getProductName())
                .prodMinIntr(form.getProductMinimumInterest())
                .prodMaxIntr(form.getProductMaximumInterest())
                .build();
    }
}
