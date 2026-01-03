class SmartSpeaker implements Switchable, Connectable, Volume {
    boolean isOn = false;
    boolean isConnected = false;
    int volume = 50;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("SmartSpeaker is turned On.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("SmartSpeaker is turned Off.");
    }

    @Override 
    public void connect() {
        isConnected = true;
        System.out.println("SmartSpeaker is connected to the network.");
    }

    @Override 
    public void disconnect() {
        isConnected = false;
        System.out.println("SmartSpeaker is disconnected from the network.");
    }

    @Override
    public void increaseVolume() {
        if (volume < 100) {
            volume += 10;
            System.out.println("Volume is increased to " + volume + "%.");
        }
        else {
            System.out.println("Volume is already at maximum value.");
        }
    }

    public void decreaseVolume() {
        if(volume > 0) {
            volume -= 10;
            System.out.println("Volume is decreased to " + volume + "%.");
        }
        else {
            System.out.println("Volume is already at minimum value.");
        }
    }
}