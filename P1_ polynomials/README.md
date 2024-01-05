<h1 align="center">Practice 1: Polynomial 📚</h1>

The aim of this activity is to practice the use of classes, methods, constructors, control structures, and arrays in Java.

## Prompt 📝

We want to create an application that performs operations with polynomials. Polynomials are created from an array of coefficients, and the desired actions include obtaining information about the polynomial, retrieving all coefficients representing the polynomial in the form of an array of integers, obtaining a specific coefficient of the polynomial, determining the degree of the polynomial, and obtaining a representation of the polynomial as a string for display. Additionally, we aim to calculate the value of the polynomial for a given x and obtain the polynomial resulting from adding or subtracting two polynomials.

The mathematical element of polynomials with integer coefficients and a real variable has an algebraic expression in the following form:

## Task 🛠️
Develop a public class named Polinomio that represents polynomials with the following operations:

1. A default constructor that prepares a Polinomio object for use. This polynomial would have a degree of zero and a constant term of zero.
2. A constructor that takes an array of integers. The first element of the array represents the constant term, the second the coefficient of the term of degree 1, and so on. The degree of the polynomial is the highest index with a non-zero value.
3. A method named grado() that returns an integer representing the degree of the polynomial.
4. A method named coeficiente() that takes a parameter with an integer, i, indicating the position of a coefficient in the polynomial. It returns the value of the coefficient or the constant term, \( a_i \). If the integer i does not indicate a valid term, it returns 0.
5. A void method named coeficiente() that takes two parameters: an integer, i, indicating the position of a coefficient in the polynomial, and another integer, v, representing a value. The method sets the coefficient \( a_i \) of the polynomial to the value v. This operation can change the degree of the polynomial.
6. A method named coeficientes() that returns an array of integers, of size grado() + 1, containing the coefficients of the polynomial from the term of lowest degree to the highest degree. If the returned array is modified, it should not affect the polynomial.
7. The toString() method, overridden from the Object class, which returns a string representing the polynomial starting from the term of highest degree and omitting terms with a coefficient of zero. If all coefficients are zero, toString() should return "0". Examples: "0", "3x-2", "4x^5-8x^2+2", "-3x^7".
8. A method named valor() that takes a parameter representing a real value (float), v, and returns the value (float) of the polynomial for \( x = v \).
9. A method named suma() that returns a polynomial representing the sum of the current polynomial and another passed as a parameter.
10. A method named resta() that returns a polynomial representing the subtraction of another polynomial passed as a parameter from the current polynomial.

## Usage and Testing of the Polinomio Class 🚀
Create a main program in the public class UsaPolinomio that creates several objects and uses the operations of the Polinomio class.

Optionally, develop a public class named PolinomioTest for testing all public methods of the Polinomio class. To execute the test classes, include the following statement in the main() method of the UsaPolinomio class:

```java
org.junit.runner.JUnitCore.main("PolinomioTest");
```

To use JUnit, include the following import clauses in the test class:

```java
import org.junit.*;
import static org.junit.Assert.*;
...
```

Notes:
The use of containers for the implementation of the Polinomio class is not allowed. 🚫
