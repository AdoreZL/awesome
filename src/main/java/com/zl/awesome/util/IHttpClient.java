package com.zl.awesome.util;


import java.util.Map;

public interface IHttpClient {
	public String doGet(String url, Map<String, String> header, String responseEncoding, int connTimeout, int requestTimeout) throws Exception;
	public String doPost(String url, Map<String, String> header, String body, String requestEncoding, String responseEncoding, int connTimeout, int requestTimeout) throws Exception;
	public String doDelete(String url, Map<String, String> header, String responseEncoding, int connTimeout, int requestTimeout) throws Exception;
	public String doPut(String url, Map<String, String> header, String body, String requestEncoding, String responseEncoding, int connTimeout, int requestTimeout) throws Exception;

}