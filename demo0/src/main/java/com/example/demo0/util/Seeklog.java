package com.example.demo0.util;

import com.example.demo0.entity.Seek;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by baixuyan on 2018/5/16
 *
 * @author baixuyan
 **/

public class Seeklog
{

    public List<Seek> getFile(String path) throws IOException {
        File fileDir = new File(path);
        return readFile(fileDir);
    }



    static int processLine(String pathLine) {
        int chineseWord = 0;
        Pattern chineseWordPattern = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher chineseWordMatcher = chineseWordPattern.matcher(pathLine);
        while (chineseWordMatcher.find()) {
            chineseWord++;
        }
        return chineseWord;
    }


    private static List<Seek> resultList = new ArrayList<>();

    private static List<Seek> readFile(File fileDir) {
        // 文件目录
        if (fileDir.isDirectory()) {
            File[] fileArray = fileDir.listFiles();
            for (File f : fileArray) {
                //是目录
                if (f.isDirectory()) {
                    readFile(f);
                } else { //是文件
                    try {
                        int ch = 0;
                        //数字
                        int num = 0;
                        //字母
                        int letter = 0;
                        // 汉字
                        int word = 0;
                        // 空格
                        int blank = 0;
                        FileInputStream inputStream = new FileInputStream(f);
                        /*统计汉字*/
                        BufferedReader br = new BufferedReader(new FileReader(f));
                        String str = null;
                        while ((str = br.readLine()) != null) {
                            word += processLine(str);
                        }
                        // 统计数字、字母、空格
                        while ((ch = inputStream.read()) != -1) {
                            if ('0' <= ch && ch <= '9') {
                                num++;
                            } else if ('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z') {
                                letter++;
                            } else if (ch == ' ') {
                                blank++;
                            }
                        }
                        if (num!=0||blank!=0||word!=0||letter!=0) {
                            Seek seek = new Seek();
                            seek.setFilename(f.getName());
                            seek.setDirname(fileDir.toString());
                            seek.setNcount(num);
                            seek.setScount(blank);
                            seek.setLcount(letter);
                            seek.setCcount(word);
                            resultList.add(seek);
                        }
                        System.out.println("目录名\t文件名\t类别\t数量");
                        if (num != 0) {
                            System.out.println(fileDir.getName()+"\t"+f.getName()+"\t数字\t"+num);
                        }
                        if (blank != 0) {
                            System.out.println(fileDir.getName()+"\t"+f.getName()+"  空格   "+blank);
                        }
                        if (letter != 0) {
                            System.out.println(fileDir.getName()+"  "+f.getName()+"  字母   "+letter);
                        }
                        if (word != 0) {
                            System.out.println(fileDir.getName()+"  "+f.getName()+"  汉字   "+word);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return resultList;
    }

}