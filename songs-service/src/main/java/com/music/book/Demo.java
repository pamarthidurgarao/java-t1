package com.music.book;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;

public class Demo {
    private static final String API_MP3 = "http://mp3teluguwap.net/mp3";

    public static void main(String[] args) throws Exception {
//	HttpClient httpClient = HttpClient.newBuilder().build();
////	url = url.replaceAll(" ", "%20");
//	HttpRequest request = HttpRequest
//		.newBuilder(
//			new URI("http://mp3teluguwap.net/mp3/2021/A1%20Express/Poratamey%20-%20SenSongsMp3.Com.mp3"))
//		.GET().build();
//	HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
//	System.out.println(response.body());

	HttpClient client = new DefaultHttpClient();
	HttpGet post = new HttpGet("http://mp3teluguwap.net/mp3/2021/A1%20Express/Poratamey%20-%20SenSongsMp3.Com.mp3");
	HttpResponse response = client.execute(post);
	String result = EntityUtils.toString(response.getEntity());
	System.out.println(result);
    }
}
