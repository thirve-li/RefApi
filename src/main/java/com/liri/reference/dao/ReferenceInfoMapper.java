package com.liri.reference.dao;

import java.util.List;

import com.liri.reference.model.BankInInfoDto;
import com.liri.reference.model.ReferenceInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReferenceInfoMapper {

	Long insert(ReferenceInfoDto record) throws Exception;
	
	ReferenceInfoDto selectByPrimaryKey(Integer id);

	int selectByTicketNum(String ticketNum);

 
	
	/**
	 * 查询历史RefNo
	 * @param schema
	 * @param searchType
	 * @param firstName
	 * @param midName
	 * @param lastName
	 * @param corporateName
	 * @return
	 */
	List<String> getHistoryRefNo(@Param("userSchema") String schema, @Param("searchType") String searchType,
                                 @Param("firstName") String firstName, @Param("midName") String midName, @Param("lastName") String lastName,
                                 @Param("corporateName") String corporateName);

	/**
	 * 根据refNo获取历史入金
	 * 
	 * @param refNo
	 * @param walletTypeSchema
	 * @return
	 */
	List<BankInInfoDto> getMoneyInHistory(@Param("refNo") String refNo,
										  @Param("walletTypeSchema") String walletTypeSchema, @Param("fiSimpleName") String fiSimpleName);

	/**
	 * 根据选择的银行查询walletTypeSchema
	 * 
	 * @param companyId
	 * @return
	 */
	String getWalletSchemaByCompanyId(@Param("companyId") String companyId);

}