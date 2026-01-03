import java.util.Scanner;

public class AnimalFarm {
    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);

        Animal animals[] = new Animal[10];

        int animalsArrayLength = 0;

        while(true) {
            System.out.println(
                "Press '1' to view all animals.\n" +
                "Press '2' to add a new animal.\n" + 
                "Press '0' to exit.\n"             
            );

            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {
                for(int i = 0; i < animals.length; i++) {
                    System.out.println(animals[i]);
                }
            } 
            else if(userAction.equals("2")) {
                if(animalsArrayLength == 10) {
                    System.out.println("10 animals already added. Cannot add more animals.");
                    continue;
                }

                System.out.println(
                    "Press '1' to add a Dog.\n" +
                    "Press '2' to add a Cat.\n" +
                    "Press '3' to add a Cow.\n"
                );

                String animalChoice = scanner.nextLine();

                if(animalChoice.equals("1")){
                    System.out.println("Please enter Dog's name: ");
                    String dogName = scanner.nextLine();
                    Animal tempDog = new Dog(dogName);

                    System.out.println("What the dog eats?");
                    String dogFood = scanner.nextLine();
                    tempDog.setFood(dogFood);
                    
                    animals[animalsArrayLength++] = tempDog;
                }
                else if(animalChoice.equals("2")){
                    System.out.println("Please enter Cat's name: ");
                    String catName = scanner.nextLine();
                    Animal tempCat = new Cat(catName);

                    System.out.println("What the cat eats?");
                    String catFood = scanner.nextLine();
                    tempCat.setFood(catFood);
                    
                    animals[animalsArrayLength++] = tempCat;
                }
                else if(animalChoice.equals("3")){
                    System.out.println("Please enter Cow's name: ");
                    String cowName = scanner.nextLine();
                    Animal tempCow = new Cat(cowName);

                    System.out.println("What the cat eats?");
                    String cowFood = scanner.nextLine();
                    tempCow.setFood(cowFood);
                    
                    animals[animalsArrayLength++] = tempCow;
                }
            }
            else {
                break;
            }
        }
    }
}