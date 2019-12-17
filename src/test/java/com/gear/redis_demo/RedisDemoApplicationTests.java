package com.gear.redis_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.List;

@SpringBootTest
class RedisDemoApplicationTests {

    @Test
    void contextLoads() {
        //连接本地Redis服务
        Jedis jeids = new Jedis("http://192.168.149.128:6379");
        System.out.println("连接成功");
        //存储数据到列表中
        jeids.lpush("site-list","Runoob");
        jeids.lpush("site-list","Google");
        jeids.lpush("site-list","Aliyun");
        //获取存储的数据并输出
        List<String> list = jeids.lrange("site-list",0,2);
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println("列表项为："+list.get(i));
//        }
        System.out.println(list.get(2));

    }


    static boolean foo(char c){
        System.out.println(c);
        return true;
    }
    @Test
    void a() {
        int i =0;
        for(foo('A');foo('B')&&(i<2);foo('C')){
            i++;
            foo('D');
        }
    }

}
