package com.zerobase.fintech.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    ALREADY_CACHING(HttpStatus.BAD_REQUEST, "이미 캐싱 됨");

    private final HttpStatus httpStatus;
    private final String detail;
}
