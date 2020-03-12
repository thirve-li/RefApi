package com.liri.reference.service.impl;

import com.liri.reference.dao.WalletTypeDao;
import com.liri.reference.model.WalletTypeDto;
import com.liri.reference.service.WalletTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletTypeServiceImpl implements WalletTypeService {
    
    @Autowired(required=true)
    WalletTypeDao dao;
    
    public List<WalletTypeDto> select(WalletTypeDto walletTypeDto) {
        return dao.select(walletTypeDto);
    }
}
