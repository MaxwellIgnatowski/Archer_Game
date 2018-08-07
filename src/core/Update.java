package core;

public class Update extends OverworldBuilder implements Runnable
{
	private boolean running = false;
	private Thread thread;
	
	//Create Overworld Builder
	public Update()
	{
		super();
	}
	
	//Timer Start
	public synchronized void start()
	{
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
		
	//Timer Stop
	public synchronized void stop()
	{
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		System.exit(1);
	}
	
	//Timer Running
	public void run()
	{
		while(running)
		{
			tick();
		}
		stop();
	}
	
	//Updates the Window
	public void tick()
	{
		if(overworldScreen.character.intersects(enemy1) && enemy1.hotspot.isVisible() && overworldScreen.character.canMove) 
		{
			newBattle();
		}
	}
}
