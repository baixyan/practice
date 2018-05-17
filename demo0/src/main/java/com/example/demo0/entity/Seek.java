package com.example.demo0.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * created by baixuyan on 2018/5/16
 *
 * @author baixuyan
 **/
public class Seek implements Serializable
{
    private Integer id;
    private String dirname;
    private String filename;
    private Integer ncount;
    private Integer lcount;
    private Integer ccount;
    private Integer scount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seek)) return false;
        Seek seek = (Seek) o;
        return Objects.equals(getId(), seek.getId()) &&
                Objects.equals(getDirname(), seek.getDirname()) &&
                Objects.equals(getFilename(), seek.getFilename()) &&
                Objects.equals(getNcount(), seek.getNcount()) &&
                Objects.equals(getLcount(), seek.getLcount()) &&
                Objects.equals(getCcount(), seek.getCcount()) &&
                Objects.equals(getScount(), seek.getScount());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDirname(), getFilename(), getNcount(), getLcount(), getCcount(), getScount());
    }

    @Override
    public String toString() {
        return "Seek{" +
                "id=" + id +
                ", dirname='" + dirname + '\'' +
                ", filename='" + filename + '\'' +
                ", ncount=" + ncount +
                ", lcount=" + lcount +

                ", ccount=" + ccount +
                ", scount=" + scount +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setNcount(Integer ncount) {
        this.ncount = ncount;
    }

    public void setLcount(Integer lcount) {
        this.lcount = lcount;
    }

    public void setCcount(Integer ccount) {
        this.ccount = ccount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }

    public Integer getId() {

        return id;
    }

    public String getDirname() {
        return dirname;
    }

    public String getFilename() {
        return filename;
    }

    public Integer getNcount() {
        return ncount;
    }

    public Integer getLcount() {
        return lcount;
    }

    public Integer getCcount() {
        return ccount;
    }

    public Integer getScount() {
        return scount;
    }
}
