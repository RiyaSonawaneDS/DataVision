import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
     private String code;
    private String title;
    private String description;
    private int capacity;
    private int availableSlots;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.availableSlots = capacity;
        this.schedule = schedule;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public String getSchedule() {
        return schedule;
    }

    // Method to decrease available slots when a student registers
    public void registerStudent() {
        if (availableSlots > 0) {
            availableSlots--;
        } else {
            System.out.println("No available slots for this course.");
        }
    }

    // Method to increase available slots when a student drops a course
    public void dropStudent() {
        if (availableSlots < capacity) {
            availableSlots++;
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description + "\nAvailable Slots: " + availableSlots + "\nSchedule: " + schedule + "\n";
    }
}

class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    // Method to register for a course
    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.registerStudent();
    }

    // Method to drop a course
    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.dropStudent();
    }
}

public class CourseRegistrationSystem {
    
    public static void main(String[] args) {
        // Creating sample courses
        Course course1 = new Course("CSE101", "Introduction to Computer Science", "Fundamentals of programming", 30, "Mon/Wed/Fri 10:00 AM");
        Course course2 = new Course("MAT201", "Calculus I", "Fundamental concepts of calculus", 25, "Tue/Thu 1:00 PM");

        // Creating sample students
        Student student1 = new Student("001", "Alice");
        Student student2 = new Student("002", "Bob");

        // Sample course registration
        student1.registerCourse(course1);
        student2.registerCourse(course2);

        // Sample course removal
        student2.dropCourse(course2);

        // Displaying course listing
        System.out.println("Available Courses:");
        System.out.println(course1);
        System.out.println(course2);

        // Displaying student information
        System.out.println("Student Information:");
        System.out.println("Student 1:");
        System.out.println("Name: " + student1.getName());
        System.out.println("Registered Courses:");
        for (Course course : student1.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.println("Student 2:");
        System.out.println("Name: " + student2.getName());
        System.out.println("Registered Courses:");
        for (Course course : student2.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
    }
    
}
