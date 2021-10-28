package com.gmail.gm.jcant.threadsample1;

import java.util.Date;

public class Worker implements Runnable {

	private Common common;
	private int workerNumber;

	private int pauseInSeconds;

	public Worker(int number, int pause, Common common) {
		this.workerNumber = number;
		this.pauseInSeconds = pause;
		this.common = common;
	}

	@Override
	public void run() {

		while (!haveToStop()) {
			System.out.println(new Date() + " I'am a thread number: " + workerNumber);

			try {
				Thread.sleep(pauseInSeconds * 1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("WORKER " + workerNumber + " STOP!");

	}

	private boolean haveToStop() {
		if (workerNumber == 1)
			return common.thread1Stop;
		if (workerNumber == 2)
			return common.thread2Stop;
		if (workerNumber == 3)
			return common.thread3Stop;
		return true;
	}

}
