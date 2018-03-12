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
public class PublisherSimulator {

	private static final String TOPIC_NAME = "ActiveMQ_Topic";

	private static final int TOPIC_COUT = 100;

	public static void main(String[] args) throws Exception {

		ExecutorService exe = Executors.newCachedThreadPool();
		exe.execute(new Publisher(TOPIC_NAME, TOPIC_COUT));
		exe.shutdown();

	}

}
