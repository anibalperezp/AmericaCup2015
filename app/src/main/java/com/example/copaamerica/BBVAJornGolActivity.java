package com.example.copaamerica;

public class BBVAJornGolActivity {
	public int GolesXplay(String as)
	{
		char[] hf=new char[]{'a','b','c','d','e','f','g','h','i','j'};
		char[] hfw=new char[]{'0','1','2','3','4','5','6','7','8','9'};
		int asdfd=0;
		char[] fedd=as.toCharArray();
		for (int i = 0; i < hf.length; i++) {
			if(hf[i]==fedd[0])
			{
				fedd[0]=hfw[i];
			}
			if(hf[i]==fedd[1])
			{
				fedd[1]=hfw[i];
			}
			if(hf[i]==fedd[2])
			{
				fedd[2]=hfw[i];
			}
			if(hf[i]==fedd[3])
			{
				fedd[3]=hfw[i];
			}
			if(hf[i]==fedd[4])
			{
				fedd[4]=hfw[i];
			}
			if(hf[i]==fedd[5])
			{
				fedd[5]=hfw[i];
			}
			if(hf[i]==fedd[6])
			{
				fedd[6]=hfw[i];
			}
			if(hf[i]==fedd[7])
			{
				fedd[7]=hfw[i];
			}
		}
		String czv=String.valueOf(fedd[0])+ String.valueOf(fedd[1]) + String.valueOf(fedd[2]) + String.valueOf(fedd[3]) + String.valueOf(fedd[4]) + String.valueOf(fedd[5]) + String.valueOf(fedd[6]) + String.valueOf(fedd[7]);
		asdfd=Integer.parseInt(czv);
		return asdfd;
	}

}
