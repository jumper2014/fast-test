package com.ys.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpRequest {
	public String getAjaxResponse(String url) throws ClientProtocolException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = null;
		HttpGet get = new HttpGet(url);
		response = client.execute(get);	
		HttpEntity entity = response.getEntity();
		BufferedReader bufferedReader=new BufferedReader
                (new InputStreamReader(entity.getContent(), "UTF-8"), 8*1024);
        String line=null;
        StringBuilder entityStringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            entityStringBuilder.append(line);
        }
        String res=entityStringBuilder.toString();
		
		return res;
	}

    public String getResponse(String url) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = null;
        HttpGet get = new HttpGet(url);
        try {
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        BufferedReader bufferedReader= null;
        try {
            bufferedReader = new BufferedReader
                    (new InputStreamReader(entity.getContent(), "UTF-8"), 8*1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line=null;
        StringBuilder entityStringBuilder = new StringBuilder();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                entityStringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String res=entityStringBuilder.toString();

        return res;
    }
}
