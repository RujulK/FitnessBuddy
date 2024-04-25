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
-- Table structure for table `exercises`
--

DROP TABLE IF EXISTS `exercises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercises` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `instructions` text NOT NULL,
  `sets` varchar(50) DEFAULT NULL,
  `reps` varchar(50) DEFAULT NULL,
  `demonstration_video` varchar(255) DEFAULT NULL,
  `bmi_category` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercises`
--

LOCK TABLES `exercises` WRITE;
/*!40000 ALTER TABLE `exercises` DISABLE KEYS */;
INSERT INTO `exercises` VALUES (1,'Push-up','Start in a plank position with hands shoulder-width apart. Lower your body until your chest nearly touches the floor. Push back up to starting position.','3','10-12','https://example.com/push-up',NULL),(2,'Squat','Stand with feet shoulder-width apart. Bend your knees and lower your body until your thighs are parallel to the floor. Push through your heels to return to standing position.','3','10-12','https://example.com/squat',NULL),(3,'Deadlift','Stand with feet hip-width apart, holding a barbell with hands shoulder-width apart. Hinge at the hips, keeping your back flat, and lower the barbell to the ground. Stand back up, pushing through your heels.','3','8-10','https://example.com/deadlift',NULL),(4,'Lunges','Stand tall with feet hip-width apart. Step forward with one foot and lower your body until both knees are bent at a 90-degree angle. Push back up to starting position and repeat on the other side.','3','10-12 each leg','https://example.com/lunges',NULL),(5,'Pull-up','Grab a pull-up bar with palms facing away from you and hands shoulder-width apart. Pull your body up until your chin clears the bar, then lower yourself back down.','3','6-8','https://example.com/pull-up',NULL),(6,'Plank','Start in a push-up position with hands directly under your shoulders. Hold your body in a straight line from head to heels, engaging your core muscles. Hold for the desired duration.','3','Duration: 30-60 seconds','https://example.com/plank',NULL),(7,'Bicycle Crunches','Lie on your back with hands behind your head and legs raised. Alternate bringing one knee towards the opposite elbow while extending the other leg straight. Rotate your torso as you bring each knee in.','3','12-15 each side','https://example.com/bicycle-crunches',NULL),(8,'Burpees','Start in a standing position, then squat down and place your hands on the floor. Jump your feet back into a plank position, perform a push-up, then jump your feet back to your hands and stand up.','3','8-10','https://example.com/burpees',NULL),(9,'Russian Twists','Sit on the floor with knees bent and feet elevated. Lean back slightly and clasp your hands together in front of you. Twist your torso to the right, then to the left, while keeping your core engaged.','3','12-15 each side','https://example.com/russian-twists',NULL),(10,'Dumbbell Shoulder Press','Stand with feet shoulder-width apart, holding dumbbells at shoulder height with palms facing forward. Press the dumbbells overhead until arms are fully extended, then lower back down.','3','8-10','https://example.com/shoulder-press',NULL);
/*!40000 ALTER TABLE `exercises` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-25 10:14:27
