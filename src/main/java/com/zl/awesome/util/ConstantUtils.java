package com.zl.awesome.util;

import java.util.HashMap;
import java.util.Map;

public class ConstantUtils {

   /***************PFSCroller使用************************/

	public static final Map<String, String> mineTypeMap = new HashMap<String, String>();

	static {
		mineTypeMap.put("gif", "image/gif");
		mineTypeMap.put("jpeg", "image/jpeg");
		mineTypeMap.put("jpg", "image/jpeg");
		mineTypeMap.put("png", "image/png");
		mineTypeMap.put("ico", "image/x-icon");
		mineTypeMap.put("jng", "image/x-jng");
		mineTypeMap.put("bmp", "image/x-ms-bmp");
	}

	/**
	 * 添加任务key
	 */
	public static final String AddDumpTaskRequest = "AddDumpTaskRequest";

	/**
	 * 删除任务Key
	 */
	public static final String DelDumpTaskRequest = "DelDumpTaskRequest";

	/**
	 * 查询任务进度key
	 */
	public static final String QueryTasksStatusRequest = "QueryTasksStatusRequest";
	/**
	 * 用户云空间默认大小
	 */
	public static final String DEFAULT_CLOUD_LIMIT ="10GB";

	/**
	 * base64图片标识
	 */
	public static final String BAE64_MARK ="base64,";



}
