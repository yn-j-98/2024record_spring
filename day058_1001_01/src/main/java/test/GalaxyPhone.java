package test;

import java.util.Random;

public class GalaxyPhone implements Phone {
	private Watch watch;
	private int num;
	
	public GalaxyPhone() {
		this.num = new Random().nextInt(100);
		System.out.println("갤럭시 객체 생성 01");
	}
	public GalaxyPhone(Watch watch) {
		this.watch=watch;
		System.out.println("갤럭시 객체 생성 02");
	}
	
	public GalaxyPhone(Watch watch, int num) {
		this.watch=watch;
		this.num=num;
		System.out.println("갤럭시 객체 생성 03");
	}

	@Override
	public void powerOn() {
		this.watch.powerOn();
		System.out.println("num = "+this.num);	
	}

	@Override
	public void powerOff() {
		this.watch.powerOff();
		System.out.println("갤럭시 전원 OFF");	
	}
	
	

}
