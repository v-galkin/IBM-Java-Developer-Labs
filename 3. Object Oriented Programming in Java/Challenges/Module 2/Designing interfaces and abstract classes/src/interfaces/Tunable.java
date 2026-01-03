package src.interfaces;
// Step 2: Create an interface Tunable
// This should include:
// - abstract method tune() that returns a String
// - abstract method adjustPitch(boolean up) that returns a String (up means increase pitch)

public interface Tunable {
    String tune();
    String adjustPitch(boolean up);
}