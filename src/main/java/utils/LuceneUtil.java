package utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.hunspell.Dictionary;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.poi.hwpf.HWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.ranges.Range;

import java.io.*;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年8月7日       Lucene
 * </pre>
 */
public class LuceneUtil {

	private static final Logger logger = LoggerFactory.getLogger(LuceneUtil.class);

	private static String CONTENT = "";

	private static Analyzer analyzer = null;

	private static Dictionary dictionary = null;

	private static IndexWriter indexWriter = null;

	/**
	 * <p>
	 * 创建索引
	 * </p>
	 * 
	 * @author liuzhicheng
	 * @date 2017年8月7日 下午4:05:14
	 * @param path
	 * @throws Exception
	 */
	public static void createIndex(String path) throws Exception {
		File[] fileArgs = new File(path).listFiles();
		if (fileArgs.length == 0) {
			throw new Exception("path is not exists.");
		}
		for (File file : fileArgs) {
			String fileType = file.getName().substring(file.getName().lastIndexOf(".") + 1);
			if ("txt".equalsIgnoreCase(fileType)) {
				CONTENT += txt2String(file);
			} else if ("doc".equalsIgnoreCase(fileType)) {
				CONTENT += doc2String(file);
			} else if ("xls".equalsIgnoreCase(fileType)) {
				CONTENT += xls2String(file);
			}
		}

		try {
			analyzer = new StandardAnalyzer();
		} catch (Exception e) {
			logger.error("Exception", e);
		}

	}

	/**
	 * <p>
	 * 将txt文本转换为字符串
	 * </p>
	 * 
	 * @author liuzhicheng
	 * @date 2017年8月7日 下午4:25:32
	 * @param file
	 * @return
	 */
	private static String xls2String(File file) {
		StringBuilder result = new StringBuilder();
		try {
			FileInputStream input = new FileInputStream(file);
			BufferedReader read = new BufferedReader(new InputStreamReader(input, "UTF-8"));
			String line = null;
			while ((line = read.readLine()) != null) {
				result.append(line);
			}
			read.close();
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		}
		return result.toString();
	}

	/**
	 * <p>
	 * 将doc文本转换为字符串
	 * </p>
	 * 
	 * @author liuzhicheng
	 * @date 2017年8月7日 下午4:28:09
	 * @param file
	 * @return
	 */
	private static String doc2String(File file) {
		StringBuilder result = new StringBuilder();
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
			HWPFDocument doc = new HWPFDocument(input);
			Range range = (Range) doc.getRange();
			result.append(((org.apache.poi.hwpf.usermodel.Range) range).text());
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException", e);
		} catch (IOException e) {
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				logger.error("IOException", e);
			}
		}

		return result.toString();
	}

	private static String txt2String(File file) {
		String result = "";
		return result;
	}
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();

	}

}
