package com.zzz.consumer;

import com.rabbitmq.client.*;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: SimpleConsumer2
 * 类描述: TODO
 * 创建时间: 2021/12/19 12:29 PM
 * 创建人: zzz
 **/
public class SimpleConsumer2 {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUri("amqp://admin:admin@localhost:5672");
        final Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("test-exchange", BuiltinExchangeType.FANOUT);
        channel.queueDeclare("test2",true,false,false,null);
        channel.queueBind("test2", "test-exchange","");
        DeliverCallback deliverCallback = (tags, content) -> System.out.println("queue:test2," + "tags:" + tags + "messge: " + new String(content.getBody()));
        CancelCallback cancelCallback = (tags) -> System.out.println("cancel tags :" + tags);
        channel.basicConsume("test",true,deliverCallback, cancelCallback);
    }
}
