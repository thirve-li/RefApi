package com.liri.reference.service;

import com.liri.reference.model.DictItemDto;
import com.liri.reference.model.WalletTypeDto;

import java.util.List; 

public interface CacheService {
  public WalletTypeDto getWalletTypeByCode(String walletTypeCode);
  public WalletTypeDto getWalletTypeBySchema(String WalletTypeSchema);
  public List<WalletTypeDto> getWalletTypeList();
  public List<DictItemDto> getDicItemByClassCodeList(String dictClassCode);
  public DictItemDto getDicItemByItemCode(String dictClassCode, String dictItemCode, String walletTypeCode);
  public void reload();
}
