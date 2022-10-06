package com.stussy.stussclone20220929junho.service;

import com.stussy.stussclone20220929junho.dto.account.RegisterReqDto;

public interface AccountService {
    public boolean checkDuplicateEmail(String email);

    public boolean register(RegisterReqDto registerReqDto) throws Exception;
}