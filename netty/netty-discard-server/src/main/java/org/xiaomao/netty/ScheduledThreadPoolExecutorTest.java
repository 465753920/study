package org.xiaomao.netty;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {

	public static void main(String[] args) {

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

		// execute once
		// executor.execute(new Thread(new Runnable() {
		// public void run() {
		// System.out.println("haha");
		// }
		// }));

		ScheduledFuture<?> future = executor.scheduleAtFixedRate(new Thread(new Runnable() {
			public void run() {
				System.out.println("haha");
			}
		}), 1, 2, TimeUnit.SECONDS);

		while (true) {
			if (future.isDone())
				System.out.println("Tast is done!");
		}
	}

}
