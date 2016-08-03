/**
 * InputProblem.java :: Code Listing 2-30
 * This program has a problem reading input.
 *
 * 2016 Aug 02
 */

import java.util.Scanner;

public class InputProblem
{
    public static void main(String[] args)
    {
        String name;    // to hold the user's name
        int age;        // to hold the user's age
        double income;  // to hold the user's income

        // Create a scanner object to read input
        Scanner keyboard = new Scanner(System.in);

        // Get the user's age, income and name
        System.out.println("What is your age? ");
        age = keyboard.nextInt();

        System.out.println("What is your annual income? ");
        income = keyboard.nextDouble();

        // when compiled and run, these two lines will APPEAR not to execute
        System.out.println("What is your name? ");
        name = keyboard.nextLine();

        // Display the information back to the user
        System.out.println("Hello, " + name + ". Your age is "
                           + age + " and your income is $" +
                           income);
    }
}
