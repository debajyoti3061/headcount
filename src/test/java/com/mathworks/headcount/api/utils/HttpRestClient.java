package com.mathworks.headcount.api.utils;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;

public class HttpRestClient {


	public HttpClient client = HttpClientBuilder.create().build();

	private void doRequest(HttpRequestBase request) throws IOException {
		Common.response = client.execute(request);
		Common.responsecode = Common.getResponse().getStatusLine().getStatusCode();
		Common.responsestring = EntityUtils.toString(Common.response.getEntity());
	}

	public void executeGet(HttpGet get) throws IOException {
		doRequest(get);
	}

	public void executePost(HttpPost post) throws IOException {
		doRequest(post);
	}

	public void executePut(HttpPut put) throws IOException {
		doRequest(put);
	}

	public void executePatch(HttpPatch patch) throws IOException {
		doRequest(patch);
	}

	public void executeDelete(HttpDelete delete) throws IOException {
		doRequest(delete);
	}

}
