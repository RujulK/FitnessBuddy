import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class HealthCheckupReminder {
    private static final String URL = "jdbc:mysql://localhost:3306/fb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "N@ruto2580";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void setReminder(User user) {


        LocalDate reminderDate = LocalDate.now().plusMonths(1); // Set reminder for one month from now

        try (Connection connection = getConnection()) {
            String query = "INSERT INTO health_checkup_reminder (username, reminder_date) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setDate(2, java.sql.Date.valueOf(reminderDate));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
