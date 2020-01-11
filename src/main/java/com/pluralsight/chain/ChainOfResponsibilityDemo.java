package com.pluralsight.chain;


public class ChainOfResponsibilityDemo {

	public static void main(String[] args) {
		Director bryan = new Director();
		VP crystal = new VP();
		CEO jeff = new CEO();
		
		bryan.setSuccessor(crystal);
		crystal.setSuccessor(jeff);
		
		Request request = new Request(RequestType.CONFERENCE, 500);
		jeff.handleRequest(request);
		
		request = new Request(RequestType.PURCHASE, 1000);
		jeff.handleRequest(request);
		
		request = new Request(RequestType.PURCHASE, 2000);
		jeff.handleRequest(request);
	}
}
