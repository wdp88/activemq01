package activemq.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * Created with IntelliJ IDEA.<br>
 * Description: 订阅者1消息监听器<br>
 * User: jahen<br>
 * Date: 2017-04-02<br>
 * Time: 14:46:52<br>
 */
public class Listener1 implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
            System.out.println("订阅者一 收到消息：" + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

	}

}
