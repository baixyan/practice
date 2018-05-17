package com.example.demo0.mapper;

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
public interface SeekMapper
{
    public List<Seek> findSeekInfo();
    public int addSeekInfo(Seek seek);
    public int addSeek(@Param("id") int id,@Param("dirname") String dirname);
    public int delSeekInfo(int id);
    Seek selectResult(@Param("dirname") String dirname, @Param("filename") String filename);
    int updateByPrimaryKeySelective(Seek record);
    int updateByPrimaryKey(Seek record);
}
