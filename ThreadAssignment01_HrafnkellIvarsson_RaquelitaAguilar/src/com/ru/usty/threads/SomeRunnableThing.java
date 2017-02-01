package com.ru.usty.threads;

public class SomeRunnableThing implements Runnable{
	@Override
	public void run() {
		long tID = Thread.currentThread().getId();
		Solver.findAndPrintSolution(problem);
		//System.out.println("ID: " + tID);
	}
	
	public SomeRunnableThing(Problem p) {
		problem = p;
	}
	
	private static Problem problem;
}
