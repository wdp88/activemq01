package activemq.p2p.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * Created with IntelliJ IDEA.<br>
 * Description: 消息监听者<br>
 * User: jahen<br>
 * Date: 2017-04-02<br>
 * Time: 14:30<br>
 */
public class ListenerPTP implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
            System.out.println("收到消息：" + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

	}

}
