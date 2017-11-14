package org.xiaomao.httpclient.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientWithResponseHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			URI uri = new URIBuilder().setScheme("http").setHost("localhost").setPort(8080)
					.setPath("/servlet/helloservlet").build();
			HttpGet httpGet = new HttpGet(uri);

			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				@Override
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};

			String responseBody = httpClient.execute(httpGet, responseHandler);
			logger.info("--------------------------------");
			logger.info(responseBody);
		} catch (URISyntaxException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
