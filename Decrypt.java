package vinayak.enigma;
class Decrypt
{
	private String New;
	private String tmp;
	private int len;
	private int key;
	public Decrypt(String a)
	{
		tmp=a;
		len=tmp.length();
		key=(int)tmp.charAt(1);
		New="";
	}
	
	public void Decryptit()
	{
		int i,t;
		char ch;		
		key=key-65;
		for(i=0;i<len;i++)
		{
			if(i==1)continue;
			t=(int)tmp.charAt(i);
			if((t>64)&&(t<91))
			{
				t=t-key;
				if(t<65)
					t=91-65+t;
			}
			if((t>96)&&(t<123))
			{
				t=t-key;
				if(t<97)
					t=123-97+t;
			}
			ch=(char)t;
			New=New+ch;
		}
	}
	
	public String Display()
	{
		return New;
	}
}
