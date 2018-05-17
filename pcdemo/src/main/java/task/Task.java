package task;

import java.io.Serializable;

/**
 * created by baixuyan on 2018/5/17
 *
 * @author baixuyan
 **/
public class Task implements Serializable
{
    String tname;
    long ttime;

    public Task(String tname, long ttime) {
        this.tname = tname;
        this.ttime = ttime;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public long getTtime() {
        return ttime;
    }

    public void setTtime(long ttime) {
        this.ttime = ttime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "tname='" + tname + '\'' +
                ", ttime=" + ttime +
                '}';
    }
/* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getTtime() == task.getTtime() &&
                Objects.equals(getTname(), task.getTname());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTname(), getTtime());
    }*/
}
