package demo.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("kafka")
public class KafkaProperties {

	private String bootstrapAddress;

	public String getBootstrapAddress() {
		return bootstrapAddress;
	}

	public void setBootstrapAddress(String bootstrapAddress) {
		this.bootstrapAddress = bootstrapAddress;
	}
}
