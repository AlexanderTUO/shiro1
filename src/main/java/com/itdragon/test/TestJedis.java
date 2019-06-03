package com.itdragon.test;

import com.itdragon.StartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: tyk
 * @Date: 2019/5/17 11:00
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=StartApplication.class)
public class TestJedis {

    //    定义地址HOST和端口PORT
    private final static String HOST = "127.0.0.1";
    private final static int POST = 6379;

    @Test
    public void jedisSingle() {
        Jedis jedis = new Jedis(HOST, POST);
        jedis.set("account", "tyk");
    }


    @Test
    public void testJedisPool() {
        JedisPool pool = new JedisPool(HOST, POST);
        Jedis jedis = pool.getResource();

        System.out.println("通过连接池获取key为account的值为：" + jedis.get("account"));

        jedis.close();
        pool.close();
    }
}
