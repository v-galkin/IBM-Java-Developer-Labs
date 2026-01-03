package src.instruments;

import src.interfaces.Tunable;
import src.interfaces.Maintainable;

// Step 6: Create a concrete class Piano that extends Instrument
// and implements Tunable and Maintainable
// This should include:
// - private boolean isGrand
// - constructor that initializes all fields
// - implementation of the abstract play() method
// - implementation of all required interface methods

public class Piano extends StringedInstrument implements Tunable, Maintainable {
    private boolean isGrand;

    public Piano(String name, int year, int numberOfStrings, boolean isGrand) {
        super(name, year, numberOfStrings);
        this.isGrand = isGrand;
    }

    public String play() {
        if (isGrand) {
            return "Playing on grand piano " + getInstrumentDetails();
        } else {
            return "Playing on upright piano " + getInstrumentDetails();
        }
    }

    @Override 
    public String tune() {
        return "Tuning the piano";
    }

    @Override 
    public String adjustPitch(boolean up) {
        if (up) {
            return "Increasing pitch.";
        } else {
            return "Decreasing pitch.";
        }
    }

    @Override
    public String clean() {
        return "Cleaning the piano";
    }

    @Override
    public String inspect() {
        return "Inspecting the piano";
    }
}