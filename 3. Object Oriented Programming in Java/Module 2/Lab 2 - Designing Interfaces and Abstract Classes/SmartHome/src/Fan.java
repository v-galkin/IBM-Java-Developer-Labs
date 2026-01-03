class Fan implements Switchable, Adjustable {
    boolean isOn = false;
    int fanSpeed = 50;

    @Override 
    public void turnOn() {
        isOn = true;
        System.out.println("Fan is turned On.");
    }

    @Override 
    public void turnOff() {
        isOn = false;
        System.out.println("Fan is turned Off.");
    }

    @Override 
    public void increase() {
        if (fanSpeed < 100) {
            fanSpeed += 10;
            System.out.println("Fan speed is increased to " + fanSpeed + "%.");
        }
        else {
            System.out.println("Fan is already at maximum speed.");
        }
    }

    @Override
    public void decrease() {
        if (fanSpeed > 0) {
            fanSpeed -= 10;
            System.out.println("Fan speed is decreased to " + fanSpeed + "%.");
        }
        else {
            System.out.println("Fan is already at minimum speed.");
        }
    }
}