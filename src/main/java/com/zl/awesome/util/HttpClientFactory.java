package com.zl.awesome.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Slf4j
public class HttpClientFactory implements IHttpClient {
	private static HttpClientFactory instance = new HttpClientFactory();

	private final int RESPONSE_BUFFER = 1024;

	private PoolingHttpClientConnectionManager httpClientManager;
	private ConnectionKeepAliveStrategy keepAliveStrategy;
	//private IdleConnectionMonitorThread connMonitorThread;

	private HttpClientFactory() {

	}

	public static HttpClientFactory getInstance() {
		return instance;
	}

	public void close() {
		//connMonitorThread.shutdown();
		//connMonitorThread.interrupt();
		httpClientManager.shutdown();
	}

	private HttpClient getClient() {
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(httpClientManager).setKeepAliveStrategy(keepAliveStrategy).build();
		return httpClient;
	}

	@Override
	public String doGet(String url, Map<String, String> header, String responseEncoding, int connTimeout, int requestTimeout) throws Exception {
		InputStream requestStream = null;
		InputStream responseStream = null;
		ByteArrayOutputStream outStream = null;
		CloseableHttpResponse response = null;
		try {
			String result = null;
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connTimeout * 1000).setConnectTimeout(connTimeout * 1000).setConnectionRequestTimeout(requestTimeout * 1000).setExpectContinueEnabled(false).build();
			HttpGet get = new HttpGet(url);
			get.setConfig(requestConfig);
			if (header != null) {
				Iterator<Entry<String,String>> iter = header.entrySet().iterator();
				while(iter.hasNext()){
					Entry<String,String> entry = iter.next();
					get.addHeader(entry.getKey(), entry.getValue());
				}
			}
			CloseableHttpClient httpclient = (CloseableHttpClient) getClient();
			response = httpclient.execute(get);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseStream = entity.getContent();
				outStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[RESPONSE_BUFFER];
				int length = responseStream.read(buffer);
				while (length != -1) {
					outStream.write(buffer, 0, length);
					length = responseStream.read(buffer);
				}
				outStream.flush();
				result = outStream.toString(responseEncoding);
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(String.format("doget,[url]=[%s], error[%s]", url, ex.getMessage()));
			throw ex;
		} finally {
			if (requestStream != null) {
				try {
					requestStream.close();
				} catch (Exception ex) {
				}
			}
			if (responseStream != null) {
				try {
					responseStream.close();
				} catch (Exception ex) {
				}
			}
			if (outStream != null) {
				try {
					outStream.close();
				} catch (Exception ex) {
				}
			}
			if (response != null) {
				try {
					response.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	@Override
	public String doPost(String url, Map<String, String> header, String body, String requestEncoding, String responseEncoding, int connTimeout, int requestTimeout) throws Exception {
		InputStream requestStream = null;
		InputStream responseStream = null;
		ByteArrayOutputStream outStream = null;
		CloseableHttpResponse response = null;
		try {
			String result = null;
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connTimeout * 10000).setConnectTimeout(connTimeout * 10000).setConnectionRequestTimeout(requestTimeout * 10000).setExpectContinueEnabled(false).build();
			HttpPost post = new HttpPost(url);
			post.setConfig(requestConfig);
			byte[] dataByte = body.getBytes(requestEncoding);
			requestStream = new ByteArrayInputStream(dataByte, 0, dataByte.length);
			HttpEntity requestEntity = new InputStreamEntity(requestStream, dataByte.length);
			post.setEntity(requestEntity);
			if (header != null) {
				Iterator<Entry<String,String>> iter = header.entrySet().iterator();
				while(iter.hasNext()){
					Entry<String,String> entry = iter.next();
					post.addHeader(entry.getKey(), entry.getValue());
				}
			}
			CloseableHttpClient httpclient = (CloseableHttpClient) getClient();
			response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseStream = entity.getContent();
				outStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[RESPONSE_BUFFER];
				int length = responseStream.read(buffer);
				while (length != -1) {
					outStream.write(buffer, 0, length);
					length = responseStream.read(buffer);
				}
				outStream.flush();
				result = outStream.toString(responseEncoding);
			}
			return result;
		} catch (Exception ex) {
			log.error(String.format("dopost,[url]=[%s], error[%s]", url, ex.getMessage()));
			throw ex;
		} finally {
			if (requestStream != null) {
				try {
					requestStream.close();
				} catch (Exception ex) {
				}
			}
			if (responseStream != null) {
				try {
					responseStream.close();
				} catch (Exception ex) {
				}
			}
			if (outStream != null) {
				try {
					outStream.close();
				} catch (Exception ex) {
				}
			}
			if (response != null) {
				try {
					response.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	@Override
	public String doDelete(String url, Map<String, String> header, String responseEncoding, int connTimeout, int requestTimeout) throws Exception {
		InputStream requestStream = null;
		InputStream responseStream = null;
		ByteArrayOutputStream outStream = null;
		CloseableHttpResponse response = null;
		try {
			String result = null;
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connTimeout * 1000).setConnectTimeout(connTimeout * 1000).setConnectionRequestTimeout(requestTimeout * 1000).setExpectContinueEnabled(false).build();
			HttpDelete get = new HttpDelete(url);
			get.setConfig(requestConfig);
			if (header != null) {
				Iterator<Entry<String,String>> iter = header.entrySet().iterator();
				while(iter.hasNext()){
					Entry<String,String> entry = iter.next();
					get.addHeader(entry.getKey(), entry.getValue());
				}
			}
			CloseableHttpClient httpclient = (CloseableHttpClient) getClient();
			response = httpclient.execute(get);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseStream = entity.getContent();
				outStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[RESPONSE_BUFFER];
				int length = responseStream.read(buffer);
				while (length != -1) {
					outStream.write(buffer, 0, length);
					length = responseStream.read(buffer);
				}
				outStream.flush();
				result = outStream.toString(responseEncoding);
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(String.format("doget,[url]=[%s], error[%s]", url, ex.getMessage()));
			throw ex;
		} finally {
			if (requestStream != null) {
				try {
					requestStream.close();
				} catch (Exception ex) {
				}
			}
			if (responseStream != null) {
				try {
					responseStream.close();
				} catch (Exception ex) {
				}
			}
			if (outStream != null) {
				try {
					outStream.close();
				} catch (Exception ex) {
				}
			}
			if (response != null) {
				try {
					response.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	@Override
	public String doPut(String url, Map<String, String> header, String body,
			String requestEncoding, String responseEncoding, int connTimeout,
			int requestTimeout) throws Exception {
		InputStream requestStream = null;
		InputStream responseStream = null;
		ByteArrayOutputStream outStream = null;
		CloseableHttpResponse response = null;
		try {
			String result = null;
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connTimeout * 1000).setConnectTimeout(connTimeout * 1000).setConnectionRequestTimeout(requestTimeout * 1000).setExpectContinueEnabled(false).build();
			HttpPut post = new HttpPut(url);
			post.setConfig(requestConfig);
			byte[] dataByte = body.getBytes(requestEncoding);
			requestStream = new ByteArrayInputStream(dataByte, 0, dataByte.length);
			HttpEntity requestEntity = new InputStreamEntity(requestStream, dataByte.length);
			post.setEntity(requestEntity);
			if (header != null) {
				Iterator<Entry<String,String>> iter = header.entrySet().iterator();
				while(iter.hasNext()){
					Entry<String,String> entry = iter.next();
					post.addHeader(entry.getKey(), entry.getValue());
				}
			}
			CloseableHttpClient httpclient = (CloseableHttpClient) getClient();
			response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseStream = entity.getContent();
				outStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[RESPONSE_BUFFER];
				int length = responseStream.read(buffer);
				while (length != -1) {
					outStream.write(buffer, 0, length);
					length = responseStream.read(buffer);
				}
				outStream.flush();
				result = outStream.toString(responseEncoding);
			}
			return result;
		} catch (Exception ex) {
			log.error(String.format("dopost,[url]=[%s], error[%s]", url, ex.getMessage()));
			throw ex;
		} finally {
			if (requestStream != null) {
				try {
					requestStream.close();
				} catch (Exception ex) {
				}
			}
			if (responseStream != null) {
				try {
					responseStream.close();
				} catch (Exception ex) {
				}
			}
			if (outStream != null) {
				try {
					outStream.close();
				} catch (Exception ex) {
				}
			}
			if (response != null) {
				try {
					response.close();
				} catch (Exception ex) {
				}
			}
		}
	}
}
