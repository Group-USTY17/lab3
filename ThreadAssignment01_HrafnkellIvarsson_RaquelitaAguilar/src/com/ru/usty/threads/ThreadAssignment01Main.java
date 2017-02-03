package com.ru.usty.threads;
import java.util.concurrent.*;

public class ThreadAssignment01Main {

    private static final int NUMBER_OF_PROBLEMS = 30;
    // POOL_SIZE is the no. if threads we wish to run at a time
    private static final int POOL_SIZE = 10;
    private static final int REQUIREMENT = 3; //what requirement to test

    public static void main(String[] args) {
    	
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        long startTime = System.currentTimeMillis();
        
        //-----------------------------------------------------------------------//
        
        //                             REQUIREMENT 1
        // Sequentially: Don’t run the next instance until the one before has returned
        // Run the line "findAndPrint..." NUMBER_OF_PROBLEMS times
        if(REQUIREMENT == 1){
        	System.out.println("Requirement 1");
        	for(int i = 0; i < NUMBER_OF_PROBLEMS; i++){
        		Solver.findAndPrintSolution(Problematic.nextProblem());
        	}
        }
        //-----------------------------------------------------------------------//

        //                              REQUIREMENT 2
        // All at once in separate threads. A new thread is created for each instance.
        if(REQUIREMENT == 2){
        	System.out.println("Requirement 2");
        	Thread[] threads = new Thread[NUMBER_OF_PROBLEMS];
        	for(int i = 0; i < NUMBER_OF_PROBLEMS; i++){
        		threads[i] = new Thread(new SomeRunnableThing(Problematic.nextProblem()));
        		threads[i].start();
        	}
        	for(int i = 0; i < NUMBER_OF_PROBLEMS; i++){ //join the threads to get running time
        		try { threads[i].join(); }
        		catch (InterruptedException e) { e.printStackTrace(); }
        	}
        }
        //-----------------------------------------------------------------------//

        //                              REQUIREMENT 3
        // A certain number at a time
        // Threads are run through a thread pool of a certain size
        // New instances aren’t run until a thread is free in the thread pool.
        if(REQUIREMENT == 3){
        	System.out.println("Requirement 3");
        	ExecutorService threadPool = Executors.newFixedThreadPool(POOL_SIZE);
        	for(int i = 0; i < NUMBER_OF_PROBLEMS; i++){
        		threadPool.execute(new SomeRunnableThing(Problematic.nextProblem()));
        	}
        	threadPool.shutdown();
        	try{
        		threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        	}catch(InterruptedException e){
        		e.printStackTrace();
        	}
        }
        //-----------------------------------------------------------------------//

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
