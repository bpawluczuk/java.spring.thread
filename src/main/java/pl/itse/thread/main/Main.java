package pl.itse.thread.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.itse.thread.buffer.Buffer;
import pl.itse.thread.config.AppConfig;
import pl.itse.thread.runnable.AddBufferRunnable;
import pl.itse.thread.runnable.EmailSenderRunnable;
import pl.itse.thread.service.EmailScheduledService;

/*
* Simple example how to use thread in spring application
* 
* @author Borys Pawluczuk
*/

public class Main {

	public static void main(String[] args) {

		// Get context application
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Thread - add to buffer message ...

		Buffer buf = new Buffer();

		Thread threadA = new Thread(new AddBufferRunnable(buf, "Message A"));
		Thread threadB = new Thread(new AddBufferRunnable(buf, "Message B"));

		threadA.start();
		threadB.start();

		// Email sender service ...

		EmailSenderRunnable emailSenderService = context.getBean("emailSenderService", EmailSenderRunnable.class);

		Thread threadEmailSenderService = new Thread(emailSenderService);

		threadEmailSenderService.start();

		// Email sender service scheduled thread...

		EmailScheduledService emailService = context.getBean("emailSenderServiceScheduled",	EmailScheduledService.class);

		emailService.start();
	}

}
