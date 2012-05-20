package com.shrikar.analytics;


public class LinearCountingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinearCounting lc = new LinearCounting(1000000);
		for(int i = 0; i < 6000000	; i++){
			lc.addKey(i);
		}
		System.out.println("Cardinality :" + lc.cardinality());
	}

}
