package com.gmail.gm.jcant.threadsample1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Common common = new Common();
		
		Worker w1 = new Worker(1, 1, common);
		Worker w2 = new Worker(2, 2, common);
		Worker w3 = new Worker(3, 3, common);
		Worker w4 = new Worker(4, 4, common);
		
		Thread one = new Thread(w1);
		Thread two = new Thread(w2);
		Thread three = new Thread(w3);
		Thread four = new Thread(w4);

		boolean work = true;
		Scanner cs = new Scanner(System.in);
		
		one.start();
		two.start();
		three.start();
		four.start();
		
		//enter 0 - to stop main thread, or number from 1 to 3 to stop corresponding thread
		while(work) {
			int g = cs.nextInt();
			if (g == 0) work = false;
			if (g == 1) common.thread1Stop = true;
			if (g == 2) common.thread2Stop = true;
			if (g == 3) common.thread3Stop = true;
		}
		
		System.out.println("MAIN STOP");
		
	}

}
