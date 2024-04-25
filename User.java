public class User {
    private String username;
    private String password;
    private String name;
    private int age;
    private double height;
    private double weight;
    private boolean newUser;

    public User(String username, String password, int age, double height, double weight) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.newUser = false; // Assuming newUser should default to false
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.newUser = false; // Assuming newUser should default to false
    }

    public User(String username, String password, boolean newUser) {
        this.username = username;
        this.password = password;
        this.newUser = newUser;
    }

    public User(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.newUser = false; // Assuming newUser should default to false
    }

    public User(Object username, Object password, boolean newUser) {
        // Constructor with generic objects not implemented
    }

    public User(Object name, int age, double height, double weight) {
        // Constructor with generic objects not implemented
    }

    public User(Object username, Object password, Object name, int age, double height, double weight) {

    }

    public static void registerUser(User newUser) {
        // Code to register the user in the database (implementation not provided here)
    }

    public static User authenticateUser(String username, String password) {
        // Code to authenticate the user (implementation not provided here)
        return null;
    }

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and setter for height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Getter and setter for weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getter and setter for newUser
    public boolean isNewUser() {
        return newUser;
    }

    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }

    // Method to calculate BMI
    public double getBMI() {
        // Calculate BMI using the formula: weight (kg) / (height (m) * height (m))
        return weight / (height * height);
    }

    // Additional methods here
}
