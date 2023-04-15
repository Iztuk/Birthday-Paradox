import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BirthdayParadox birthdayParadox = new BirthdayParadox();

        System.out.println("How many birthdays shall I generate? (Max 100)");
        int birthdayCount = input.nextInt();
        if(birthdayCount > 100){
            System.out.println("Invalid input. Please enter a valid number.");
        } else {
            // Process the user input.
        }

        // Assigns values to the array birthdays from birthdayParadox.getBirthdays().
        String[] birthdays = birthdayParadox.getBirthdays(birthdayCount);

        System.out.println("Here are " + birthdayCount + " birthdays: \n" + Arrays.toString(birthdays));
        System.out.println("\nIn this simulation, multiple people have a birthday on " + birthdayParadox.getMostCommonBirthday(birthdays));

        System.out.println("Generating " + birthdayCount + " random birthdays 100,000 times...");
        input.nextLine();

        // Calculate the probability
        double probability = birthdayParadox.birthdayProbability(100000, birthdayCount);
        System.out.println("Out of 100,000 simulations of " + birthdayCount + ", there was a\nmatching birthday in that group " + probability * 1000 + " times.");
        System.out.println("This means that " + birthdayCount + " people have a " + probability + "% chance of having a matching birthday in their group.");
    }
}