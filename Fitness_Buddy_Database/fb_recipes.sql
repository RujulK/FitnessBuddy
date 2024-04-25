-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: fb
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `ingredients` text NOT NULL,
  `instructions` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'Grilled Chicken Salad','Chicken breast, lettuce, cherry tomatoes, cucumber, red onion, avocado, olive oil, balsamic vinegar, salt, pepper','1. Season chicken breast with salt and pepper and grill until cooked through. 2. Chop lettuce, cherry tomatoes, cucumber, red onion, and avocado. 3. Slice grilled chicken and add to the salad. 4. Drizzle with olive oil and balsamic vinegar. 5. Season with salt and pepper to taste.'),(2,'Vegetable Pasta Primavera','Pasta, bell peppers, zucchini, cherry tomatoes, broccoli, garlic, olive oil, Parmesan cheese, salt, pepper','1. Cook pasta according to package instructions and drain. 2. Heat olive oil in a large skillet over medium heat. 3. Add minced garlic and sauté until fragrant. 4. Add chopped bell peppers, zucchini, cherry tomatoes, and broccoli. 5. Cook until vegetables are tender. 6. Toss cooked pasta with the vegetable mixture. 7. Serve with grated Parmesan cheese.'),(3,'Mediterranean Quinoa Bowl','Quinoa, chickpeas, cucumber, cherry tomatoes, red onion, Kalamata olives, feta cheese, olive oil, lemon juice, dried oregano, salt, pepper','1. Cook quinoa according to package instructions and let it cool. 2. Rinse and drain chickpeas. 3. Chop cucumber, cherry tomatoes, red onion, and Kalamata olives. 4. In a large bowl, combine quinoa, chickpeas, vegetables, and crumbled feta cheese. 5. Drizzle with olive oil and lemon juice. 6. Season with dried oregano, salt, and pepper to taste.'),(4,'Spinach and Feta Stuffed Chicken Breast','Chicken breast, spinach, feta cheese, garlic, olive oil, salt, pepper','1. Preheat oven to 375°F (190°C). 2. Butterfly chicken breast and season with salt and pepper. 3. Sauté spinach and minced garlic in olive oil until wilted. 4. Stuff chicken breast with spinach and crumbled feta cheese. 5. Secure with toothpicks. 6. Place stuffed chicken breasts in a baking dish and bake for 25-30 minutes or until cooked through.'),(5,'Veggie Burger','Black beans, cooked quinoa, onion, garlic, bell pepper, breadcrumbs, egg, cumin, paprika, salt, pepper','1. Mash black beans in a large bowl. 2. Add cooked quinoa, finely chopped onion, minced garlic, diced bell pepper, breadcrumbs, beaten egg, cumin, paprika, salt, and pepper. 3. Mix until well combined. 4. Form mixture into patties and refrigerate for 30 minutes. 5. Heat olive oil in a skillet over medium heat. 6. Cook veggie burgers for 3-4 minutes per side or until golden brown. 7. Serve on buns with your favorite toppings.'),(6,'Teriyaki Salmon','Salmon fillets, soy sauce, brown sugar, garlic, ginger, sesame oil, green onions, sesame seeds','1. In a small saucepan, combine soy sauce, brown sugar, minced garlic, grated ginger, and sesame oil. 2. Bring to a simmer and cook until sauce thickens. 3. Preheat grill to medium-high heat. 4. Brush salmon fillets with teriyaki sauce. 5. Grill salmon for 4-5 minutes per side or until cooked through. 6. Garnish with sliced green onions and sesame seeds.'),(7,'Caprese Salad','Tomatoes, fresh mozzarella cheese, fresh basil leaves, balsamic glaze, olive oil, salt, pepper','1. Slice tomatoes and fresh mozzarella cheese. 2. Arrange tomato slices and mozzarella slices on a serving plate. 3. Tuck fresh basil leaves between tomato and mozzarella slices. 4. Drizzle with balsamic glaze and olive oil. 5. Season with salt and pepper to taste.'),(8,'Shrimp Scampi','Shrimp, linguine pasta, butter, garlic, white wine, lemon juice, parsley, salt, pepper','1. Cook linguine pasta according to package instructions and drain. 2. In a large skillet, melt butter over medium heat. 3. Add minced garlic and sauté until fragrant. 4. Add shrimp to the skillet and cook until pink. 5. Deglaze the pan with white wine and lemon juice. 6. Toss cooked pasta with shrimp and sauce. 7. Garnish with chopped parsley and season with salt and pepper.'),(9,'Greek Salad','Cucumber, tomatoes, red onion, Kalamata olives, feta cheese, olive oil, red wine vinegar, dried oregano, salt, pepper','1. Chop cucumber, tomatoes, red onion, and Kalamata olives. 2. Combine chopped vegetables in a large bowl. 3. Crumble feta cheese over the vegetables. 4. Drizzle with olive oil and red wine vinegar. 5. Sprinkle with dried oregano, salt, and pepper. 6. Toss to combine and serve.'),(10,'Stuffed Bell Peppers','Bell peppers, ground beef, rice, onion, garlic, tomato sauce, shredded cheese, Italian seasoning, salt, pepper','1. Preheat oven to 375°F (190°C). 2. Cut tops off bell peppers and remove seeds and membranes. 3. Cook rice according to package instructions and set aside. 4. In a skillet, cook ground beef with chopped onion and minced garlic until browned. 5. Stir in cooked rice, tomato sauce, Italian seasoning, salt, and pepper. 6. Spoon mixture into bell peppers and place in a baking dish. 7. Cover with foil and bake for 30 minutes. 8. Remove foil, top with shredded cheese, and bake for an additional 10 minutes or until cheese is melted and bubbly.');
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-25 10:14:26
