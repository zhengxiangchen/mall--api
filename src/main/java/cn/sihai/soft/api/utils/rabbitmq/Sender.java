package cn.sihai.soft.api.utils.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	@Autowired
	private AmqpTemplate template;
	
	public void sendEmail(String emailContent){
		template.convertAndSend("Email", emailContent);
	}
	
	
	public void sendNewOrder(String orderId){
		template.convertAndSend("newOrder", orderId);
	}

}
