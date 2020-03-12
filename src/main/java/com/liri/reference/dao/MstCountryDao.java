package com.liri.reference.dao;

import java.util.List;

import com.liri.reference.model.MstCountry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MstCountryDao {
    
    List<MstCountry> selectAllCountry(@Param("walletTypeCode") String walletTypeCode);
    
    List<MstCountry> selectByCountryName(@Param("countryName") String countryName);
   
    List<MstCountry> availableCountryList();
}