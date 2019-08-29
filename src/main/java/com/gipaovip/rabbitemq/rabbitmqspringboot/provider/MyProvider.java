package com.gipaovip.rabbitemq.rabbitmqspringboot.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName:MyProvider
 * Package:com.gipaovip.rabbitemq.rabbitmqspringboot.provider
 * description
 * Created by zhangbin on 2019/8/29.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/8/29 10:17
 */
@Component
public class MyProvider {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public  void send() {
        // 发送4条消息
        amqpTemplate.convertAndSend("","FIRST_QUEUE","a-----------direct msg");
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","haha.gupao.nihao","a-----------topic msg : haha.gupao.nihao");
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","GG.gupao.dd","a-----------topic msg : GG.gupao.dd");
        amqpTemplate.convertAndSend("FANOUT_EXCHANGE","","a----------- fanout msg");

    }
}
