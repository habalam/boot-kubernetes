package client;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.javasimon.Split;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HttpClientSender {

	@Async("customTaskExecutor")
	public void send(HttpClient client, HttpRequest request) {
//		System.out.println(Thread.currentThread().getName());
		Split split = Split.start();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenAccept(t -> System.out.println(Thread.currentThread().getName() + " - " + (split.runningFor() / 1000000) + " ms"))
			.join();
	}
}
