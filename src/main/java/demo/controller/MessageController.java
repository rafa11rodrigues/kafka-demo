package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.kafka.config.KafkaConfig;
import demo.kafka.config.KafkaProperties;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	@Autowired
	private KafkaTemplate<String, String> stringTemplate;

	@Autowired
	private KafkaProperties kafkaProperties;
	
	@GetMapping("/string")
	public String sendText(@RequestParam("string") String string) {
		System.out.println("Bootstrap address: " + kafkaProperties.getBootstrapAddress());
		System.out.println("Produced string: " + string + "\n");
		stringTemplate.send(KafkaConfig.STRING_TOPIC, string);
		return string;
	}
}
