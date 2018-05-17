package com.example.demo0.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * created by baixuyan on 2018/5/16
 *
 * @author baixuyan
 **/
public class DirInfo implements Serializable
{
    private Integer d_id;
    private String filename;
    private String dirname;
    private String log;
    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getDirname() {
        return dirname;
    }

    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof DirInfo)) {return false;}
        DirInfo dirInfo = (DirInfo) o;
        return Objects.equals(getD_id(), dirInfo.getD_id()) &&
                Objects.equals(getLog(), dirInfo.getLog()) &&
                Objects.equals(getDirname(), dirInfo.getDirname()) &&
                Objects.equals(getFilename(), dirInfo.getFilename());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getD_id(), getLog(), getDirname(), getFilename());
    }

    @Override
    public String toString() {
        return "DirInfo{" +
                "d_id=" + d_id +
                ", log='" + log + '\'' +
                ", dirname='" + dirname + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}