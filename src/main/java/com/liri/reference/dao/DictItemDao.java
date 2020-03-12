package com.liri.reference.dao;

import com.liri.reference.model.DictItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DictItemDao {
    List<DictItemDto> select(DictItemDto dictItemDto);
    DictItemDto selectValueByCode(@Param("dictItemCode")String dictItemCode,
                                  @Param("walletTypeCode")String walletTypeCode);
    
}
