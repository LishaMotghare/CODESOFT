import java.util.*;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    int availableSlots;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.availableSlots = capacity;
        this.schedule = schedule;
    }
}

class Student {
    String id;
    String name;
    List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

public class CourseRegistrationSystem {
    Map<String, Course> courseDatabase;
    Map<String, Student> studentDatabase;

    public CourseRegistrationSystem() {
        this.courseDatabase = new HashMap<>();
        this.studentDatabase = new HashMap<>();
    }

    // Method to add a course to the course database
    public void addCourse(Course course) {
        courseDatabase.put(course.code, course);
    }

    // Method to add a student to the student database
    public void addStudent(Student student) {
        studentDatabase.put(student.id, student);
    }

    // Method to display available courses
    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase.values()) {
            if (course.availableSlots > 0) {
                System.out.println(course.code + ": " + course.title + " - Available Slots: " + course.availableSlots);
            }
        }
    }

    // Method to register a student for a course
    public void registerStudentForCourse(String studentId, String courseCode) {
        Student student = studentDatabase.get(studentId);
        Course course = courseDatabase.get(courseCode);

        if (student != null && course != null && course.availableSlots > 0) {
            student.registeredCourses.add(course);
            course.availableSlots--;
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Please check student ID, course code, and available slots.");
        }
    }

    // Method to remove a student from a course
    public void removeStudentFromCourse(String studentId, String courseCode) {
        Student student = studentDatabase.get(studentId);
        Course course = courseDatabase.get(courseCode);

        if (student != null && course != null) {
            student.registeredCourses.remove(course);
            course.availableSlots++;
            System.out.println("Removal successful!");
        } else {
            System.out.println("Removal failed. Please check student ID and course code.");
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem crs = new CourseRegistrationSystem();

        // Create courses
        Course course1 = new Course("CS101", "Introduction to Computer Science", "This course introduces the basics of computer science.", 20, "Monday, Wednesday, Friday");
        Course course2 = new Course("CS202", "Data Structures and Algorithms", "This course covers data structures and algorithms.", 25, "Tuesday, Thursday");

        // Add courses to the course database
        crs.addCourse(course1);
        crs.addCourse(course2);

        // Create students
        Student student1 = new Student("S1", "John Doe");
        Student student2 = new Student("S2", "Jane Smith");

        // Add students to the student database
        crs.addStudent(student1);
        crs.addStudent(student2);

        // Display available courses
        crs.displayAvailableCourses();

        // Register students for courses
        crs.registerStudentForCourse("S1", "CS101");
        crs.registerStudentForCourse("S2", "CS202");

        // Display available courses again
        crs.displayAvailableCourses();

        // Remove a student from a course
        crs.removeStudentFromCourse("S1", "CS101");

        // Display available courses one more time
        crs.displayAvailableCourses();
    }
}



// This Java code implements a simple student course registration system that:

// - Stores course information, including course code, title, description, capacity, and schedule.
// - Stores student information, including student ID, name, and registered courses.
// - Displays available courses with details and available slots.
// - Allows students to register for courses from the available options.
// - Enables students to drop courses they have registered for.

