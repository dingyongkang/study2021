package com.qf.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    @Bean(name = "insertQueue")
    public Queue insertQueue(){
        return new Queue("insertQueue");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("cartExchange");
    }

    @Bean
    public Binding bindTopicExchange(@Qualifier("insertQueue") Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("cart.insert");
    }
}
