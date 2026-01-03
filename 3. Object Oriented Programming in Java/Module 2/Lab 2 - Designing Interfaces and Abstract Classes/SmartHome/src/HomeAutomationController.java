public class HomeAutomationController {
    public static void main(String s[]) {
        SmartSpeaker smartSpeaker = new SmartSpeaker();
        Fan fan = new Fan();

        fan.turnOn();
        fan.turnOff();

        smartSpeaker.turnOn();
        smartSpeaker.turnOff();

        fan.increase();
        fan.decrease();


        smartSpeaker.connect();
        smartSpeaker.disconnect();
        smartSpeaker.increaseVolume();
        smartSpeaker.decreaseVolume();
    }
}