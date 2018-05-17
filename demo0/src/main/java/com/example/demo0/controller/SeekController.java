package com.example.demo0.controller;

import com.example.demo0.entity.DirInfo;
import com.example.demo0.entity.Seek;
import com.example.demo0.service.DirInfoService;
import com.example.demo0.service.SeekService;
import com.example.demo0.util.Seeklog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * created by baixuyan on 2018/5/16
 *
 * @author baixuyan
 **/
@RestController
@RequestMapping("/seek")
public class SeekController
{
    @Autowired
    private SeekService seekService;
    @Autowired
    private DirInfoService dirInfoService;
    @ResponseBody
    @RequestMapping("/hello")
    String sayHello(){
        return "hello world";
    }

    @RequestMapping("/addSeekInfo")
    public String addSeekInfo(){
        /*Seek seek = new Seek();
        seek.setId(1) ;
        seek.setDirname("ll");
        seek.setFilename("mm");
        seek.setNcount(2);
        seek.setCcount(2);
        seek.setLcount(2);
        seek.setScount(2);
        seekService.insert(seek);

*/
        Seeklog seeklog = new Seeklog();

        try
        {
            List<Seek> result = seeklog.getFile("/Users/baixuyan/test/bai");
            for (Seek seek:result)
            {
                System.out.println(seek.toString());
            }
            if (result.size() > 0){
                for (Seek seek1:result){
                    seekService.insert(seek1);
                    DirInfo dirInfo = new DirInfo();
                    dirInfo.setDirname(seek1.getDirname());
                    dirInfo.setFilename(seek1.getFilename());
                    dirInfo.setD_id(seek1.getId());
                    dirInfoService.insert(dirInfo);
                }
            }else {
                System.out.println("It is null!");
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return "success: " ;
        //+ seek1.toString();
    }
    @RequestMapping("/getSeekInfo")
    public List<Seek> getSeekInfo(){
        List<Seek> seek = seekService.getSeekInfo();
        System.out.println(seek.toString());
        return seek;
    }
    /*@RequestMapping("/delSeekInfo")
    public String delSeekInfo(int id){
        seekService.delByid(id);
        return "success: " ;
    }*/
}
