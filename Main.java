import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login or register
        User user = null;
        while (user == null) {
            System.out.println("Do you want to login or register? (login/register)");
            String loginChoice = scanner.nextLine(); // Renamed choice variable
            if (loginChoice.equalsIgnoreCase("login")) {
                user = login(scanner);
            } else if (loginChoice.equalsIgnoreCase("register")) {
                user = register(scanner);
            } else {
                System.out.println("Invalid choice. Please enter 'login' or 'register'.");
            }
        }

        // Save user data to the database if registering for the first time
        if (user.isNewUser()) {
            collectUserData(scanner, user);
            try {
                DatabaseManager.saveUserData(user);
            } catch (Exception e) {
                System.out.println("An error occurred while saving user data. Please try again later.");
                e.printStackTrace();
                scanner.close();
                return;
            }
        }

        // Calculate BMI
        double bmi = BMIUtil.calculateBMI(user.getHeight(), user.getWeight());
        System.out.println("Your BMI is: " + bmi);

        // Suggest exercises
        String exerciseSuggestion = ExerciseSuggestor.suggestExercise((int) bmi);
        System.out.println("Exercise suggestion: " + exerciseSuggestion);

        // Provide exercise options to the user
        System.out.println("Would you like to do the suggested exercise? (yes/no)");
        String exerciseChoice = scanner.nextLine(); // Renamed choice variable
        if (exerciseChoice.equalsIgnoreCase("yes")) {
            System.out.println("Great! Here are the exercise instructions:");
            // Display exercise instructions from the suggestion
            System.out.println(exerciseSuggestion);
        } else {
            System.out.println("No problem! Here are some other exercise options:");
            // Get additional exercise options from ExerciseSuggestor
            String additionalExercises = ExerciseSuggestor.getAdditionalExercises();
            System.out.println(additionalExercises);
        }

        System.out.println("Choose an exercise:");
        System.out.println("1. Push-up");
        System.out.println("2. Squat");
        System.out.println("3. Deadlift");
        System.out.println("4. Lunges");
        System.out.println("5. Pull-up");
        System.out.println("6. Plank");
        System.out.println("7. Bicycle Crunches");
        System.out.println("8. Burpees");
        System.out.println("9. Russian Twists");
        System.out.println("10. Dumbbell Shoulder Press");
        System.out.print("Enter your choice (1-10): ");

        int userChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String instructions = ExerciseSuggestor.suggestExercise(userChoice);
        System.out.println("Exercise instructions:\n" + instructions);

        // After displaying exercise instructions, prompt the user to choose a recipe
        System.out.println("Would you like to cook a recipe? (yes/no)");
        String recipeChoice = scanner.nextLine();

        if (recipeChoice.equalsIgnoreCase("yes")) {
            // Retrieve recipe names from the database
            List<String> recipeNames = null;
            try {
                recipeNames = DatabaseManager.getRecipeNames();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Display recipe names to the user
            System.out.println("Choose a recipe to cook:");
            for (int i = 0; i < recipeNames.size(); i++) {
                System.out.println((i + 1) + ". " + recipeNames.get(i));
            }

            // Get user's recipe choice
            System.out.print("Enter your choice (1-" + recipeNames.size() + "): ");
            int recipeIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Retrieve ingredients and instructions for the chosen recipe
            String chosenRecipe = recipeNames.get(recipeIndex - 1);
            String recipeIngredients = null;
            try {
                recipeIngredients = DatabaseManager.getRecipeIngredients(chosenRecipe);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String recipeInstructions = DatabaseManager.getRecipeInstructions(chosenRecipe);

            // Display ingredients and instructions to the user
            System.out.println("Ingredients for " + chosenRecipe + ":");
            System.out.println(recipeIngredients);
            System.out.println("Instructions for " + chosenRecipe + ":");
            System.out.println(recipeInstructions);
        } else {
            System.out.println("No problem! Happy exercising!");
        }

    }

    private static void collectUserData(Scanner scanner, User user) {
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        user.setName(name);

        int age = 0;
        while (age <= 0) {
            try {
                System.out.println("Please enter your age:");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    System.out.println("Age must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Age must be a number.");
            }
        }
        user.setAge(age);

        double height = 0;
        while (height <= 0) {
            try {
                System.out.println("Please enter your height (in meters):");
                height = Double.parseDouble(scanner.nextLine());
                if (height <= 0) {
                    System.out.println("Height must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Height must be a number.");
            }
        }
        user.setHeight(height);

        double weight = 0;
        while (weight <= 0) {
            try {
                System.out.println("Please enter your weight (in kilograms):");
                weight = Double.parseDouble(scanner.nextLine());
                if (weight <= 0) {
                    System.out.println("Weight must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Weight must be a number.");
            }
        }
        user.setWeight(weight);
    }

    private static User register(Scanner scanner) {
        System.out.println("Enter a username:");
        String username = scanner.nextLine();
        System.out.println("Enter a password:");
        String password = scanner.nextLine();
        return new User(username, password, true); // Marking as a new user
    }

    private static User login(Scanner scanner) {
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        return new User(username, password);
    }

}
