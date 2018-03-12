package activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年7月3日       TODO
 * </pre>
 */
public class Subsciber implements Runnable {
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Destination destination;
	private MessageConsumer consumer;
	public Subsciber(String topicName) throws JMSException {
		this.connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD,
				ActiveMQConnection.DEFAULT_BROKER_URL);
		this.connection = connectionFactory.createConnection();
		connection.start();
		this.session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		this.destination = session.createTopic(topicName);
		this.consumer = session.createConsumer(destination);
	}

	@Override
	public void run() {
		try {
			// Wait for a message
			Message message = consumer.receive();
			while (null != message) {
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					String text = textMessage.getText();
					System.out.println(Thread.currentThread().getName() + " Received: " + text);
				} else {
					System.out.println(Thread.currentThread().getName() + " Received: " + message);
				}
				message = consumer.receive(1000);
			}
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
}
