package com.liri.reference.dao;

import java.util.List;

import com.liri.reference.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BankDao {

	List<FICompanyDto> selectBankByCountry(@Param("countryCode") String countryCode, @Param("nowDate") String nowDate,
										   @Param("currency") String currency, @Param("list") List<Integer> fiAccountIDList,
										   @Param("walletTypeCode") String walletTypeCode, @Param("senderType") String senderType,
										   @Param("userType") String userType);

	List<FICompanyDto> selectBankByRegion(@Param("countryCode") String countryCode, @Param("regionID") Integer regionID,
                                          @Param("nowDate") String nowDate, @Param("currency") String currency,
                                          @Param("list") List<Integer> fiAccountIDList, @Param("walletTypeCode") String walletTypeCode,
                                          @Param("senderType") String senderType, @Param("userType") String userType);

	List<MstFiAccountDto> selectChildBanks(@Param("fiID") int fiID, @Param("fiAccountID") int fiAccountID,
										   @Param("walletTypeCode") String walletTypeCode);

	List<FICompanyDto> selectBankByGlobal(@Param("countryCode") String countryCode, @Param("regionID") Integer regionID,
                                          @Param("nowDate") String nowDate, @Param("currency") String currency,
                                          @Param("list") List<Integer> fiAccountIDList, @Param("walletTypeCode") String walletTypeCode,
                                          @Param("senderType") String senderType, @Param("userType") String userType);

	List<MstCurrency> selectValidCurrency(@Param("nowDate") String nowDate);

	List<BankInInfoDto> selectRefInAmount(MstImpBankInInfo inInfo);

	Integer selectRefInCount(MstImpBankInInfo inInfo);

	List<FICompanyDto> selectChildBank(@Param("fiAccountID") int fiAccountID);

	String selectWalletTypeSchema(MstImpBankInInfo inInfo);
}
