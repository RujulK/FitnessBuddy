import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RecipeChooser {
    private static final String URL = "jdbc:mysql://localhost:3306/fb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "N@ruto2580";

    public static void main(String[] args) {
        displayRecipes();
        chooseRecipe();
    }

    private static void displayRecipes() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Retrieve recipes from the database
            String query = "SELECT name FROM recipes";
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery();

            // Display the recipes to the user
            System.out.println("Choose a recipe to cook:");
            int option = 1;
            while (resultSet.next()) {
                String recipeName = resultSet.getString("name");
                System.out.println(option + ". " + recipeName);
                option++;
            }

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: Failed to retrieve recipes from the database.");
            e.printStackTrace();
        }
    }

    private static void chooseRecipe() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of the recipe you want to cook: ");
            int chosenOption = scanner.nextInt();

            // Retrieve the chosen recipe name
            String chosenRecipe = getRecipeName(connection, chosenOption);
            if (chosenRecipe != null) {
                System.out.println("You chose to cook: " + chosenRecipe);

                // Retrieve and display ingredients and instructions for the chosen recipe
                displayRecipeDetails(connection, chosenRecipe);
            } else {
                System.out.println("Invalid recipe option.");
            }

            scanner.close();
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    private static String getRecipeName(Connection connection, int option) throws SQLException {
        String query = "SELECT name FROM recipes LIMIT ?, 1";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, option - 1); // Adjust index for SQL's 0-based indexing
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ? resultSet.getString("name") : null;
    }

    private static void displayRecipeDetails(Connection connection, String recipeName) throws SQLException {
        String queryDetails = "SELECT ingredients, instructions FROM recipes WHERE name = ?";
        PreparedStatement statementDetails = connection.prepareStatement(queryDetails);
        statementDetails.setString(1, recipeName);
        ResultSet resultSetDetails = statementDetails.executeQuery();

        if (resultSetDetails.next()) {
            String ingredients = resultSetDetails.getString("ingredients");
            String instructions = resultSetDetails.getString("instructions");
            System.out.println("Ingredients: " + ingredients);
            System.out.println("Instructions: " + instructions);
        } else {
            System.out.println("Recipe details not found.");
        }

        resultSetDetails.close();
        statementDetails.close();
    }

    public static void chooseRecipes() {
    }
}
