package oop;

public class TVRunner {

    // 멤버(인스턴스) 변수

    public static void main(String[] args) {

        TV tv1 = new TV(false,1, 20); // 지역변수

        tv1.powerON();
        tv1.volumeUp();
        System.out.println(tv1);

        tv1.powerOff();
        tv1.setVolume(3);
        tv1.setChannel(7);
        System.out.println(tv1);

    }

}
