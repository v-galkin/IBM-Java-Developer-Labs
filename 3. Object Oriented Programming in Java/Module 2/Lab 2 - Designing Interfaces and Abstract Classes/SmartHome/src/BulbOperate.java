public class BulbOperate {
    public static void main(String s[]) {
        Switchable switchables[] = new Switchable[3];

        SmartBulb smartBulb = new SmartBulb();
        DimmableBulb dimmableBulb = new DimmableBulb();
        RegularBulb regularBulb = new RegularBulb();

        switchables[0] = smartBulb;
        switchables[1] = dimmableBulb;
        switchables[2] = regularBulb;

        for (int i = 0; i < switchables.length; i++) {
            switchables[i].turnOn();
            switchables[i].turnOff();
        }

        smartBulb.increase();

        ((Adjustable) switchables[1]).decrease(); 

        ((Connectable) switchables[0]).connect();
    }
}