package com.go.bmb.app.book.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface bookMapper {
	List<Map<String,Object>> getList();
}
