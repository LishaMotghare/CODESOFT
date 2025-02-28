1import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Initialize variables to store total marks and subject names
        int totalMarks = 0;
        String[] subjectNames = new String[numSubjects];

        // Prompt the user to enter marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter subject name: ");
            subjectNames[i] = scanner.next();

            System.out.print("Enter marks obtained in " + subjectNames[i] + " (out of 100): ");
            int marks = scanner.nextInt();

            // Validate marks
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks. Please enter marks between 0 and 100: ");
                marks = scanner.nextInt();
            }

            // Add marks to total marks
            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Calculate grade based on average percentage
        String grade = getGrade(averagePercentage);

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }

    // Method to calculate grade based on average percentage
    public static String getGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C";
        } else if (averagePercentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}



// This Java code implements a student grade calculator with the following features:

// - Prompts the user to enter the number of subjects.
// - Prompts the user to enter marks obtained in each subject.
// - Calculates total marks by summing up marks obtained in all subjects.
// - Calculates average percentage by dividing total marks by the total number of subjects.
// - Assigns grades based on the average percentage achieved.
// - Displays total marks, average percentage, and the corresponding grade to the user.