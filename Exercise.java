public class Exercise {
    // Other fields and methods...

    public boolean isSuitableForGoal(String goal) {
        // Convert the goal to lowercase for case-insensitive comparison
        String lowerCaseGoal = goal.toLowerCase();

        // Check if the exercise type aligns with the user's goal
        switch (lowerCaseGoal) {
            case "lose weight":
                // Example: Cardiovascular exercises are suitable for weight loss
                return isCardioExercise();
            case "build muscle":
                // Example: Resistance training exercises are suitable for muscle building
                return isResistanceExercise();
            // Add more cases for other goals
            default:
                // If the goal is not recognized, return false
                return false;
        }
    }

    // Example methods to check the type of exercise
    private boolean isCardioExercise() {
        // Implement logic to determine if the exercise is cardiovascular
        // For demonstration, always return true
        return true;
    }

    private boolean isResistanceExercise() {
        // Implement logic to determine if the exercise is resistance training
        // For demonstration, always return true
        return true;
    }
}