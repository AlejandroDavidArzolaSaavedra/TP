<h1 align="center">Practice 3: 📱 Electronic Messaging</h1>

The aim of this activity is to practice the use of Object-Oriented Programming features in Java: inheritance, polymorphism, abstract classes, interfaces, and containers.

### Statement 📜
The goal is to develop an SMS (text messaging) delivery system. In this system, there are contacts to whom messages can be sent. Contacts can be individuals or groups. All contacts have a name, represented by a string, and a unique identifier, represented by an integer. Individuals also have a phone number represented by a string. Groups are collections of contacts. It is possible to send a text message to any contact. Contacts can be added to or removed from groups. It is also possible to obtain a list of contacts who are members of a group.

### Exercise to Perform 💻
The exercise involves developing the following set of classes:

**Abstract class Contact:**
- A constructor that takes the contact's name as a parameter (String).
- A method named getId() that returns the contact's identifier (int).
- A method named getName() that returns the contact's name (String).
- An abstract method named sendSMS(...) that sends an SMS (String passed as a parameter) to the contact and returns nothing (void).

**Class Person:**
In addition to the inherited methods, it has the following methods:
- A constructor that takes two parameters: the person's name (String) and phone number (String).
- The toString() method, which returns a string with the concatenation of the name followed by a colon and a space (": "), and then the phone number.

**Class Group:**
In addition to the inherited methods, it has the following methods:
- A constructor that takes the group's name as a parameter (String).
- A method named isMember(...) that takes a contact identifier as a parameter and returns true if it is contained in the group (directly or indirectly), and false if it is not found.
- A method named add(...) that takes a contact to add as a parameter. It returns false if the contact to add is the contact itself or is already contained in the group, either directly or indirectly (group contained). If it has been added, it returns true.
- A method named remove(...) that takes a contact identifier as a parameter and removes it from the group (only directly). It returns false if the contact is not in the group.
- A method named getContacts() that returns a list of direct contacts in the group (List<Contact>) ordered by the identifier of the contact. If the returned list is modified, it should not affect the contacts in the group.
- The toString() method, which returns a string with the name of the group followed by a newline ("\n") and the concatenation of the representation as a string (toString) of the direct contacts of the group followed by newlines ("\n"), ordered by the name of the contact.

A supporting class called SMSTools is already developed, which provides the following static methods:
- The void sendMessage(...) method to which a phone number and the message to be sent are passed.
- The void getUniqueId() method that returns a new unique contact identifier (int).

### Use and Testing of Classes 🚀
Create a main program in the public class UseMessenger that creates several objects and uses the operations of the developed classes. You can include the following code as an example:

```java
...
Person pepe = new Person("Pepe","5555380");
Person juan = new Person("Juan","55541501");
Person antonio = new Person("Antonio","5556380");
Person maría = new Person("María","5557780");
Person ana = new Person("Ana","5557781");
Group family = new Group("family");
Group friends = new Group("friends");
Group girlfriends = new Group("girlfriends");
Group everyone =  new Group("everyone");
Group nonFamily = new Group("non-family");
family.add(juan);
family.add(maría);
friends.add(pepe);
friends.add(antonio);
girlfriends.add(ana);
nonFamily.add(friends);
nonFamily.add(girlfriends);
everyone.add(family);
everyone.add(nonFamily);
everyone.sendSMS("Assignment passed ...");
family.sendSMS("Today birthday dinner");
nonFamily.sendSMS("Today (after family dinner) party!");
girlfriends.remove(ana.getId());
...
```

The classes with the developed code should belong to the "tp.practicas" package.

Optionally, develop a public class called MessengerTest that tests the public methods of the Person and Group classes, excluding the sendSMS() and getId() methods. To execute the test class, it is necessary to include the following statement in the main() method of the UseMessenger class:

```java
org.junit.runner.JUnitCore.main("tp.practicas.MessengerTest");
```

To use JUnit, include the following import clauses in the test class:

```java
import org.junit.*;
import static org.junit.Assert.*;
