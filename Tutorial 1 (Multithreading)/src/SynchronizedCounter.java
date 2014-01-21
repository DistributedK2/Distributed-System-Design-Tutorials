
public class SynchronizedCounter extends Thread
{
	private int count = 0;
	private int syncCount = 0;
	
	private static SynchronizedCounter threadA;
	private static SynchronizedCounter threadB;
	
	public void increment()
	{
		count ++;
	}
	
	public void decrement()
	{
		count --;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public synchronized void synchIncrement()
	{
		syncCount ++;
	}
	
	public synchronized void synchDecrement()
	{
		syncCount --;
	}
	
	public synchronized int getSyncCount()
	{
		return syncCount;
	}
	
	public static void main(String[] args) 
	{
		threadA = new SynchronizedCounter();
		threadB = new SynchronizedCounter();
		
		threadA.increment();
		threadB.decrement();
		System.out.println("threadA with id " + threadA.getId() + " has count " + threadA.getCount());
		System.out.println("threadB with id " + threadB.getId() + " has count " + threadB.getCount());
		
		threadA.synchIncrement();
		threadB.synchDecrement();
		System.out.println("threadA with id " + threadA.getId() + " has synched count " + threadA.getSyncCount());
		System.out.println("threadB with id " + threadB.getId() + " has synched count " + threadB.getSyncCount());
	}
	
}
