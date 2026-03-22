package com.example.service.impl;

import com.example.mapper.DptMapper;
import com.example.pojo.Dept;
import com.example.service.DptService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DptServiceImpl implements DptService {
   @Autowired
   private DptMapper dptMapper;
    @Override
    public List<Dept> findAll() {
        return dptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        dptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
            dept.setCreateTime(LocalDateTime.now());
            dept.setUpdateTime(LocalDateTime.now());
            dptMapper.insert(dept);

    }

    @Override
    public Dept getById(Integer id) {
        return dptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        dptMapper.update(dept);
    }

}
