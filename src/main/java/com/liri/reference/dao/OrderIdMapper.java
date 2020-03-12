package com.liri.reference.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderIdMapper {

	String getOrderId();
}
