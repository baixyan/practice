package provider;

import java.util.List;
import java.util.Scanner;
import redis.clients.jedis.Jedis;
import task.Task;
import util.RedisUtil;

/**
 * created by baixuyan on 2018/5/17
 *
 * @author baixuyan
 **/
public class Provider implements Runnable{

    Jedis jedis = new Jedis("localhost", 6379);

    static boolean existTask(List<byte[]> list,String taskName) {
        //判断此次的任务是否已经有了
        for (byte[] bs:list){
            Task task=(Task) RedisUtil.convertToObject(bs);
            String tname=task.getTname();
            //同一个task（任务名来标识)
            if (tname.equals(taskName)){
                return true;
            }
        }
        return false;
    }
    @Override
    public void run() {
        //使用一个flag，防止缓存数量超过100
        boolean flag=true;
        while (flag) {
            //用来查询当前缓存数量
            List<byte[]> list = jedis.lrange("taskList".getBytes(), 0, -1);
            System.out.println("请输入任务：");
            //缓存小于上限
            if (list.size() < 100) {
                Scanner sc = new Scanner(System.in);
                String tname = sc.next();
                long ttime = sc.nextInt();
                Task task = new Task(tname, ttime);
                //同一个task（任务名来标识）不能同时存在队列中
                while (existTask(list,tname)) {
                    System.out.println("此任务已存在，请重新输入！");
                    tname = sc.next();
                    ttime = sc.nextInt();
                    task = new Task(tname, ttime);
                }
                jedis.lpush("taskList".getBytes(), RedisUtil.convertToByte(task));
                jedis.close();
            } else {
                //缓存大于上限
                System.out.println("缓存已达上限：" + list.size());
                flag=false;
                jedis.close();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //启动一个线程者线程，模拟任务的处理
        Thread provider = new Thread(new Provider(),"provider");
        provider.start();
    }

/*    Jedis jedis = new Jedis("120.55.195.177",6379);

    public void run() {
        Random random = new Random();
        while(true){
            try{
                Thread.sleep(random.nextInt(600) + 600);
                // 模拟生成一个任务
                UUID taskid = UUID.randomUUID();
                //将任务插入任务队列：task-queue
                jedis.lpush("task-queue", taskid.toString());
                System.out.println("插入了一个新的任务： " + taskid);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }*/
}
