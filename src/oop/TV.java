package oop;

/**
 * <p><b>TV</b> 모델의 간단한 구현 클래스입니다. 전원, 채널(1~87), 볼륨(0~100)을 관리하며
 * 채널/볼륨 증감 및 전원 on/off 기능을 제공합니다.</p>
 *
 * <h2>사용 예</h2>
 * <pre>{@code
 * TV tv = new TV(false, 7, 10);
 * tv.powerON();         // 전원 켜기
 * tv.channelUp();       // 채널 +1 (상한: 87)
 * tv.volumeDown();      // 볼륨 -1 (하한: 0)
 * }</pre>
 *
 * <p><b>불변식/제약</b></p>
 * <ul>
 *   <li>채널 범위: 1 ~ 87</li>
 *   <li>볼륨 범위: 0 ~ 100</li>
 *   <li>증감/설정 동작은 전원이 켜져 있을 때만 수행됩니다(메시지 출력 후 무시).</li>
 * </ul>
 *
 * @author 심현우
 * @version 1.0
 */
public class TV {

    /**
     * 전원 상태. {@code true}면 켜짐, {@code false}면 꺼짐.
     */
    private boolean power;

    /**
     * 현재 채널 번호(1~87).
     */
    private int channel;

    /**
     * 현재 볼륨(0~100).
     */
    private int volume;

    /**
     * 주어진 초기 상태로 TV를 생성합니다.
     *
     * @param power   초기 전원 상태
     * @param channel 초기 채널 (유효 범위 1~87)
     * @param volume  초기 볼륨 (유효 범위 0~100)
     */
    public TV(boolean power, int channel, int volume) {
        this.power = power;
        this.channel = channel;
        this.volume = volume;
    }

    /**
     * 전원 상태를 반환합니다.
     *
     * @return {@code true} 전원 켜짐, {@code false} 전원 꺼짐
     */
    public boolean isPower() {
        return power;
    }

    /**
     * 전원 상태를 설정합니다.
     *
     * @param power {@code true}로 설정하면 켜짐, {@code false}로 설정하면 꺼짐
     */
    public void setPower(boolean power) {
        this.power = power;
    }

    /**
     * 현재 채널을 반환합니다.
     *
     * @return 채널 번호(1~87)
     */
    public int getChannel() {
        return channel;
    }

    /**
     * 채널을 설정합니다. 유효 범위(1~87)를 벗어나면 설정하지 않고 경고 메시지를 출력합니다.
     *
     * @param channel 설정할 채널(1~87)
     */
    public void setChannel(int channel) {
        if (1 <= channel && channel <= 87) {
            this.channel = channel;
        } else {
            System.out.println("올바른 채널이 아닙니다.");
        }
    }

    /**
     * 현재 볼륨을 반환합니다.
     *
     * @return 볼륨 값(0~100)
     */
    public int getVolume() {
        return volume;
    }

    /**
     * 볼륨을 설정합니다. <b>주의:</b> 현재 구현은 1~100 범위만 허용하며(0 미포함),
     * 범위를 벗어나면 설정하지 않고 경고 메시지를 출력합니다.
     *
     * <p>하한(0)을 허용하려면 조건식을 {@code 0 <= volume && volume <= 100}으로 수정하세요.</p>
     *
     * @param volume 설정할 볼륨 값(현재 구현 기준 1~100)
     */
    public void setVolume(int volume) {
        if (1 <= volume && volume <= 100) {
            this.volume = volume;
        } else {
            System.out.println("올바른 볼륨이 아닙니다.");
        }
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "TV{" +
                "power=" + power +
                ", channel=" + channel +
                ", volume=" + volume +
                '}';
    }

    /**
     * 전원을 켭니다. 이미 켜져 있으면 상태만 유지하고 메시지를 출력합니다.
     */
    public void powerON() {
        System.out.println("전원을 켭니다.");
        power = true;
    }

    /**
     * 전원을 끕니다. 이미 꺼져 있으면 상태만 유지하고 메시지를 출력합니다.
     */
    public void powerOff() {
        System.out.println("전원을 끕니다.");
        power = false;
    }

    /**
     * 채널을 1 증가시킵니다. 전원이 꺼져 있으면 경고만 출력합니다.
     * 상한(87)에 도달하면 더 증가하지 않습니다.
     */
    public void channelUp() {
        if (!power) {
            System.out.println("전원을 먼저 켜야 합니다.");
        } else if (channel == 87) {
            System.out.println("더 이상 채널이 없습니다.");
        } else {
            channel++;
        }
    }

    /**
     * 채널을 1 감소시킵니다. 전원이 꺼져 있으면 경고만 출력합니다.
     * 하한(1)에 도달하면 더 감소하지 않습니다.
     */
    public void channelDown() {
        if (!power) {
            System.out.println("전원을 먼저 켜야 합니다.");
        } else if (channel == 1) {
            System.out.println("더 이상 채널이 없습니다.");
        } else {
            channel--;
        }
    }

    /**
     * 볼륨을 1 증가시킵니다. 전원이 꺼져 있으면 경고만 출력합니다.
     * 상한(100)에 도달하면 더 증가하지 않습니다.
     */
    public void volumeUp() {
        if (!power) {
            System.out.println("전원을 먼저 켜야 합니다.");
        } else if (volume == 100) {
            System.out.println("볼륨이 최대치 입니다.");
        } else {
            volume++;
        }
    }

    /**
     * 볼륨을 1 감소시킵니다. 전원이 꺼져 있으면 경고만 출력합니다.
     * 하한(0)에 도달하면 더 감소하지 않습니다.
     */
    public void volumeDown() {
        if (!power) {
            System.out.println("전원을 먼저 켜야 합니다.");
        } else if (volume == 0) {
            System.out.println("볼륨이 최소치 입니다.");
        } else {
            volume--;
        }
    }
}
