package com.gipaovip.rabbitemq.rabbitmqspringboot.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:RabbitConfig
 * Package:com.gipaovip.rabbitemq.rabbitmqspringboot.config
 * description
 * Created by zhangbin on 2019/8/29.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/8/29 10:01
 */
@Configuration
public class RabbitConfig {
    /**
     *  topic 交换机
     * @return
     */
    @Bean
    public TopicExchange   topicExchange(){
        return new TopicExchange("TOPIC_EXCHANGE");
    }

    /**
     * 路由广播的 交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("FANOUT_EXCHANGE");
    }

    /**
     * first 队列
     * @return
     */
    @Bean
    public Queue firstQueue(){
        return new Queue("FIRST_QUEUE");
    }

    /**
     * second 队列
     * @return
     */
    @Bean
    public Queue secondQueue(){
        return new Queue("SECOND_QUEUE");
    }

    /**
     * third 队列
     * @return
     */
    @Bean
    public Queue thirdQueue(){
        return new Queue("THIRD_QUEUE");
    }


    /**
     * 两个绑定
     */
    @Bean
    public Binding bindSecond(@Qualifier(value = "secondQueue") Queue secondQueue, @Qualifier(value = "topicExchange") TopicExchange   topicExchange){
        return BindingBuilder.bind(secondQueue).to(topicExchange).with("#.gupao.#");
    }
    @Bean
    public Binding bindThird(@Qualifier(value = "thirdQueue") Queue thirdQueue, @Qualifier(value = "fanoutExchange") FanoutExchange   fanoutExchange){
        return BindingBuilder.bind(thirdQueue).to(fanoutExchange);
    }
}
