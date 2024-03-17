package tech.igor.sqs.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @SqsListener("example-queue")
    public void listen(Message message) {
        System.out.println("Received message: " + message.content());
    }
}
