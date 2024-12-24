# GPA Calculator Project

## Description
This GPA Calculator is a Java-based application that helps users manage their academic courses, track grades, and calculate their cumulative GPA on a 4.0 scale. The application allows users to add, update, view, and delete courses, ensuring all inputs (grades and credits) are validated.

## Features
- **Course Management**: Add, update, view, and delete courses with course names, grades, and credits.
- **Input Validation**: Ensures valid grades (A, B, C, D, E, F) and numeric credits.
- **Persistent Storage**: Saves course data to a file so changes are retained across sessions.
- **Alphabetical Sorting**: Displays courses in alphabetical order for easy viewing.
- **GPA Calculation**: Computes GPA based on entered grades and credits.
- **Credit Summary**: Displays the total number of credits taken.

## How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/bryanstanleyyy/GPA-Calculator.git
   cd GPA-Calculator
2. Compile:
   ```bash
   javac *.java
3. Run the program:
   ```bash
   java Main
4. Example:
   ```bash
   ***Welcome to GPA Calculator!***
   Enter course name: Introduction to Computer Science
   Enter grade (A, B, C, D, E, F): A
   Enter credits: 3

   Course added successfully!

   Enter course name: Data Structures
   Enter grade (A, B, C, D, E, F): B
   Enter credits: 4

   Course added successfully!

   Total Credits: 7
   GPA: 3.71

## Project Structure
- `GPACalculator.java`: Main class handling course management and GPA calculation.
- `Course.java`: Represents individual course details.
- `courses.txt`: File for storing course data persistently.

## Requirements
- Java Development Kit (JDK) 8 or later.
- A compatible Java IDE or command-line setup.

## License
This project is licensed under the MIT License.

## Contact
- GitHub: [https://github.com/bryanstanleyyy](https://github.com/bryanstanleyyy)
- Email: bryansjones04@gmail.com
