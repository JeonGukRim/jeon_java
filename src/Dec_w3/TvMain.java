package Dec_w3;

class TV {
	private int size;
	TV(){}
	public TV(int size) {
		this.size = size;
	}

	protected int getSize() {
		return size;
	}
}


class ColorTV extends TV {
	int color;
	ColorTV(){}
	ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}
	public void printProperty() {
		System.out.println(getSize()+" 인치 " +this.color + " 컬러 ");
	}
}
class IPTV extends ColorTV{
	String ip;
	IPTV(String ip,int size, int color){
		super(size,color);
		this.ip = ip;
	}
	public void printProperty() {
		System.out.println("나의 IPTV는 "+ this.ip+ " "+getSize()+" 인치 " +this.color + " 컬러 ");
	}
}

public class TvMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
		
		IPTV iptv = new IPTV("192.168.1.1",32,1024);
		iptv.printProperty();
	}

}
