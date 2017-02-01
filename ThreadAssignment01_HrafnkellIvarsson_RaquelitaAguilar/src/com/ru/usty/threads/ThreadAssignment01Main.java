package com.ru.usty.threads;

public class ThreadAssignment01Main {

    private static final int NUMBER_OF_PROBLEMS = 30;

    public static void main(String[] args) {
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Solutions:");

        long startTime = System.currentTimeMillis();

        // PROJECT REQUIREMENTS:
        // 
        // Write a program in Java that runs the function Solver.findAndPrintSolution() 30 times. 
        // It will do it in the following three ways:
        //
        // 1. Sequentially: Don’t run the next instance until the one before has returned
        //
        // 2. All at once in separate threads. A new thread is created for each instance.
        //
        // 3. A certain number at a time. Threads are run through a thread pool of a certain size 
        // (students can try different sizes). New instances aren’t run until a thread is free in the thread pool.
        
        //Solver.findAndPrintSolution(Problematic.nextProblem());
        
        
        for(int i = 0; i < NUMBER_OF_PROBLEMS; i++){
        	Problem problem = Problematic.nextProblem();
        	Thread someThread = new Thread(new SomeRunnableThing(problem));
            someThread.start();
        	try {
				someThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
    	
        System.out.println("All done");
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
