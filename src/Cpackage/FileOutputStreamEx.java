package Cpackage;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		FileOutputStream fout = new FileOutputStream ("C:\\Users\\tj-bu-11\\Desktop\\test12.out");
		
		byte b[] = {7,51,3,4,-1,24};
				
		for(int i = 0; i<b.length ; i++) {
			fout.write(b[i]);
		}
		fout.close();
	}

}
