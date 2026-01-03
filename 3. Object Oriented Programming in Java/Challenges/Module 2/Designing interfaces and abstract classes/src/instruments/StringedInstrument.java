package src.instruments;
// Step 4: Create a concrete class StringedInstrument that extends Instrument
// This should include:
// - private int numberOfStrings
// - constructor that initializes name, year, and numberOfStrings
// - implementation of the abstract play() method
// - override getInstrumentDetails() to include number of strings

public class StringedInstrument extends Instrument {
    private int numberOfStrings = 0;

    public StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year);
        this.numberOfStrings = numberOfStrings;
    }

    public String play() {
        return "Playing on the instrument: " + getInstrumentDetails();
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", with " + numberOfStrings + " number of strings.";
    }
}