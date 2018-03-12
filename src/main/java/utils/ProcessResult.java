package utils;


public class ProcessResult {
	/** 返回结果码 */
	private int resultCode;
	/** 返回结果信息 */
	private String resultMsg;

	public ProcessResult(int resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	@Override
	public String toString() {
		return "ProcessResult [resultCode=" + resultCode + ", resultMsg=" + resultMsg + "]";
	}
}
