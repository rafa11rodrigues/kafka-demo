package demo.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaConfig {

	@Autowired
	private KafkaProperties kafkaProperties;
	
	public static final String STRING_TOPIC = "STRING_TOPIC";
	
	public static final String USER_TOPIC = "STRING_TOPIC";
	
	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> config = new HashMap<>();
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapAddress());
		return new KafkaAdmin(config);
	}
	
	@Bean
	public NewTopic stringTopic() {
		return new NewTopic(STRING_TOPIC, 1, (short) 1);
	}
	
	@Bean
	public NewTopic userTopic() {
		return new NewTopic(USER_TOPIC, 1, (short) 1);
	}
}
