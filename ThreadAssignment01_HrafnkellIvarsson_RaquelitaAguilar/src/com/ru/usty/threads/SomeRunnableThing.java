package com.ru.usty.threads;

// Create separate class that implements runnable
// The function run is what will be executed when we call
// someThread.start(); that is if the thread was implemented like this:
// Thread someThread = new Thread(new SomeRunnableThing);


public class SomeRunnableThing implements Runnable{
	
	Problem problem;
	
	@Override
	public void run() {
		Solver.findAndPrintSolution(problem);
	}
	
	public SomeRunnableThing(Problem p) {
		problem = p;
	}
}
