package com.example.demo0.service;

import com.example.demo0.entity.Seek;
import java.util.List;

/**
 * created by baixuyan on 2018/5/16
 *
 * @author baixuyan
 **/

public interface SeekService
{
    List<Seek> getSeekInfo();
    void insert(Seek seek);
    void delByid(int id);
    Seek selectResult(String catalogName,String fileName);
    int updateByPrimaryKey(Seek seek);

}
