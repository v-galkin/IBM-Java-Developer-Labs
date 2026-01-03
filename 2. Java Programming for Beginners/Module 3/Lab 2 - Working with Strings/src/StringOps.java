public class StringOps {
    public static void main(String s[]) {
        /* --------------- First Lab ---------------*/
        /*
        String string_one = "Hello World";
        System.out.println(string_one);

        String string_two = new String("Hello World");
        System.out.println(string_two);

        String string_three = "Hello World";

        System.out.println("S_1 and S_2 comparison: " + (string_one == string_two));

        System.out.println("S_2 and S_3 comparison: " + (string_two == string_three));

        System.out.println("S_1 and S_3 comparison: " + (string_one == string_three));
        */

        /* --------------- Second Lab ---------------*/
        /*
        String stringOne = "The quick brown fox jumped over the lazy dog";

        System.out.println("S_1 length: " + stringOne.length());

        char[] stringOneAsArray = stringOne.toCharArray();

        System.out.println(stringOneAsArray.length);

        System.out.println("The first char of the string is: " + stringOneAsArray[0]);

        System.out.println("The last char of the string is: " + stringOneAsArray[stringOneAsArray.length - 1]);

        System.out.println("The index of 'T' is: " + stringOne.indexOf('T'));

        System.out.println("The index of 'g' is: " + stringOne.indexOf('g'));
        */

        /* --------------- Third Lab ---------------*/
        /*
        String stringOne = "Washington";
        String stringTwo = new String("Washington");
        String stringThree = "WASHINGTON";

        System.out.println("S_1 and S_2 comparison: " + stringOne.equals(stringTwo));
        System.out.println("S_2 and S_3 comparison: " + stringTwo.equals(stringThree));
        System.out.println("S_1 and S_3 comparison ignoring case: " + stringOne.equalsIgnoreCase(stringThree));

        System.out.println("S_1 in lowercase: " + stringOne.toLowerCase());
        System.out.println("S_3 in lowercase: " + stringThree.toLowerCase());

        System.out.println("S_1 and S_3 comparison in lowercase: " + stringOne.toLowerCase().equals(stringThree.toLowerCase()));

        System.out.println("S_1 in uppercase: " + stringOne.toUpperCase());
        System.out.println("S_3 in uppercase: " + stringThree.toUpperCase());

        String stringFour = "50F1A";
        System.out.println("S_4 in lowercase: " + stringFour.toLowerCase());

        String regexString = "^W.*";
        System.out.println("S_1 matches regex: " + stringOne.matches(regexString));
        System.out.println("S_3 matches regex: " + stringThree.matches(regexString));

        String stringFive = "     WASHINGTON          ";
        System.out.println("S_3 and S_5 comparison: " + stringThree.equals(stringFive));
        stringFive = stringFive.strip();
        System.out.println("Equality check after stripping S_3 and S_5 - "+stringThree.equals(stringFive));
        */

        /* --------------- Fourth Lab ---------------*/
        /*
        String stringOne = "Washington";
        String stringTwo = " DC";

        stringOne = stringOne.concat(stringTwo);
        System.out.println("S_1: " + stringOne);

        stringOne = stringOne.substring(0, 10);
        System.out.println("S_1: " + stringOne);

        System.out.println("S_1.substring(7,10): " + stringOne.substring(7, 10));
        System.out.println("S_1.substring(7): " + stringOne.substring(7));
        */

        /* --------------- Homework ---------------*/
        String stringOne = "Maple Tree";
        String stringTwo = "Maple Tree";
        System.out.println("S_1 and S_2 comparison: " + (stringOne == stringTwo));

        String stringThree = new String("Maple Tree");

        System.out.println("S_1 and S_3 comparison using '==': " + (stringOne == stringThree));
        System.out.println("S_1 and S_3 comparison using '.equals()': " + stringOne.equals(stringThree));

        String stringFour = stringOne.substring(0, 5);
        String stringFive = stringOne.substring(6);

        System.out.println("S_4: " + stringFour);
        System.out.println("S_5: " + stringFive);

        stringFour = stringFour.concat(" ").concat(stringFive);
        System.out.println("S_4 after using concat: " + stringFour);

        stringOne = stringOne.toLowerCase();
        System.out.println("S_1 after using '.toLowerCase()': " + stringOne);

        stringOne = stringOne.toUpperCase();
        System.out.println("S_1 after using '.toUpperCase()' " + stringOne);
    }
}