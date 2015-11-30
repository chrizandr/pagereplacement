package pagereplace;


public class chance {
  public int request[];
  public int cache[],chan[],fifo[];
  public int  n,num;
  chance(int n1,int num1,int a[])
  {
	  n=n1;
	  num=num1;
	  //System.out.println(n+" sdfsdf "+num);
	  chan=new int[num];
	  cache=new int[num];
	  fifo=new int[num];
	  request=new int[n];
	  for(int i=0;i<num;i++)
	  {
		  cache[i]=-1;
		  chan[i]=-1;
		  fifo[i]=-1;
	  }
	  for(int i=0;i<n;i++)
		  request[i]=a[i];
	  }
  public void process()
  {
	  for(int i=0;i<n;i++)
	  {
		  int flag=-1;
		  int  flag1=-1;
		  for(int j=0;j<num;j++)
		  {
			  if(cache[j]==request[i]){
			 	  chan[j]=1;
			 	  flag1=0;
			 	  fifo[j]=i;
			      break;
			  }
		  }
		  
		  if(flag1==-1)
		  {
		  for(int j=0;j<num;j++)
		  {
			  if(cache[j]==-1)
			  {
				  flag=1;
				  cache[j]=request[i];
				  fifo[j]=i;
				  chan[j]=0;
				  break;
			  }
		  }
		  if(flag==-1)
		  {
			  
			
				      int min,ind;
				      min=999999999;
				      ind=999999;
			    	  for(int j=0;j<num;j++)
			    	  {
			    		if(min>fifo[j] && chan[j]!=1)
			    		  {
			    			  min=fifo[j];
			    			  ind=j;
			    		  }
			    	  }
			    	  cache[ind]=request[i];
			    	  chan[ind]=0;
			    	  fifo[ind]=i;
			    	  for(int j=0;j<num;j++)
			    	  {
			    		  if(chan[j]==1)
			    			  chan[j]=0;
			    	  }
			  }
		  }
			  for(int j=0;j<num;j++)
			  {
				  System.out.println("In cache-- "+cache[j]+" Chance bit "+chan[j]);
			  }
			  System.out.println("----Request "+i+" processed------");
		  
	  }
  }
  
	
}
