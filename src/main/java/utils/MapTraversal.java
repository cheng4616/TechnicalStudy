package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年8月3日        map 遍历方法
 * </pre>
 */
public class MapTraversal {

	private static Logger logger = LoggerFactory.getLogger(MapTraversal.class);

	public static void main(String[] args) {

		Map<String, String> map = System.getenv();
		// 第一种
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			logger.debug("System.getenv Key:" + entry.getKey() + " value:" + entry.getValue());
		}
		// 第二种
		for (Map.Entry<String, String> entry : map.entrySet()) {
			logger.debug("System.getenv Key:" + entry.getKey() + " value:" + entry.getValue());
		}
		// 第三种
		Iterator<String> iteratorKey = map.keySet().iterator();
		while (iteratorKey.hasNext()) {
			String key = iteratorKey.next();
			logger.debug("System.getenv Key:" + key + " value:" + map.get(key));
		}
		// 第四种 遍历values
		for (String value : map.values()) {
			logger.debug("System.getenv value:" + value);
		}

	}
}
