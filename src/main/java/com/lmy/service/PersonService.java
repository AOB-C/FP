package com.lmy.service;

import com.lmy.entity.Person;

import java.util.Map;

public interface PersonService {
    int addSave(Person person);
    int update(Person person);
    int updateSelect(Map<String, Object> map);
    int delete(String[] pkids);
}
