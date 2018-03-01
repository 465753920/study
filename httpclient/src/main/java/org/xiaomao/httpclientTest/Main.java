package org.xiaomao.httpclientTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class Main {
	
//	HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//	HttpClient httpClient = httpClientBuilder.build();
//	HttpResponse response = httpClient.execute(request);
//	
//	HttpPost httpPost = new HttpPost("http://192.168.93.23:8080/socialfile-server/api/monitor/monitorpics");
//
//	httpPost.setHeader("Content-Type", "application/json");
//	
//	StringEntity entity = new StringEntity(
//			"{\"uploadTime\" : \"2018-01-16\",\"signboardNo\" : \"16091013\",\"pageNo\" : 0}", "UTF-8");
//	httpPost.setEntity(entity);

	public static void main(String[] args) {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		HttpClient client = httpClientBuilder.build();
		HttpPost post = new HttpPost("http://192.168.93.23:8080/socialfile-server/api/monitor/monitorpics");
		try {
			post.setHeader("soms-access-token", "eastcom");
			post.setHeader("Content-Type", "application/json");
			
			StringEntity entity = new StringEntity(
					"{\"uploadTime\" : \"2018-01-16\",\"signboardNo\" : \"16091013\",\"pageNo\" : 0}", "UTF-8");
			
			post.setEntity(entity);

			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
