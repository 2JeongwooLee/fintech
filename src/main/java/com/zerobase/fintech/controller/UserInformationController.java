package com.zerobase.fintech.controller;


import com.zerobase.fintech.domain.UserKey;
import com.zerobase.fintech.domain.UserResponseResult;
import com.zerobase.fintech.dto.AddUserInfoForm;
import com.zerobase.fintech.dto.UserInfoDto;
import com.zerobase.fintech.entity.UserInfo;
import com.zerobase.fintech.service.UserInformationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fintech/v1/user")
@RequiredArgsConstructor
public class UserInformationController {

    private final UserInformationService userInformationService;

    @ApiOperation(value = "유저 정보 조회 API", notes = "유저 정보를 조회하는 API")
    @GetMapping("/private-info/{userKey}")
    public UserInfoDto getUserInfomation(@RequestParam String userKey) {
        log.info("유저 정보 조회");
        return userInformationService.getUserInfo(userKey);
    }

    @ApiOperation(value = "유저 정보 수신 API", notes = "유저 정보를 받는 API")
    @PostMapping("/information")
    public ResponseEntity<UserResponseResult> postUserInformation(@RequestBody AddUserInfoForm form) {
        log.info("유저 정보 저장");
        UserInfo userInfo = userInformationService.addUserInfo(form);

        List<UserKey> list = new ArrayList<>();
        list.add(new UserKey(userInfo.getUsrKey()));

        return ResponseEntity.ok().body(new UserResponseResult(list, "00", "success"));
    }
}
