package com.lmy.service;

import com.lmy.entity.Policy;

import java.util.List;
import java.util.Map;

public interface PolicyService {
    int addSave(Policy policy);
    int update(Policy policy);
    int delete(String[] pkids);
    List<Map<String, Object>> getPolicyList();
}
