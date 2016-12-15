package encryption;

import java.util.Random;

public class Encrypt {
private char in[] = new char[1000];
private String sin = "";
private int pone;
private int ptwo;
private int pthree;

private String sout = "";
	public Encrypt(String s, int a, int b, int c){
		sin = s;
		for(int i = 0; i < sin.length(); i++){
			in[i] = sin.charAt(i);
		}
		pone = a;
		ptwo = b;
		pthree = c;
	}


public String encrypt(){
	//part one - gibberish
	for(int i = 0; i < sin.length(); i++){
		sout += in[i];
		if(pone > 0){
		for(int ii = 1; ii <= pone; ii++){
			int s = ran(35, 126);
			if(s==92 || s==91)
			s++;
			
			sout += (char)s;
		}
	}}
	//part two - shift beginning to end
	sout += sout.substring(0, ptwo);
	String soutm = sout.substring(0, ptwo);
	sout = sout.substring(ptwo);
	//part three - cesear shift
	char smod[] = new char[sout.length()];
	for(int i = 0; i<sout.length(); i++){
		smod[i] = sout.charAt(i);
	}
	for(int i = 0; i<smod.length; i++){
	int f = (int)smod[i];
	f += pthree;
	smod[i] = (char)f;
	}
	sout = "";
	for(int i = 0; i<smod.length; i++){
		sout += smod[i];
	}
	
	return sout;	
}

public int ran(int min, int max) {

    Random rand = new Random();

    // nextInt excludes the top value so we have to add 1 to include the top value
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}

public String decrypt(){
	sin = sout;
	
	//Undo part Two - length shift
	sin = sin.substring(sin.length()-ptwo) + sin.substring(0,ptwo);
	//Undo part one - random numerals.
	
	for(int i = 0; i < sin.length(); i++){
		in[i] = sin.charAt(i);
	}
	sout = "";
	for(int i = 0; i < sin.length(); i+=pone){
		sout += in[i];
	}
	//undo part three - shift.
		char smod[] = new char[sin.length()];
		for(int i = 0; i<sin.length(); i++){
			smod[i] = sin.charAt(i);
		}
		for(int i = 0; i<smod.length; i++){
		int f = (int)smod[i];
		f -= pthree;
		smod[i] = (char)f;
		}
		sout = "";
		for(int i = 0; i<smod.length; i++){
			sin += smod[i];
		}
	
	return sout;
}


}