package pagereplace;

public class opti {
	public int cache[];
	public int request[];
	public int num;
	private int kill;
	opti(int n,int a[],int b)
	{
		num=n;
		System.out.println("Numbre of requests: "+num);
		kill=b;
		cache=new int[kill];
		request=new int[20];
		for(int i=0;i<kill;i++)
			cache[i]=-1;
		for(int i=0;i<20;i++)
			request[i]=i;
		for(int i=0;i<n;i++)
			request[i]=a[i];
		System.out.println("Requesting..");
		
	}
	public void process()
	{
		System.out.println("Processing..");
		int f=0;
		int i=0;
		int flag=0;
		while(f<num){
			int c=0;			
		//	for(int  p=0;p<4;p++)
			//	System.out.println(p+" "+cache[p]);
			if(flag==1)
			{
				System.out.println("Aready available in cache "+request[i]);
				i++;
				f++;
				flag=0;
				
			}
			else{
			for(int p=0;p<kill;p++)
			{
			if(cache[p]==-1){
				cache[p]=request[i];
				System.out.println("Into cache "+request[i]);
				f++;
				i++;
				break;
			}
			else
				c++;
			}
			if(c==kill){
				int wanted[];
				wanted=new int[kill];
				
				for(int p=0;p<kill;p++)
				{
					if(cache[p]==request[i])
					{	flag=1;
					    break;
					}
				}
				if(flag==0){
					for(int p=0;p<kill;p++)
						wanted[p]=0;
				for(int r=0;r<kill;r++)
				{
					for(int t=i+1;t<num;t++)
					{
					  	if(cache[r]==request[t])
					  	{
					  		wanted[r]=t;
					  		break;
					  	}
					}						
				}
				int ma=wanted[0],index=0;
				for(int l=0;l<kill;l++)
				{
					if(ma<wanted[l])
					{
						ma=wanted[l];
						index=l;
					}
				}
				System.out.println("Removed "+cache[index]);
				cache[index]=-1;
			}
			}
			}
		}
	}

}
