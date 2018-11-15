package cn.sihai.soft.api.utils.rabbitmq;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Receive {
	
	@Autowired
	private JavaMailSender mailSender;//自动注入
	
	@RabbitListener(queues="Email")    //监听器监听指定的Queue
	public void receiveEmail(String str) throws MessagingException {
		
		String[] toAddress = new String[2];
		toAddress[0] = "510849431@qq.com";
//		toAddress[1] = "305711597@qq.com";
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        message.setFrom("510849431@qq.com");//设置发信人，发信人需要和spring.mail.username配置的一样否则报错
        message.setTo("510849431@qq.com");//设置收信人
        message.setSubject("小程序下单");	//设置主题
        
//        message.setText(sb.toString());//第二个参数true表示使用HTML语言来编写邮件
        message.setText(str,true);

        mailSender.send(mimeMessage);
		
        
    }

}
