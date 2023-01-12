package Cpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopyEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long beforeTime =System.currentTimeMillis();
		File src = new File("C:\\Users\\tj-bu-11\\Desktop\\123.jpg");
		File dest = new File("C:\\Users\\tj-bu-11\\Desktop\\img.jpg");
		int c;
		try {
			FileInputStream fr = new FileInputStream(src);
			FileOutputStream fw = new FileOutputStream(dest);
			byte [] buf = new byte[1024*10];
//			while((c = fr.read()) != -1) {  // 
//				fw.write((byte)c);          //
//			}       //버퍼 없이 복사 타입
			while(true) {
				int n = fr.read(buf);
				fw.write(buf,0,n);
				if(n < buf.length) {
					break;
				}
				
			}
			fr.close();
			fw.close();
			long afterTime =System.currentTimeMillis();
			double secDifftime = (double)(afterTime - beforeTime)/1000;
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다");
			System.out.println("버퍼 시간(m) >>" + secDifftime);
		}catch(IOException e) {
			System.out.println("파일 복사 오류");
		}
		
	}
		
		
	}

