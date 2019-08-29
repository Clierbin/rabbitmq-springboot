package com.gipaovip.rabbitemq.rabbitmqspringboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName:FirstConsumer
 * Package:com.gipaovip.rabbitemq.rabbitmqspringboot.consumer
 * description
 * Created by zhangbin on 2019/8/29.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/8/29 10:13
 */
@Component
@RabbitListener(queues = "SECOND_QUEUE")
public class FirstConsumer {
    @RabbitHandler
    public void process(String msg){
        System.out.println("Second queue receive : " + msg);
    }
}
