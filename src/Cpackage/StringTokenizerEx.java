package Cpackage;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer("13/2","+-*/",true); //있는 부호를 판단해줌 걸리면 기준으로 그기호 기준으로 분리;
		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
			System.out.println(Integer.parseInt(st.nextToken()));
		}
		
		
		
	}

}
