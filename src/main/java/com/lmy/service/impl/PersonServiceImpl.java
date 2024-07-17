package com.lmy.service.impl;

import com.lmy.entity.Person;
import com.lmy.mapper.PersonMapper;
import com.lmy.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;
@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonMapper mapper;
    @Override
    public int addSave(Person person) {
        if (person.getPkid() == null || person.getPkid() == "") {
            person.setPkid(UUID.randomUUID().toString());
        }
        return mapper.insert(person);
    }
    @Override
    public int update(Person person) {
        return mapper.updateByPrimaryKey(person);
    }
    @Override
    public int updateSelect(Map<String, Object> map) {
        return mapper.updateSelect(map);
    }
    @Override
    public int delete(String[] pkids) {
        return mapper.deleteByPrimaryKey(pkids);
    }
}
