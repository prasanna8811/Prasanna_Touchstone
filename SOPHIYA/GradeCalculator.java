
import java.util.ArrayList;
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        // Try-with-resources to auto-close Scanner
        try (Scanner input = new Scanner(System.in)) {

            ArrayList<String> courses = new ArrayList<>();
            ArrayList<String> grades = new ArrayList<>();

            while (true) {
                System.out.print("Enter course name (or 'done' to finish): ");
                String course = input.nextLine();
                if (course.equalsIgnoreCase("done")) {
                    break;
                }

                String grade;
                while (true) {
                    System.out.print("Enter grade for " + course + ": ");
                    grade = input.nextLine().toUpperCase();
                    if (isValidGrade(grade)) {
                        break;
                    } else {
                        System.out.println("Invalid grade. Please enter A, B, C, D, or F.");
                    }
                }

                courses.add(course);
                grades.add(grade);
            }

            double totalPoints = 0;
            for (String g : grades) {
                totalPoints += gradeToPoint(g);
            }
            double gpa = totalPoints / grades.size();

            System.out.println("\nCourses and grades:");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println(courses.get(i) + ": " + grades.get(i));
            }
            System.out.printf("Your GPA is %.2f\n", gpa);
        }
    }

    public static boolean isValidGrade(String grade) {
        return grade.matches("[ABCDF]");
    }

    public static double gradeToPoint(String grade) {
        // Switch expression (modern Java)
        return switch (grade) {
            case "A" ->
                4.0;
            case "B" ->
                3.0;
            case "C" ->
                2.0;
            case "D" ->
                1.0;
            case "F" ->
                0.0;
            default ->
                0.0;
        };
    }
}
