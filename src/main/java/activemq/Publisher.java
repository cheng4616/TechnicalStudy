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
public class Publisher implements Runnable {
	private TopicConnectionFactory connectionFactory;
	private int send_count;
	private Connection connection;
	private Session session;
	private Destination destination;
	private MessageProducer producer;
	public Publisher(String topicName, int send_count) throws JMSException {
		this.connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD,
				ActiveMQConnection.DEFAULT_BROKER_URL);
		this.connection = connectionFactory.createConnection();
		connection.start();
		this.session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		this.destination = session.createTopic(topicName);
		this.producer = session.createProducer(destination);
		this.send_count = send_count;
	}

	@Override
	public void run() {
		try {
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			sendMessage(session, producer);
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != session) {
					session.close();
				}

				if (null != connection) {
					connection.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}

	private void sendMessage(Session session, MessageProducer producer) throws JMSException {
		for (int i = 0; i < send_count; i++) {
			TextMessage message = session.createTextMessage("ActiveMq Send Topic Message" + i);
			System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
			producer.send(message);
		}
	}

}
