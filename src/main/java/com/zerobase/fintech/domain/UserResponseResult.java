package com.zerobase.fintech.domain;

import com.zerobase.fintech.dto.UserInfoDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class UserResponseResult {

    private final List<UserKey> data;
    private final String responseCode;
    private final String responseMessage;

}

