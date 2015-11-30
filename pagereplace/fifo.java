package pagereplace;

import java.util.Random;

public class fifo {
private int size;
private int[] stack;
private int pointer=0;

private Random r=new Random();

fifo(int n){
	size=n;
	stack=new int[size];
	for(int i=0;i<size;i++)
	{
		stack[i]=r.nextInt(100);
	}
}
private boolean check(int req){
	for(int i=0;i<size;i++)
	{
		if(stack[i]==req)
		{
			return false;
		}
	}
	return true;
}
public void request(int req){
	if(check(req))
	{
		int m=stack[pointer];
		stack[pointer]=req;
		System.out.println("FAULT--- Removed: "+m+" from address: "+pointer+"----Replaced with: "+req);
		pointer=(pointer+1)%size;
	}
	else 
	{
		System.out.println("HIT----No need for replacement");
	}
}



}
