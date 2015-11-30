package pagereplace;

import java.util.Random;

public class lru {
private int size;
private int[] stack;
private int[] que;
private int pointer=0;

private Random r=new Random();

lru(int n){
	size=n;
	stack=new int[size];
	que=new int[size];
	for(int i=0;i<size;i++)
	{
		stack[i]=r.nextInt(100);
		que[i]=i;
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
private int lruar(int x)
{
	for(int i=0;i<size-1;i++)
	{
		if(que[i+1]!=x)
		{
			que[i]=que[i+1];
		}	
		else
			que[i]=que[i+2];
	}
	que[size-1]=x;
	return que[0];
}
public void request(int req){
	
	if(check(req))
	{
		int m=stack[pointer];
		stack[pointer]=req;
		System.out.println("FAULT--- Removed: "+m+" from address: "+pointer+"----Replaced with: "+req);
		pointer=lruar(pointer);
	}
	else 
	{
		int x=0;
		for(int i=0;i<size;i++)
		{
			if(stack[i]==req)
			{
				x=i;
				break;
			}
		}
		System.out.println("HIT----No need for replacement");
		pointer=lruar(x);
	}
}



}
