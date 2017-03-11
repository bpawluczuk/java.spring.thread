package pl.itse.thread.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Service;

import pl.itse.thread.runnable.EmailSenderScheduledRunnable;


@Service
public class EmailScheduledService implements Lifecycle {
	
	private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
	
	@Autowired
	EmailSenderScheduledRunnable emailSenderScheduledRunnable;
    
    public void sendMessage(String message) {
    }

	public boolean isRunning() {

		return threadPool.isTerminated();
	}
	
	public void start() {

		threadPool.scheduleAtFixedRate(emailSenderScheduledRunnable, 10, 10, TimeUnit.SECONDS);
	}

	public void stop() {

		threadPool.shutdown();
        while (isRunning()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
	}
}
