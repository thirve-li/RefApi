package com.liri.reference.dao;


import com.liri.reference.model.GcApplyInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GcApplyInfoMapper {

	Integer insert(GcApplyInfoDto gcApplyInfo);
}
