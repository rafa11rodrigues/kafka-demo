package demo.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {

	private UUID id;
	
	private String name;
	
	private LocalDateTime createdAt;
	
	public User(String name) {
		this.name = name;
		
		this.id = UUID.randomUUID();
		this.createdAt = LocalDateTime.now();
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
