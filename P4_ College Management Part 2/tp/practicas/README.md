<h1 align="center">Practice 4: College Management (Part 2) 🏫</h1>

Develop a graphical interface application for managing an educational institution (college) that provides a set of subjects to its students. A subject (course) is characterized by a name and a code (an integer) that identifies it. A student (student) is characterized by a name, an integer identifier, and the set of subjects in which they are enrolled (enrolled). The system should have functionality to manage offered subjects (offered courses) as well as students of the educational institution (enrolled students) and their enrollment.

## Task

The application design is developed in two parts. The first part was completed in the activity: P4: College Management (Part 1 - individual).

For the second part, assume that the classes from the first part are already developed and available for use in this activity.

<p align="center">
  <img width="700px" src="https://github.com/AlejandroDavidArzolaSaavedra/TP/assets/90756437/1906fefe-1d91-426c-b84b-432667ae6812">
</p>

In the second part, develop a graphical interface that allows the creation of students and their enrollment in corresponding subjects. The application should create different graphical components, meeting the following requirements:

1. Update the order of the student list based on the selection in the user interface.
2. Create a new student through a dialog triggered by the corresponding button or menu option. The creation of a new student should be immediately reflected in the displayed list.
3. Enroll a student in a subject through a dialog triggered by the corresponding button or menu option. The enrollment in the new subject should be immediately reflected in the displayed list.
4. The aesthetics should closely resemble the ones shown in the provided figures.

In the last dialog, a JComboBox is used, initialized with an array of Strings, and taking the selected option from its getSelectedIndex() method. The straightforward approach is to have the student and subject objects stored in the same order as they are displayed to perform the enrollment operation.

**Note:** Classes with the developed code should belong to the "tp.practicas" package.
