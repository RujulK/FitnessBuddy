import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/FB";
    private static final String USERNAME = "your database username";
    private static final String PASSWORD = "your database password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void saveUserData(User user) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO users (username, password, name, age, height, weight) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setInt(4, user.getAge());
            statement.setDouble(5, user.getHeight());
            statement.setDouble(6, user.getWeight());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: Failed to save user data to the database.");
            e.printStackTrace();
        }
    }

    public static User getUserByUsername(String username) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double height = resultSet.getDouble("height");
                double weight = resultSet.getDouble("weight");
                return new User(username, password, name, age, height, weight);
            }
        } catch (SQLException e) {
            System.out.println("Error: Failed to retrieve user data from the database.");
            e.printStackTrace();
        }
        return null;
    }

    public static void saveDailyExercise(String username, String exerciseDetails) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO daily_exercises (username, exercise_details) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, exerciseDetails);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: Failed to save daily exercise data to the database.");
            e.printStackTrace();
        }
    }

    public static List<String> getRecipeNames() throws SQLException {
        List<String> recipeNames = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT name FROM recipes");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                recipeNames.add(resultSet.getString("name"));
            }
        }
        return recipeNames;
    }

    public static String getRecipeIngredients(String recipeName) throws SQLException {
        String ingredients = "";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT ingredients FROM recipes WHERE name = ?")) {
            statement.setString(1, recipeName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ingredients = resultSet.getString("ingredients");
            }
        }
        return ingredients;
    }

    public static void saveDailyFoodIntake(String username, String foodIntakeDetails) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO daily_food_intake (username, food_intake_details) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, foodIntakeDetails);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: Failed to save daily food intake data to the database.");
            e.printStackTrace();
        }
    }

    public static String getHealthCheckupReminder(String username) {
        try (Connection connection = getConnection()) {
            String query = "SELECT reminder_date FROM health_checkup_reminder WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                LocalDate reminderDate = resultSet.getDate("reminder_date").toLocalDate();
                return "Your next health checkup reminder is on: " + reminderDate.toString();
            }
        } catch (SQLException e) {
            System.out.println("Error: Failed to retrieve health checkup reminder from the database.");
            e.printStackTrace();
        }
        return "No health checkup reminder found.";
    }

    public static void updateUserData(User user) {
        String insertSQL = "INSERT INTO user_bmi (username, bmi, record_date) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setDouble(2, user.getBMI());
            preparedStatement.setDate(3, new java.sql.Date(new Date().getTime()));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("BMI record inserted successfully.");
            } else {
                System.out.println("Failed to insert BMI record.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while recording BMI: " + e.getMessage());
        }
    }

    public static String getRecipeInstructions(String recipeName) {
        String instructions = "";

        try (Connection connection = getConnection()) {
            String query = "SELECT instructions FROM recipes WHERE name = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, recipeName);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        instructions = resultSet.getString("instructions");
                    } else {
                        instructions = "Instructions for " + recipeName + " are not available.";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            instructions = "Error: Failed to retrieve instructions for " + recipeName + ".";
        }

        return instructions;
    }


}
