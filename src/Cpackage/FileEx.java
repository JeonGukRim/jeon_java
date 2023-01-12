package Cpackage;

import java.io.File;

public class FileEx {

	public static void listDirectory(File dir) {

		System.out.println("-----" + dir.getPath() + "의 서브 리스트 입니다.-----");
		File[] subFiles = dir.listFiles();  // 객체 즉 폴도에 하위에 있는 리스트 
		for (int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t파일 크기: " + f.length());
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n", t, t, t, t);
		}
	}

	public static void main(String[] args) {
		File f1 = new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
		String res = "";
		if (f1.isFile())
			res = "파일";
		else if (f1.isDirectory())
			res = "디렉토리";
		System.out.println(f1.getPath() + "은 " + res + "입니다.");
		File f2 = new File("c:\\Temp\\java_sample");
		if (!f2.exists()) {   //존재하는지 판단  !가 툽어서 존재하지 않을때 임;
			f2.mkdir(); // 존재하지 않으면 디렉토리 생성
		}
		listDirectory(new File("c:\\Temp"));
		f2.renameTo(new File("c:\\Temp\\javasample1"));
		listDirectory(new File("c:\\Temp"));
	}
}
