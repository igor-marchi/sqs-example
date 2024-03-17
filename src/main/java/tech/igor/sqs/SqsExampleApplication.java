package tech.igor.sqs;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.igor.sqs.consumer.Message;

@SpringBootApplication
public class SqsExampleApplication implements CommandLineRunner {

	private final String SQS = "https://localhost.localstack.cloud:4566/000000000000/example-queue";

	public static void main(String[] args) {
		SpringApplication.run(SqsExampleApplication.class, args);
	}

	@Autowired
	private SqsTemplate sqsTemplate;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message to " + SQS);

		for (int index = 0; index < 5; index++) {
			int delay = index;
			sqsTemplate.send(to -> to
					.queue(SQS)
					.payload(new Message("Heeey! This message has a delay of " + delay + " seconds."))
					.delaySeconds(delay)
			);
		}
	}
}
