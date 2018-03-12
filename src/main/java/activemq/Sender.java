package activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年6月30日       TODO
 * </pre>
 */
public class Sender {

	private static final int SEND_COUT = 10;

	public static void main(String[] args) {
		// 连接工厂
		ConnectionFactory connectionFactory;

		Connection connection = null;

		Session session;

		Destination destination;

		MessageProducer producer;

		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("FirstQueue");
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			sendMessage(session, producer);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != connection) {
					connection.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	private static void sendMessage(Session session, MessageProducer producer) throws JMSException {
		for (int i = 0; i < SEND_COUT; i++) {
			TextMessage message = session.createTextMessage("activemq 发送消息" + i);
			System.out.println("发送消息 " + "activemq 发送消息" + i);
			producer.send(message);
		}

	}
}
