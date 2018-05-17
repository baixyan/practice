package com.example.demo0.mapper;

import com.example.demo0.entity.DirInfo;
import com.example.demo0.entity.Seek;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by baixuyan on 2018/5/16
 *
 * @author baixuyan
 **/
@Mapper
public interface DirInfoMapper
{
    public List<DirInfo> findDirInfo();
    public int addDirInfo(DirInfo dirInfo);
    public int addDir(int id,String dirname);
    public int delDirInfo(int id);
}
