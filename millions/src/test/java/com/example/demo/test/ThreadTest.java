package com.example.demo.test;

import org.junit.jupiter.api.Test;

import com.jd.platform.async.executor.Async;
import com.jd.platform.async.wrapper.WorkerWrapper;

public class ThreadTest {


	@Test
	void fun() {
		   ParWorker w1 = new ParWorker();
	        ParWorker w2 = new ParWorker();
	        ParWorker w3 = new ParWorker();

	        WorkerWrapper<String, String> workerWrapper3 = new WorkerWrapper.Builder<String, String>()
	                .worker(w3)
	                .param("3")
	                .build();

	        WorkerWrapper<String, String> workerWrapper2 = new WorkerWrapper.Builder<String, String>()
	                .worker(w2)
	                .param("2")
	                .next(workerWrapper3)
	                .build();

	        WorkerWrapper<String, String> workerWrapper1 = new WorkerWrapper.Builder<String, String>()
	                .worker(w1)
	                .param("1")
	                .next(workerWrapper3)
	                .build();


	        try {
		        Async.beginWork(10 * 1000, workerWrapper1, workerWrapper2);

			} catch (Exception e) {
				e.printStackTrace();
			}
	        System.out.println(11);
	        Async.shutDown();



	}
}
