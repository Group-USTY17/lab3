package com.ru.usty.threads;

public class ThreadAssignment01Main {

    private static final int NUMBER_OF_PROBLEMS = 30;

    public static void main(String[] args) {
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Solutions:");

        long startTime = System.currentTimeMillis();

        //Solver.findAndPrintSolution(Problematic.nextProblem());

        // Array with 5 instances of threads
        Thread[] threads = new Thread[5];
        
        for(int i = 0; i < 5; i++){
        	threads[i] = new Thread(makeNewRunnable(i));
        	threads[i].start(); // Keyrum alla þræði 
        }
    	try {
    		for(int i = 0; i < 5; i++){
    			threads[i].join(); // join-ar svo þræðina
    		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
        System.out.println("All done");
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

	private static Runnable makeNewRunnable(final int number) {
		return new Runnable(){
        	@Override
        	public void run(){
        		System.out.println("Þráður " + number +  " keyrir");
        	}
		};
	}
}
