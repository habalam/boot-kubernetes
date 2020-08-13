package client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpClientRest {

	HttpClientSender httpClientService;

	public HttpClientRest(HttpClientSender httpClientService) {
		this.httpClientService = httpClientService;
	}

	@RequestMapping("/{URL}")
	public void sendHttpRequest(@PathVariable("URL") String url) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();
		requestBuilder.uri(URI.create("http://localhost:31566/"));
		HttpRequest request = requestBuilder.build();

		for (int i = 0; i < 200000; i++) {
			httpClientService.send(client, request);
		}
	}
}
