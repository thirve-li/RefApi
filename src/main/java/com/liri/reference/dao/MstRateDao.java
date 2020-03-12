package com.liri.reference.dao;

import com.liri.reference.model.MstRate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MstRateDao {

    MstRate selectLatestRate(@Param("currencyPairFrom") String inCurrencyCode, @Param("targetCurrencyTo") String targetCurrencyCode);

}