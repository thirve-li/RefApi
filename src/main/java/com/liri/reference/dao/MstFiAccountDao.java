package com.liri.reference.dao;

import java.util.List;

import com.liri.reference.model.MstFiAccountDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MstFiAccountDao {

    List<MstFiAccountDto> selectMaxAndMinMoneyByDate(
            @Param("nowDate") String nowDate,
            @Param("currency") String currency,
            @Param("countryCode") String countryCode,
            @Param("walletTypeID") Long walletTypeID,
            @Param("walletTypeCode") String walletTypeCode);

}
