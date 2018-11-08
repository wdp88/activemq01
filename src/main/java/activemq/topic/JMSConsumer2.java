package activemq.topic;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Created with IntelliJ IDEA.<br>
 * Description: 消息消费者-发布订阅模式 消息订阅者<br>
 *     实现方式 设置监听<br>
 *     消息订阅者2<br>
 * User: jahen<br>
 * Date: 2017-04-02<br>
 * Time: 13:44<br>
 */
public class JMSConsumer2 {
	 private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认连接
	    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认密码
	    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认连接地址 为 failover://tcp://localhost:61616
	    //private static final String BROKER_URL = "failover://tcp://192.168.235.100:61616"; // 指定连接地址 (my VM)

	    public static void main(String args[]) {
	        ConnectionFactory connectionFactory; // 连接工程，生产Connection
	        Connection connection = null; // 连接
	        Session session; // 会话 接受或者发送消息的线程
	        Destination destination; // 消息的目的地
	        MessageConsumer messageConsumer; // 消息消费者

	        // 实例化连接工厂
	        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
	        try {
	            connection = connectionFactory.createConnection();
	            connection.start();
	            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); // 消费消息不需要事务，自动确认
//	            destination = session.createQueue("FirstQueue"); // 创建消息队列
	            destination = session.createTopic("FirstTopic"); // 创建消息订阅者
	            messageConsumer = session.createConsumer(destination); // 创建消息消费者

	            messageConsumer.setMessageListener(new Listener2());// 注册消息监听
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
	    }

}
