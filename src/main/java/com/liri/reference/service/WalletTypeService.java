package com.liri.reference.service;

import com.liri.reference.model.WalletTypeDto;

import java.util.List;

public interface WalletTypeService {
    public List<WalletTypeDto> select(WalletTypeDto walletTypeDto);
}
