package org.xiaomao.httpclient.example;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientConnectionRelease {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet("http://localhost:8080/servlet/helloservlet");

		logger.info("发送请求 " + httpGet.toString());

		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

			HttpEntity entity = httpResponse.getEntity();

			if (entity != null) {
				InputStream instream = entity.getContent();
				try {
					instream.read();
				} catch (IOException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				} finally {
					// 关闭流会触发连接断开
					instream.close();
				}
			}
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
