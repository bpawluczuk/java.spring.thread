package pl.itse.thread.runnable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.itse.thread.dao.EmailDao;
import pl.itse.thread.model.Email;

@Component
public class EmailSenderRunnable implements Runnable {

	@Autowired
	public EmailDao emailDao;

	public void run() {

		// Uncomment if you insert record to database
		// emailDao.create(new Email("emailA@email.pl"));

		for (Email message : emailDao.findAll()) {
			sendEmail(message);
		}
	}

	public void sendEmail(Email email) {

		System.out.println("Email Sender: " + email.toString());
	}

}
