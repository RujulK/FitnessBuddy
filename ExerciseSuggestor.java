import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ExerciseSuggestor {
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/fb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "N@ruto2580";

    public static String suggestExercise(int choice) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT instructions FROM exercises WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, choice);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String exerciseInstructions = resultSet.getString("instructions");
                return exerciseInstructions;
            } else {
                return "No instructions found for the selected exercise.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: Failed to suggest exercise.";
        }
    }



    // Helper method to determine BMI category
    private static String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static String getAdditionalExercises() {
        StringBuilder additionalExercises = new StringBuilder();
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT name FROM exercises";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int count = 1;
            while (resultSet.next()) {
                String exerciseName = resultSet.getString("name");
                additionalExercises.append(count).append(". ").append(exerciseName).append("\n");
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: Failed to retrieve additional exercises.";
        }
        return additionalExercises.toString();
    }

}
