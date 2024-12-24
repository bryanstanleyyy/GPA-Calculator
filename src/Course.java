public class Course {
    private String name;
    private String grade;
    private int credits;

    public Course(String name, String grade, int credits) {
        this.name = name;
        this.grade = grade.toUpperCase(); // Convert to uppercase when creating a new course
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade.toUpperCase(); // Ensure grade is always stored in uppercase
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return name + " (" + credits + " credits): " + grade;
    }
}
