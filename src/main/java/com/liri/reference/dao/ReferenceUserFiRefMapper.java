package com.liri.reference.dao;

import com.liri.reference.model.ReferenceUserFiRef;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ReferenceUserFiRefMapper {
	public List<ReferenceUserFiRef> selectInfoByMap(Map<String, Object> map);
}
