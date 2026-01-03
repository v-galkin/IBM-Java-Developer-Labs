public class ArrayAccess {
    public static void main(String s[]) {
        /*int[] years = {2020, 2021, 2022, 2023, 2024, 2025};*/
        /*int[] years = new int[6];
        years[1] = 2021;
        years[3] = 2023;
        System.out.println(years[0]);
        System.out.println(years[1]);
        System.out.println(years[2]);
        System.out.println(years[3]);
        System.out.println(years[4]);
        System.out.println(years[5]);
        */

        /* 
        int[] years = new int[6];
        years[0] = 2020;
        years[1] = 2021;
        years[2] = 2022;
        years[3] = 2023;
        years[4] = 2024;
        years[5] = 2025;

        int count_years = years.length;

        for (int i = 0; i <count_years; ++i) {
            System.out.println(years[i]);
        }
        */

        /* 
        int num_args = s.length;

        System.out.println("The length of the array is " + num_args);

        for (int i = 0; i < num_args; ++i){
            System.out.println(s[i]);
        }
        */ 

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        /* 
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
        System.out.println(numbers[3]);
        System.out.println(numbers[4]);
        System.out.println(numbers[5]);
        System.out.println(numbers[6]);
        System.out.println(numbers[7]);
        System.out.println(numbers[8]);
        System.out.println(numbers[9]);
        */

        /*
        for (int i = 0; i < numbers.length; ++i) {
            System.out.println(numbers[i]);
        }
        */

        /* 
        for (int number : numbers) {
            System.out.println(number);
        }
        */

        String string = "Hello";

        char[] characters = string.toCharArray();

        for (char character : characters) {
            System.out.println(character);
        }
    }
}