package pl.itse.thread.buffer;

import java.util.ArrayList;
import java.util.List;

public class Buffer {

	private List<String> buf;	

	public Buffer() {
		super();
		this.buf = new ArrayList<String>();
	}

	public void put(String str) {
		buf.add(str);
	}

	public List<String> get() {
		return buf;
	}
}
