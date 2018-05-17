package com.example.demo0.service.impl;

import com.example.demo0.entity.DirInfo;
import com.example.demo0.entity.Seek;
import com.example.demo0.mapper.DirInfoMapper;
import com.example.demo0.mapper.SeekMapper;
import com.example.demo0.service.DirInfoService;
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
public class DirInfoserviceImpl implements DirInfoService
{

    @Autowired
    private DirInfoMapper dirInfoMapper;

    @Override
    public List<DirInfo> getDirInfo(){

        return dirInfoMapper.findDirInfo();
    }
    @Override
    public void insert(DirInfo dirInfo) {
        dirInfoMapper.addDirInfo(dirInfo);

    }
}