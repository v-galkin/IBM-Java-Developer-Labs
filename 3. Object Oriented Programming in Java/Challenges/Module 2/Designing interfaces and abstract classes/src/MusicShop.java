package src;
// Step 7: Create a public class MusicShop to test the classes
// This should include:
// - main method that:
//   1. Creates an array of Instrument objects including Guitar and Piano instances
//   2. Iterates through the array calling play() for each instrument
//   3. Demonstrates polymorphism by testing if each instrument is Tunable or Maintainable
//      and if so, calls the appropriate methods

import src.instruments.Guitar;
import src.instruments.Piano;

public class MusicShop {
    public static void main(String s[]) {
        Guitar electricGuitar = new Guitar("Fender Strat", 2021, 6, "Electric");
        Piano grandPiano = new Piano("Steinway Model D", 2021, 88, true);
        Piano uprightPiano = new Piano("Yamaha U1", 2018, 88, false);


        System.out.println(electricGuitar.play());
        System.out.println(grandPiano.play());
        System.out.println(uprightPiano.play());
    }
}