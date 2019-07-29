package ProducerBuild;

public class TempClass {
    public static void main(String[] args) {
        String hostIP = "localhost";
        String exchange = "NamedExchange";
        Producer producer = new Producer();
        double randomNumber1 = Math.random()*10;
        double randomNumber2 = Math.random()*randomNumber1;
        try {
            producer.sendMessage(hostIP, exchange, "Producer #1", "Some message");
            producer.sendMessage(hostIP, exchange, "Producer #1", Double.toString(randomNumber1)); //Messsage with random content
            producer.sendMessage(hostIP, exchange, "Producer #1", Double.toString(randomNumber2)); //Messsage with random content
            producer.sendMessage(hostIP, exchange, "Producer #1", Double.toString(randomNumber1*randomNumber2)); //Messsage with random content
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//sudo rabbitmqctl list_bindings
//sudo rabbitmqctl list_exchanges