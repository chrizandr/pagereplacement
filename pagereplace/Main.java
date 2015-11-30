package pagereplace;

import java.util.Scanner;

public class Main {

	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);

		System.out.println("-------PAGE REPLACEMENT ALGORITHM-------");
		
		System.out.println("Enter frame size: ");
		int a=s.nextInt();
		System.out.println("Enter number of requests:");
		int n=s.nextInt();
		int req[]=new int[n];
		System.out.println("Enter "+n+" requests:");
		for(int i=0;i<n;i++)
		{
			int m=s.nextInt();
			req[i]=m;
		}
		
		System.out.println("SELECT ALGORITHM:\n1. FIFO\n2. LRU\n3. OPTIMAL PAGE REPLACEMENT\n4. SECOND CHANCE");
		int m=s.nextInt();
		switch(m)
		{
		case 1:
			fifo f=new fifo(a);
			for(int i=0;i<n;i++)
			f.request(req[i]);
			break;
		case 2:
			lru l=new lru(a);
			for(int i=0;i<n;i++)
			l.request(req[i]);
			break;
		case 4:
			chance c=new chance(n,a,req);
			c.process();
			break;
		case 3:
			opti o=new opti(n,req,a);
			o.process();
			break;
		}
		System.out.println(+n+" requests completed \n ----------END-----------");
	}

}
