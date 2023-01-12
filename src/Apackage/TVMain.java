package Apackage;

public class TVMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IPTV iptv1 = new IPTV(7,1,"192.168.1.1");
		IPTV iptv2 = new IPTV("192.168.1.1");
		
		iptv1.powerOnOff();
		iptv1.channelUp();
		iptv1.channelDown();
		iptv1.soundUp();
		iptv1.soundDown();
		iptv1.soundDown();
		iptv1.soundDown();
		iptv1.soundDown();
		iptv1.channelRemove();
		System.out.println(iptv1.getChannel());
		iptv1.channelUp(2);
//		iptv1.powerOnOff();
//		iptv1.powerOnOff();
//		System.out.println(iptv2.getChannel());
		
		
		
	}

}
