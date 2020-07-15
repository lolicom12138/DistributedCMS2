package xyz.apichiyu.distributedcms.adminservice.dto.result;

import xyz.apichiyu.distributedcms.adminservice.util.TimeUtil;

/**
 * @author lolicom
 */
public class Result {
	private int status;
	private String message;
	private String error;
	private Object data;
	private String timestamp;
	private String path;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static Result ok(String msg, Object data){
		Result res = new Result();
		res.message = msg;
		res.data = data;
		res.status = 200;
		res.timestamp = TimeUtil.nowTime("yyyy-MM-dd HH:mm:ss").replace(" ","T");
		return res;
	}

	public static Result fail(String errMsg){
		Result res = new Result();
		res.error = errMsg;
		res.status = 500;
		res.timestamp = TimeUtil.nowTime("yyyy-MM-dd HH:mm:ss").replace(" ","T");
		return res;
	}
}
