/*
*Written by Andrew Davison
*/
public class test {

	public static void main(String[] args) {
		ProcessScheduler scheduler = new ProcessScheduler();
		Process p = new Process("process 1", 5.0);
		scheduler.addProcess(p);
		scheduler.printProcessQueue();

	}

}
