# Lab3 - ThreadAssignment01
### USTY
#### 3. February 2017

---

## The Product

Write a program in Java that runs the function Solver.findAndPrintSolution() 30 times. It will do it in the following three ways:

1. Sequentially: Don’t run the next instance until the one before has returned
2. All at once in separate threads. A new thread is created for each instance.
3. A certain number at a time. Threads are run through a thread pool of a certain size (students can try different sizes). New instances aren’t run until a thread is free in the thread pool.

You must also return a PDF document containing the additions you made to the base program to implement parts 1-3 above as well as a sample output for each part. The PDF should also include a short description for each of the parts of how and why the order of solutions written out changes. Also include a little in part 3 on what effect the number of concurrent threads had.

The program code needed in the PDF document is what the line:
"Solver.findAndPrintSolution(Problematic.nextProblem());"
in the base program is replaced with, as well as any helper functions that are written.  
  
  


## Getting and returning the assignment

The project is on myschool. There is a ZIP archive with the base program. Unzip it and open. In Eclipse you can do File-import-general-existing projects into workspace. Then pick the folder and import the project. Make sure you do refacter-rename on the project to change it to your own names.
Once you have finished the project, re-archive the folder and return it into the myschool project system, along with the result PDF.
Students can work on this assignment in groups of up to two.

