package client;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HttpClientSender {

	@Async("customTaskExecutor")
	public void send(HttpClient client, HttpRequest request) {
//		System.out.println(Thread.currentThread().getName());
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenAccept(System.out::println)
			.join();
	}
}
