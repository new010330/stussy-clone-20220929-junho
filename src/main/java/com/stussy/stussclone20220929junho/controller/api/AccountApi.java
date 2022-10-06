package com.stussy.stussclone20220929junho.controller.api;

import com.stussy.stussclone20220929junho.aop.annotation.LogAspect;
import com.stussy.stussclone20220929junho.aop.annotation.ValidAspect;
import com.stussy.stussclone20220929junho.dto.CMRespDto;
import com.stussy.stussclone20220929junho.dto.account.RegisterReqDto;
import com.stussy.stussclone20220929junho.dto.validation.ValidationSequence;
import com.stussy.stussclone20220929junho.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @LogAspect
    @ValidAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception {

        accountService.checkDuplicateEmail(registerReqDto.getEmail());
        accountService.register(registerReqDto);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "Successfully registered", registerReqDto));
    }

}