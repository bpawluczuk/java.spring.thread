package pl.itse.thread.runnable;

import pl.itse.thread.buffer.Buffer;

public class AddBufferRunnable implements Runnable {

	private Buffer buf;
	private String str;
	
	public AddBufferRunnable(Buffer buf, String str) {
		super();
		this.buf = buf;
		this.str = str;
	}

	public void run() {

		System.out.println("Add to buffer message: " + str);

		buf.put(str);
	}

}
