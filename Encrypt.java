package vinayak.enigma;
import java.util.Random;
class Encrypt
{
	private char A[];
	private int len;
	private int key;
	private Random gen;
	public Encrypt(String x)
	{
		try{		
		char tmp[]=x.toCharArray();		
		len=tmp.length+1;
		gen=new Random();
		key=gen.nextInt(26)+65;
		A=new char[len];
		A[0]=tmp[0];
		A[1]=(char)key;
		for(int i=2;i<len;i++)
		{	
			A[i]=tmp[i-1];
		}	
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}

	public void Encryptit()
	{
		int i,t;
		char ch;
		key=key-65;
		for(i=0;i<len;i++)
		{
			if(i==1)continue;
			t=(int)A[i];
			if((t>64)&&(t<91))
			{
				t=t+key;
				if(t>90)
					t=t-90+64;
			}
			if((t>96)&&(t<123))
			{
				t=t+key;
				if(t>122)
					t=t-122+96;
			}
			ch=(char)t;
			A[i]=ch;
		}
	}
	
	public String Display()
	{
		String tmp=new String(A);
		return tmp;
	}
}

