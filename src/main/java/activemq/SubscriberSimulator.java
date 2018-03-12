package activemq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年7月5日       TODO
 * </pre>
 */
public class SubscriberSimulator {

	private static final String TOPIC_NAME = "ActiveMQ_Topic";

	public static void main(String[] args) throws Exception {

		ExecutorService exe = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exe.execute(new Subsciber(TOPIC_NAME));
		}
		exe.shutdown();
	}

}
