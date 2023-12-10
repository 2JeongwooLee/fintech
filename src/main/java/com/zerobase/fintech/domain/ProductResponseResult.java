package com.zerobase.fintech.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProductResponseResult {
    private final String responseCode;
    private final String responseMessage;
}
