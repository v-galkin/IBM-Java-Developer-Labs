
class SmartBulb implements Switchable, Adjustable, Connectable {
    private boolean isOn = false;
    private int brightness = 50;
    private boolean isConnected = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("SmartBulb is turned On.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("SmartBulb is turned Off.");
    }

    @Override
    public void increase() {
        if(brightness < 100) {
            brightness += 10;
            System.out.println("Brightness increase " + brightness + "%.");
        } 
        else {
            System.out.println("Brightness is already at maximum level.");
        }
    }

    @Override
    public void decrease() {
        if(brightness > 0) {
            brightness -= 10;
            System.out.println("Brightness decrease " + brightness + "%.");
        }
        else {
            System.out.println("Brightness is already at minimumm level.");
        }
    }

    @Override 
    public void connect() {
        isConnected = true;
        System.out.println("SmartBulb is connected to the network.");
    }

    @Override 
    public void disconnect() {
        isConnected = false;
        System.out.println("SmartBulb is disconnected from the network.");
    }

}

class DimmableBulb implements Switchable, Adjustable {
    private boolean isOn = false;
    private int brightness = 50;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("DimmableBulb is turned On.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("DimmableBuld is turned Off.");
    }

    @Override 
    public void increase() {
        if (brightness < 100) {
            brightness += 10;
            System.out.println("Brightness increased to " + brightness + "%.");
        }
    }

    @Override 
    public void decrease() {
        if(brightness > 0) {
            brightness -= 10;
            System.out.println("Brightness decreased to " + brightness + "%.");
        }
    }
}

class RegularBulb implements Switchable {
    boolean isOn = false;

    @Override 
    public void turnOn() {
        isOn = true;

        System.out.println("RegularBulb is turned On.");
    }

    @Override 
    public void turnOff() {
        isOn = false;

        System.out.println("RegularBulb is rutned Off.");
    }
}