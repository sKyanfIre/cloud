package com.zzz.consumer;

import com.rabbitmq.client.*;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: SimpleConsumer
 * 类描述: TODO
 * 创建时间: 2021/12/19 2:29 AM
 * 创建人: zzz
 **/
public class SimpleConsumer {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUri("amqp://admin:admin@localhost:5672");
        final Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("test-exchange", BuiltinExchangeType.FANOUT);
//        channel.queueDeclare("test",true,false,false,null);
        channel.queueBind("test", "test-exchange","");
        DeliverCallback deliverCallback = (tags,content) -> System.out.println("tags:" + tags + "messge: " + new String(content.getBody()));
        CancelCallback cancelCallback = (tags) -> System.out.println("cancel tags :" + tags);
        channel.basicConsume("test",true,deliverCallback, cancelCallback);

    }
}
