package demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import demo.domain.entity.User;
import demo.kafka.config.KafkaConfig;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = KafkaConfig.STRING_TOPIC, groupId = KafkaConsumerConfig.GROUP_ID)
	public void consumeString(String string) {
		System.out.println("Consumed string: " + string);
	}
	
	@KafkaListener(topics = KafkaConfig.USER_TOPIC, groupId = KafkaConsumerConfig.GROUP_ID, containerFactory = "userListenerContainerFactory")
	public void consumeUser(User user) {
		System.out.println("Consumed user: " + user);
	}
}
