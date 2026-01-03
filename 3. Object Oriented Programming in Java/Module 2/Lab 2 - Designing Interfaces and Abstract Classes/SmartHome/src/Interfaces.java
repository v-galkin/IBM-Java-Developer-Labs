interface Switchable {
    void turnOn();
    void turnOff();
}

interface Adjustable {
    void increase();
    void decrease();
}

interface Connectable {
    void connect();
    void disconnect();
}

interface Volume {
    void increaseVolume();
    void decreaseVolume();
}