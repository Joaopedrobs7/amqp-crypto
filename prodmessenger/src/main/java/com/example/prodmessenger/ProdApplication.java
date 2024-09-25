package com.example.prodmessenger;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProdApplication {

	 static final String directExchangeName = "direct-exchange";
	 static final String topicExchangeName = "topic-exchange";
	 static final String routingKeyLow = "rota-um";
	 static final String routingKeyMid = "rota-dois";
	 static final String routingKeyLHigh = "rota-tres";
	 
//	 @Bean
//	 DirectExchange exchange() {
//	      return new DirectExchange(directExchangeName,false, true);
//	 }
	 @Bean
	 TopicExchange exchange() {
	      return new TopicExchange(topicExchangeName,true, false);
	 }
	 
	public static void main(String[] args) {
		SpringApplication.run(ProdApplication.class, args);
	}
}