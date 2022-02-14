package com.zzz.producer;

import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: SimpleProducer
 * 类描述: TODO
 * 创建时间: 2021/12/19 2:05 AM
 * 创建人: zzz
 **/
public class SimpleProducer {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setConnectionTimeout(60000);
        connectionFactory.setUri("amqp://admin:admin@localhost:5672");
//        connectionFactory.setHost("localhost");
//        connectionFactory.setPort(5672);
//        connectionFactory.setVirtualHost("/");
//        connectionFactory.setUsername("admin");
//        connectionFactory.setPassword("admin");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("test-exchange", BuiltinExchangeType.FANOUT);
        channel.queueDeclare("test",true,false,false,null);
        channel.queueBind("test", "test-exchange","");
        ConfirmCallback deliveryCallback = (tags, mult) -> System.out.println("发送成功，tags=" + tags);
        ConfirmCallback nackCallback = (tags, mult) -> System.out.println("发送失败，tags=" + tags);
        channel.addConfirmListener(deliveryCallback, nackCallback);
//        String queue = channel.queueDeclare().getQueue();
        channel.basicPublish("test-exchange","", MessageProperties.PERSISTENT_TEXT_PLAIN,"test publish".getBytes(StandardCharsets.UTF_8));
        channel.close();
        connection.close();
    }
}
