package ProducerBuild;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public void sendMessage(String hostIP, String exchange, String producer, String message) throws Exception {
        String publish = producer + ":" + message;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(hostIP);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(exchange, "fanout");
            channel.basicPublish(exchange, "", null, publish.getBytes("UTF-8"));
            System.out.println(" Sent '" + message + "'\t\tas: " + producer);
        }

    }

}
