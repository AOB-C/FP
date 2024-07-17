package com.lmy.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("baseMapper")
public interface BaseMapper {
    @MapKey("map")
    List<Map<String, Object>> findGridData(Map<String, Object> map);
    Long getGridTotal(Map<String, Object> map);

}