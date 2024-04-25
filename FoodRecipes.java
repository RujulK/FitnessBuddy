import java.util.ArrayList;
import java.util.List;

public class FoodRecipes {
    private static List<Recipe> recipes = new ArrayList<>();

    static {
        recipes.add(new Recipe("Quinoa Salad with Chickpeas and Avocado", "Ingredients: Quinoa, chickpeas, avocado, cherry tomatoes, cucumber, red onion, lemon juice, olive oil, salt, pepper.", "Instructions: Cook quinoa, then mix with chickpeas, diced avocado, halved cherry tomatoes, diced cucumber, and thinly sliced red onion. Dress with lemon juice, olive oil, salt, and pepper."));
        recipes.add(new Recipe("Grilled Salmon with Asparagus", "Ingredients: Salmon fillets, asparagus, olive oil, lemon juice, garlic, salt, pepper.", "Instructions: Marinate salmon in olive oil, lemon juice, minced garlic, salt, and pepper. Grill salmon and asparagus until cooked through."));
        // Add other recipes here...
    }

    public static String suggestRecipe(String preference) {
        // Return a random recipe based on preference or dietary requirement
        int index = (int) (Math.random() * recipes.size());
        return recipes.get(index).toString();
    }

    private static class Recipe {
        private String name;
        private String ingredients;
        private String instructions;

        public Recipe(String name, String ingredients, String instructions) {
            this.name = name;
            this.ingredients = ingredients;
            this.instructions = instructions;
        }

        @Override
        public String toString() {
            return name + "\n" + ingredients + "\n" + instructions;
        }
    }
}
