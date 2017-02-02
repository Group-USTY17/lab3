package com.ru.usty.threads;
import java.util.concurrent.*;

public class ThreadAssignment01Main {

    private static final int NUMBER_OF_PROBLEMS = 30;
    // POOL_SIZE is the no. if threads we wish to run at a time
    private static final int POOL_SIZE = 10;

    public static void main(String[] args) {

    	
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        long startTime = System.currentTimeMillis();
        
        Problem problem = Problematic.nextProblem();
   
        //                             REQUIREMENT 1
        // Sequentially: Don’t run the next instance until the one before has returned
        // Run the line "findAndPrint..." NUMBER_OF_PROBLEMS times
        System.out.println("Requirement 1");
        for(int i = 0; i < NUMBER_OF_PROBLEMS; i++){
            Solver.findAndPrintSolution(Problematic.nextProblem());
        }
        //-----------------------------------------------------------------------//

        //                              REQUIREMENT 2
        // All at once in separate threads. A new thread is created for each instance.
        System.out.println("Requirement 2");
        for(int i = 0; i < NUMBER_OF_PROBLEMS; i++){
            new Thread(new SomeRunnableThing(problem)).start();
        }
        //-----------------------------------------------------------------------//

        //                              REQUIREMENT 3
        // A certain number at a time
        // Threads are run through a thread pool of a certain size
        // New instances aren’t run until a thread is free in the thread pool.
        ExecutorService threadPool = Executors.newFixedThreadPool(POOL_SIZE);
        System.out.println("Requirement 3");
        for(int i = 0; i < NUMBER_OF_PROBLEMS; i++){
            threadPool.execute(new SomeRunnableThing(problem));
        }
        threadPool.shutdown();

        //-----------------------------------------------------------------------//


        /*  for(int i = 0; i < NUMBER_OF_PROBLEMS; i++){
        	    Problem problem = Problematic.nextProblem();
        	    Thread someThread = new Thread(new SomeRunnableThing(problem));
                someThread.start();
        	try {
				someThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }*/

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
