package com.restaurant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ConfigurationProperties(prefix = "com.restaurant")
@PropertySources({@PropertySource(value = "classpath:RestaurantAppProperties.properties"),
    			  @PropertySource(value = "file:RestaurantAppProperties.properties", ignoreResourceNotFound = true)})
@Primary
public class RestaurantAppProperties {
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Id: ").append("\""). append(id).append("\"").append("\n");
		sb.append("Name: ").append("\"").append(name).append("\"").append("\n");
		return sb.toString();
	}
		
}