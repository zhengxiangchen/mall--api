package cn.sihai.soft.api.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Bean
	public Queue queue1(){
		return new Queue("Email");
	}
	
	@Bean
	public Queue queue2(){
		return new Queue("newOrder");
	}

}
