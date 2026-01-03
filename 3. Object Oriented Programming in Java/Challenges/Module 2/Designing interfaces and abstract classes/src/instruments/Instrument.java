package src.instruments;
// Step 1: Create an abstract class Instrument
// This should include:
// - private String name
// - protected int year (year of manufacture)
// - constructor that initializes both fields
// - abstract method play() that returns a String
// - concrete method getInstrumentDetails() that returns information about the instrument

public abstract class Instrument {
    private String name;
    protected int year;

    public Instrument(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public abstract String play();

    public String getInstrumentDetails() {
        return "'" + this.name + "'" + ", made in " + this.year;
    }
}