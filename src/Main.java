import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private static GPACalculator gpaCalculator = new GPACalculator();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("GPA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));

        JButton addButton = new JButton("Add Course");
        JButton updateButton = new JButton("Update Course");
        JButton deleteButton = new JButton("Delete Course");
        JButton viewButton = new JButton("View Courses");
        JButton gpaButton = new JButton("Calculate GPA");
        JButton creditsButton = new JButton("View Total Credits");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(viewButton);
        panel.add(gpaButton);
        panel.add(creditsButton);

        addButton.addActionListener(e -> addCourse());
        updateButton.addActionListener(e -> updateCourse());
        deleteButton.addActionListener(e -> deleteCourse());
        viewButton.addActionListener(e -> viewCourses());
        gpaButton.addActionListener(e -> calculateGPA());
        creditsButton.addActionListener(e -> viewTotalCredits());

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void addCourse() {
        String name = JOptionPane.showInputDialog("Enter course name:");
        if (name == null || name.isEmpty()) return;

        String grade = JOptionPane.showInputDialog("Enter grade (A-F):");
        if (grade == null || grade.isEmpty()) return;

        String creditsInput = JOptionPane.showInputDialog("Enter credits:");
        if (creditsInput == null || creditsInput.isEmpty()) return;

        try {
            int credits = Integer.parseInt(creditsInput);
            gpaCalculator.addCourse(name, grade, credits);
            JOptionPane.showMessageDialog(null, "Course added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid credits input!");
        }
    }

    private static void updateCourse() {
        String name = JOptionPane.showInputDialog("Enter course name to update:");
        if (name == null || name.isEmpty()) return;

        String grade = JOptionPane.showInputDialog("Enter new grade (A-F):");
        if (grade == null || grade.isEmpty()) return;

        String creditsInput = JOptionPane.showInputDialog("Enter new credits:");
        if (creditsInput == null || creditsInput.isEmpty()) return;

        try {
            int credits = Integer.parseInt(creditsInput);
            gpaCalculator.updateCourse(name, grade, credits);
            JOptionPane.showMessageDialog(null, "Course updated successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid credits input!");
        }
    }

    private static void deleteCourse() {
        String name = JOptionPane.showInputDialog("Enter course name to delete:");
        if (name == null || name.isEmpty()) return;

        gpaCalculator.deleteCourse(name);
        JOptionPane.showMessageDialog(null, "Course deleted successfully!");
    }

    private static void viewCourses() {
        StringBuilder coursesList = new StringBuilder("Courses:\n");
        for (Course course : gpaCalculator.getCourses()) {
            coursesList.append(course).append("\n");
        }
        JOptionPane.showMessageDialog(null, coursesList.toString());
    }

    private static void calculateGPA() {
        double gpa = gpaCalculator.calculateGPA();
        JOptionPane.showMessageDialog(null, String.format("Your GPA is: %.2f", gpa));
    }

    private static void viewTotalCredits() {
        int totalCredits = gpaCalculator.getTotalCredits();
        JOptionPane.showMessageDialog(null, "Total Credits Taken: " + totalCredits);
    }
}
