package Apackage;

public abstract class TV {
	private boolean power = false;
	private int channel;
	private int sound;

	TV() {
		this.channel = 1;
		this.sound = 1;
	}

	TV(int channel, int sound) {
		this.channel = channel;
		this.sound = sound;
	}

	public boolean isPower() {
		return power;
	}

	public int getChannel() {
		return channel;
	}

	public int getSound() {
		return sound;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public void setSound(int sound) {
		this.sound = sound;
	}

	public void powerOnOff() {
		if (this.power == true) {
			this.power = false;
			System.out.println("전원이 꺼졌습니다");
		} else {
			this.power = true;
			System.out.println("전원이 켜졌습니다");
		}
	}

	public void channelUp() {
		this.channel += 1;
		System.out.println("채널 " + this.channel + "로 변경됨");
	}

	public void channelUp(int a) {
		this.channel = a;
		System.out.println("채널 " + this.channel + "로 변경됨");
	}

	public void channelDown() {
		if (this.channel > 0) {
			this.channel -= 1;
			System.out.println("채널 " + this.channel + "로 변경됨");
		} else {
			System.out.println("채널 " + this.channel + "로 변경됨");
		}
	}

	public void channelDown(int a) {
		this.channel = a;
		System.out.println("채널 " + this.channel + "로 변경됨");
	}

	public void soundUp() {
		this.sound += 1;
		System.out.println("현재 음량은 " + this.sound);
	}

	public void soundDown() {
		if (this.sound > 0) {
			this.sound -= 1;
			System.out.println("현재 음량은 " + this.sound);
		} else {
			System.out.println("현재 음량은 " + this.sound);
		}
	}

	abstract public void channelRemove();
}

class IPTV extends TV {
	private String ip;

	IPTV(int channel, int sound, String ip) {
		super(channel, sound);
		this.ip = ip;
	}

	IPTV(String ip) {
		this.ip = ip;
	}

	public void ipChange(String ip) {
		this.ip = ip;
	}

	@Override
	public void channelRemove() {
		// TODO Auto-generated method stub
		System.out.println(getChannel() + "채널을 삭제 했습니다");
		setChannel(0);
	}

}
