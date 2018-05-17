package com.example.demo0.service.impl;

import com.example.demo0.entity.Seek;
import com.example.demo0.mapper.SeekMapper;
import com.example.demo0.service.SeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by baixuyan on 2018/5/16
 *
 * @author baixuyan
 **/
@Service
@ComponentScan("com.example.demo0.mapper.SeekMapper")
public class SeekserviceImpl implements SeekService {

    @Autowired
    private SeekMapper seekMapper;

    @Override
    public List<Seek> getSeekInfo(){

        return seekMapper.findSeekInfo();
    }
    @Override
    public void insert(Seek seek) {
        seekMapper.addSeekInfo(seek);

    }
    @Override
    public void delByid(int id){
        seekMapper.delSeekInfo(id);
    }
    @Override
    public Seek selectResult(String catalogName, String fileName) {
        return seekMapper.selectResult(catalogName,fileName);
    }

    @Override
    public int updateByPrimaryKey(Seek record) {
        return seekMapper.updateByPrimaryKey(record);
    }
}
