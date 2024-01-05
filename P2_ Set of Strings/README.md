
<h1 align="center">Practice 2: Set of Strings 🧠</h1>

The aim of this activity is to practice the use of classes, methods, constructors, control structures, arrays, and object comparison in Java.

## Prompt 📝
The representation of a collection of elements can be achieved through the mathematical concept of sets, whose main characteristics are that all elements are distinct, meaning there are no repeated elements, and the order in which elements are arranged is irrelevant. Consequently, two sets are considered equal if all the elements of one set are equal to those of the other, and vice versa, even if they are arranged in a different order.

The cardinality of a set is defined as the number of elements it contains. The set that has no elements is said to be empty, and its cardinality is zero.

An element is said to belong to a set if the set contains an element equal to it. A set is also said to be contained in another if all elements of that set belong to the including set.

Among the different operations that can be applied to sets to obtain new sets, the most important ones are:

- **Union**: The union of two sets is another set composed of all elements from both sets.
- **Intersection**: The intersection of two sets is another set formed by the elements that belong to both sets.
- **Difference**: The difference of two sets is another set formed by the elements of the first set that do not belong to the second.

## Task 🛠️
Develop a public class named ConjuntoDeStrings that represents a set of String objects and allows performing typical operations on sets. The set does not admit repeated elements. The class has the following operations:

1. A constructor that initializes a set by taking data from a variable number of parameters referencing Strings or from an array of String references. Repeated elements are discarded.
2. A method named cardinal() that returns the number of elements in the set.
3. A method named estáVacío() that returns true if the set is empty and false otherwise.
4. A method named añade() that adds a new element to the set, returning true if it was added and false if there is already an element with the same value in the set.
5. A method named pertenece() that returns true if there is an element in the set with the same value and false otherwise.
6. A method named unión() that performs the union operation of sets. The method takes a reference to another set and returns a reference to a new set, the result of the union of the current set and the one passed as a parameter.
7. A method named intersección() that performs the intersection operation between the set passed as a parameter and the current set on which the operation is applied.
8. A method named diferencia() that performs the difference operation between sets.
9. The equals() method, overridden from the Object class, to compare sets for equality.
10. A method named contenido() to which a set is passed, and it returns whether it is contained in the current set.
11. A method named elementos() that returns an array of size cardinal() with the elements stored in the set.

## Usage and Testing of the ConjuntoDeStrings Class
Create a main program in the public class UsaConjunto that creates several objects and uses the operations of the ConjuntoDeStrings class.

Optionally, develop a public class named ConjuntoTest for testing all public methods of the ConjuntoDeStrings class.

The classes with the code to be developed must belong to the "tp.practicas" package.

To execute the test classes, include the following statement in the main() method of the UsaConjunto class:

```java
org.junit.runner.JUnitCore.main("tp.practicas.ConjuntoTest");
```

To use JUnit, include the following import clauses in the test class:

```java
import org.junit.*;
import static org.junit.Assert.*;
