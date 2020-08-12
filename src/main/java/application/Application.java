package application;

import java.math.BigInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@RequestMapping("/")
	public String home() {
		BigInteger fact = BigInteger.valueOf(1);
		for (int i = 1; i <= 2000; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return "Hello Kubernetes World!";
	}

	public static void main(String[] args ) {
		SpringApplication.run(Application.class, args);
	}
}
