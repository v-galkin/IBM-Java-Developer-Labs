package src.instruments;

import src.interfaces.Tunable;
import src.interfaces.Maintainable;

// Step 5: Create a concrete class Guitar that extends StringedInstrument 
// and implements Tunable and Maintainable
// This should include:
// - private String guitarType (acoustic, electric, etc.)
// - constructor that initializes all fields
// - implementation of all required interface methods

public class Guitar extends StringedInstrument implements Tunable, Maintainable {
    private String guitarType;

    public Guitar(String name, int year, int numberOfStrings, String guitarType) {
        super(name, year, numberOfStrings);
        this.guitarType = guitarType;
    }   
    
    public String play() {
        return "Playing on " + guitarType + " guitar " + getInstrumentDetails();
    }

    @Override
    public String tune() {
        return "Tuning the " + guitarType + " guitar.";
    }

    @Override
    public String adjustPitch(boolean up) {
        if (up) {
            return "Raising the pitch of " + guitarType + " guitar.";
        } else {
            return "Lowering the  of " + guitarType + " guitar.";
        }
    }

    @Override 
    public String clean() {
        return "Clearning " + guitarType + " guitar.";
    }

    @Override 
    public String inspect() {
        return "Inspecting " + guitarType + " guitar.";
    }

}