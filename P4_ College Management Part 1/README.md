<h1 align="center"> Practice 4: College Management (Part 1) 🎓</h1>

This activity aims to practice the use of Object-Oriented Programming features, including inheritance, polymorphism, containers, and graphical user interfaces in Java.

## Instructions 📝

Develop an application with a graphical interface for managing an educational institution (college) that offers training in a set of subjects to its students. A subject (course) is characterized by a name and a code (an integer) that identifies it. A student is characterized by a name, an integer identifier, and the set of subjects in which they are enrolled. The system should have functionality to manage offered courses and enrolled students.

## Exercise Details 🛠️

The application design involves two parts. In the first part, the implementation of the following set of classes is required: Course, Student, EnrolledStudents, OfferedCourses, and College.

In the second part, the graphical interface will be developed to allow the creation of students and their enrollment in the corresponding courses.

### Course Class

The Course class represents a subject and requires the following public methods:

| Method                  | Description                                                                                          |
| ----------------------- | ---------------------------------------------------------------------------------------------------- |
| Course(int, String)      | Constructor that takes an integer with the subject identifier and a String with the subject's name.  |
| int getCode()            | Returns the subject identifier.                                                                      |
| String getName()         | Returns the subject name.                                                                            |
| String toString()        | Returns a String formed by the subject identifier in parentheses ("(...)") followed by the subject name. |

### Student Class

The Student class requires the following public methods:

| Method                         | Description                                                                                                                  |
| ------------------------------ | ---------------------------------------------------------------------------------------------------------------------------- |
| Student(int, String)           | Constructor that takes an integer with the identifier and a String with the student's name.                                |
| int getId()                    | Returns the student's identifier.                                                                                            |
| String getName()               | Returns the student's name.                                                                                                  |
| boolean enrollCourse(Course)   | Adds a new course passed as a parameter to the set of courses the student is enrolled in. Returns true if added, false if already enrolled. |
| boolean unenrollCourse(int)    | Removes the course with the code passed as a parameter from the courses the student is enrolled in. Returns true if removed, false if not found. |
| Collection<Course> getEnrolledCourses() | Returns a collection with the courses the student is enrolled in, ordered by the course code. |
| String toString()              | Returns a String formed by the student's identifier followed by a hyphen ("-") and the student's name, followed by the concatenation of the enrolled courses separated by a comma and a space (", ") between the square bracket characters ("[...]"), ordered by the course code. |

### EnrolledStudents Class

The EnrolledStudents class represents the set of students enrolled in the educational institution and requires the following public methods:

| Method                   | Description                                                                                                                |
| ------------------------ | -------------------------------------------------------------------------------------------------------------------------- |
| EnrolledStudents()       | Parameterless constructor that initializes the container of enrolled students to empty.                                    |
| boolean addStudent(Student) | Adds a student to the container of registered students. Returns true if added, false if a student with the same identifier is already registered. |
| boolean removeStudent(int) | Removes the student with the identifier passed as a parameter. Returns true if removed, false if not found. |
| Student getStudent(int)   | Returns a student based on their identifier. If it doesn't exist, returns null.                                            |
| List<Student> getStudentsByCourse(int) | Returns a list of students enrolled in the course with the specified code, ordered by name, and if they have the same name, ordered by their identifier. |
| List<Student> getStudentsOrderByName() | Returns a list of students in the educational institution ordered by name, and if they have the same name, ordered by their identifier. |
| List<Student> getStudentsOrderById()   | Returns a list of students in the educational institution ordered by their identifier.                                     |

### OfferedCourses Class

The OfferedCourses class represents the set of subjects offered by the educational institution and requires the following public methods:

| Method                      | Description                                                                                                              |
| --------------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| OfferedCourses()            | Parameterless constructor that initializes the container of offered subjects to empty.                                  |
| boolean addCourse(Course)   | Adds a subject to the container of subjects. Returns true if added, false if a subject with the same identifier is already registered. |
| boolean removeCourse(int)    | Removes the subject with the identifier passed as a parameter. Returns true if removed, false if not found.              |
| Course getCourse(int)        | Returns a subject based on its identifier. If it doesn't exist, returns null.                                            |
| List<Course> getCourses()    | Returns a list with the subjects offered by the educational institution, ordered by the toString() of the subject (Course). |

## Usage and Testing of Classes 🚀

Create a main program in the public College class that creates various objects and utilizes the operations of the developed classes.

Optionally, develop a public class named CollegeTest that tests the public methods of the required classes. To execute the test class, include the following statement in the main() method of the College class:

```java
org.junit.runner.JUnitCore.main("tp.practicas.CollegeTest");
```

To use JUnit, include the following import clauses in the test class:

```java
import org.junit.*;
import static org.junit.Assert.*;
...
```

Feel free to explore and extend the functionality of these classes to further enhance your Java programming skills! 🌟
