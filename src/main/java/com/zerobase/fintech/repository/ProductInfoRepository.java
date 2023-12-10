package com.zerobase.fintech.repository;

import com.zerobase.fintech.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

    List<ProductInfo> searchByOrgCd(String organizationCode);
}
