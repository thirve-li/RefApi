package com.liri.reference.dao;

import java.util.List;

import com.liri.reference.model.MstRisk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface MstRiskDao {

    List<MstRisk> checkRiskCountry(@Param("countryCode") String countryCode,
                                   @Param("nowDate") String nowDate, @Param("walletTypeID") Long walletTypeID);

}