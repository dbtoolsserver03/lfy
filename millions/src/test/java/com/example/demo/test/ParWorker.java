package com.example.demo.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.jd.platform.async.callback.IWorker;
import com.jd.platform.async.wrapper.WorkerWrapper;

/**
 * 作者：周瑜大都督
 */
public class ParWorker implements IWorker<String, String> {

	public String action(String param, Map<String, WorkerWrapper> map) {
		System.out.println(Thread.currentThread().getName() + " param=" + param + " "
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return param;
	}

	@Override
	public String defaultValue() {
		return "default value";
	}

	@Override
	public String action(String object) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
