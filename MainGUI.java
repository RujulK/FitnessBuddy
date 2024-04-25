import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MainGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField heightField;
    private JTextField weightField;
    private JTextArea resultArea;

    private User user;

    public MainGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Exercise and Recipe App");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Height (m):"));
        heightField = new JTextField();
        panel.add(heightField);

        panel.add(new JLabel("Weight (kg):"));
        weightField = new JTextField();
        panel.add(weightField);

        JButton loginButton = new JButton("Login/Register");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        panel.add(loginButton);

        resultArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void loginUser() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        double height = Double.parseDouble(heightField.getText());
        double weight = Double.parseDouble(weightField.getText());

        user = new User(name, age, height, weight);

        // Calculate BMI
        double bmi = BMIUtil.calculateBMI(user.getHeight(), user.getWeight());
        resultArea.append("Your BMI is: " + bmi + "\n");

        // Suggest exercises
        String exerciseSuggestion = ExerciseSuggestor.suggestExercise((int) bmi);
        resultArea.append("Exercise suggestion: " + exerciseSuggestion + "\n");

        // Display recipe names
        List<String> recipeNames;
        try {
            recipeNames = DatabaseManager.getRecipeNames();
            resultArea.append("\nRecipes:\n");
            for (String recipeName : recipeNames) {
                resultArea.append(recipeName + "\n");
            }
        } catch (SQLException ex) {
            resultArea.append("Error retrieving recipes.\n");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainGUI();
            }
        });
    }
}
