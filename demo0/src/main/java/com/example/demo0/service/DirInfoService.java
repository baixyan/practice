package com.example.demo0.service;

import com.example.demo0.entity.DirInfo;
import com.example.demo0.entity.Seek;

import java.util.List;

/**
 * created by baixuyan on 2018/5/16
 *
 * @author baixuyan
 **/
public interface DirInfoService
{
    public List<DirInfo> getDirInfo();
    public void insert(DirInfo dirInfo);
}
