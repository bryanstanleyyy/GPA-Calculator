import java.io.*;
import java.util.*;

public class GPACalculator {
    private static final String DATA_FILE = "courses.txt";
    private final Map<String, Course> courses = new HashMap<>();

    public GPACalculator() {
        loadCourses();
    }

    public void addCourse(String name, String grade, int credits) {
        if (!isValidGrade(grade)) {
            throw new IllegalArgumentException("Invalid grade. Please enter a grade (A, B, C, D, F).");
        }
        if (credits <= 0) {
            throw new IllegalArgumentException("Invalid number of credits. Please enter a positive integer.");
        }
        courses.put(name, new Course(name, grade.toUpperCase(), credits));
        saveCourses();
    }

    public void updateCourse(String name, String grade, int credits) {
        if (!courses.containsKey(name)) {
            throw new IllegalArgumentException("Course not found.");
        }
        if (!isValidGrade(grade)) {
            throw new IllegalArgumentException("Invalid grade. Please enter a grade (A, B, C, D, F).");
        }
        if (credits <= 0) {
            throw new IllegalArgumentException("Invalid number of credits. Please enter a positive integer.");
        }
        Course course = courses.get(name);
        course.setGrade(grade.toUpperCase());
        course.setCredits(credits);
        saveCourses();
    }

    public void deleteCourse(String name) {
        courses.remove(name);
        saveCourses();
    }

    public List<Course> getCourses() {
        // Sort the courses alphabetically by name before returning
        List<Course> sortedCourses = new ArrayList<>(courses.values());
        sortedCourses.sort(Comparator.comparing(Course::getName));
        return sortedCourses;
    }

    public double calculateGPA() {
        if (courses.isEmpty()) return 0.0;

        double totalPoints = 0;
        int totalCredits = 0;

        for (Course course : courses.values()) {
            totalPoints += gradeToPoints(course.getGrade()) * course.getCredits();
            totalCredits += course.getCredits();
        }

        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    public int getTotalCredits() {
        return courses.values().stream().mapToInt(Course::getCredits).sum();
    }

    private double gradeToPoints(String grade) {
        switch (grade.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0;
        }
    }

    private void loadCourses() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    String grade = parts[1].toUpperCase();
                    int credits = Integer.parseInt(parts[2]);
                    courses.put(name, new Course(name, grade, credits));
                }
            }
        } catch (IOException e) {
            // If file doesn't exist, start with an empty list
        }
    }

    private void saveCourses() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            // Save the courses in alphabetical order
            List<Course> sortedCourses = getCourses(); // Automatically sorted
            for (Course course : sortedCourses) {
                writer.write(course.getName() + "," + course.getGrade() + "," + course.getCredits());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving courses.");
        }
    }

    private boolean isValidGrade(String grade) {
        return grade.matches("[A-Fa-f]");
    }
}
