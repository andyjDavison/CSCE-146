/*
*Written by Andrew Davison
*/
public class ProcessScheduler {

	private LLQueue<Process> processes;
	private Process currentProcess;
	
	public Process getCurrentProcess()
	{
		if(this.currentProcess == null)
			return null;
		return this.currentProcess;
	}
	public void addProcess(Process aProcess)
	{
		if(this.getCurrentProcess() == null)
		{
			this.currentProcess = aProcess;
			return;
		}
		processes.enqueue(aProcess);
	}
	public void runNextProcess()
	{
		this.currentProcess = processes.dequeue();
	}
	public void cancelCurrentProcess()
	{
		processes.dequeue();
		this.runNextProcess();
	}
	public void printProcessQueue()
	{
		processes.print();
	}
}
