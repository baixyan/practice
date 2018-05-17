package consumer;

import redis.clients.jedis.Jedis;
import sun.awt.SunHints;
import task.Task;
import util.RedisUtil;

import static java.lang.Thread.sleep;
import java.util.List;
import java.util.Random;

/**
 * created by baixuyan on 2018/5/17
 *
 * @author baixuyan
 **/
public class Consumer implements Runnable {
    Jedis jedis = new Jedis("120.55.195.177",6379);
    @Override
    public void run() {
        while(true){
            //获取一个任务
            List<byte[]> taskList = jedis.brpop(0, "taskList".getBytes());
            byte[] bs = taskList.get(1);
            Task task = (Task) RedisUtil.convertToObject(bs);
            String taskName = task.getTname();
            long taskTime = task.getTtime();

            try{
                //判断该任务五分钟内是否执行过
                if (!jedis.exists(taskName)) {
                    jedis.lpush(taskName, taskName);
                    jedis.expire(taskName, 300);
                    System.out.println("线程 " + taskName + " 由 " + Thread.currentThread().getName() + " begin");
                    System.out.println(taskName+" 时间消耗 " + taskTime+"ms");
                    sleep(taskTime);

                    System.out.println("线程 " + taskName + " end");
                } else {
                    long restTime = jedis.ttl(taskName);
                    long time = (300 - restTime) * 1000;
                    System.out.println("此任务" + taskName + "  " + time + "ms前刚执行，不需重复执行");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jedis.close();
            // 处理任务:模拟睡觉
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
/*
            //模拟成功和失败的偶然现象
            if(random.nextInt(13) % 7 == 0){// 模拟失败的情况,概率为2/13
                //将本次处理失败的任务从暂存队列"tmp-queue"中，弹回任务队列"task-queue"
                jedis.rpoplpush("tmp-queue", "task-queue");
                System.out.println(taskid + "处理失败，被弹回任务队列");

            } else {// 模拟成功的情况

                // 将本次任务从暂存队列"tmp-queue"中清除
                jedis.rpop("tmp-queue");
                System.out.println(taskid+"处理成功，被清除");

            }*/
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动一个线程者线程，模拟任务的处理
        Thread consume1 = new Thread(new Consumer(),"consumer1");
        consume1.start();
        Thread consume2 = new Thread(new Consumer(),"consumer2");
        consume2.start();
        //Thread.sleep(99999999);
    }
}
