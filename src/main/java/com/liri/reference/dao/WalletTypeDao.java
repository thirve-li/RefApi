package com.liri.reference.dao;

import com.liri.reference.model.WalletTypeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WalletTypeDao {
    public List<WalletTypeDto> select(WalletTypeDto walletTypeDto);
    
    public WalletTypeDto selectByCode(String walletTypeCode);
    
    @Options(useGeneratedKeys = true)
    public void insert(WalletTypeDto walletTypeDto);
    
    public void update(WalletTypeDto walletTypeDto);
    
    public void delete(Long id);
}
