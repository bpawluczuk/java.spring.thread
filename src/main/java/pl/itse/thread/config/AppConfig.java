package pl.itse.thread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.itse.thread.runnable.EmailSenderRunnable;
import pl.itse.thread.runnable.EmailSenderScheduledRunnable;
import pl.itse.thread.service.EmailScheduledService;

@Configuration
@ComponentScan({ "pl.itse" })
public class AppConfig {

	@Bean("emailSenderService")
	public EmailSenderRunnable emailSenderRunnable() {
		return new EmailSenderRunnable();
	}
	
	@Bean("emailSenderScheduledRunnable")
	public EmailSenderScheduledRunnable emailSenderScheduledRunnable() {
		return new EmailSenderScheduledRunnable();
	}
	
	@Bean("emailSenderServiceScheduled")
	public EmailScheduledService emailService() {
		return new EmailScheduledService();
	}


}
