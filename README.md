Object-Oriented Programming in Java — University Lab Manual
Overview
This repository contains practical learning materials for Object-Oriented Programming (OOP) in Java. The manual is organised into eleven labs, moving from basic classes and objects to a small integrated project.
Each lab includes learning objectives, explanations of key concepts, example Java programs, expected output, common mistakes, and exercises at Basic, Intermediate, and Challenge levels.
Learning Outcomes
By working through the labs, students should be able to:
- Model real-world entities using classes and objects.
- Apply encapsulation, inheritance, polymorphism, and abstraction.
- Use constructors, access modifiers, and static members correctly.
- Handle exceptions and validate input safely.
- Work with generics and Java collections.
- Read and write files and use lambdas and streams.
- Apply common design patterns in a small project.
Lab Contents
Lab	Topic	Main Concepts
1	Classes and Objects	Fields, methods, references, null
2	Constructors, this, and static	Constructor overloading and chaining, static members, initialisation
3	Encapsulation	Access modifiers, getters/setters, validation
4	Inheritance	extends, super, protected, final, composition
5	Polymorphism	Overloading, overriding, dynamic dispatch, casting
6	Abstraction	Abstract classes, interfaces, default methods
7	Exception Handling	try, catch, finally, custom exceptions, try-with-resources
8	Generics and Collections	Generic types, List, Set, Map, sorting
9	Nested Types, Enums, and Records	Inner classes, enums, records, equals, hashCode, toString
10	File I/O, Lambdas, and Streams	java.nio.file, functional interfaces, Stream API
11	Design Patterns and Mini-Project	Singleton, Factory, Observer, Strategy, integration


Requirements
- Java Development Kit (JDK): Java 17 or later is recommended.
- Editor or IDE: IntelliJ IDEA, Eclipse, Visual Studio Code with the Java extension, or a text editor and terminal.
Check that Java is installed:
java -version
javac -version
Compiling and Running Java Programs
Open a terminal in the directory containing the source file.
For a single class such as Student.java:
javac Student.java
java Student
With Java 11 or later, a single-file program can also be run directly:
java Student.java
For a simple project with multiple Java files in the same directory:
javac *.java
java MainClass
Replace MainClass with the name of the class that contains the program's main method. If the project uses packages or a build tool, follow the corresponding directory and build instructions.
Mini-Project
The manual's final lab introduces a Library Management System mini-project to bring together concepts from the earlier labs. The manual specifies working in pairs and submitting the source code, a class diagram, and a short report.
Use the requirements in the lab manual as the authoritative specification for the project. This README describes the accompanying learning material; it does not claim that a completed application or automated test suite is included.
Recommended Workflow
1. Read the objectives and theory for a lab.
2. Type and run the example program.
3. Compare your output with the expected output in the manual.
4. Complete the exercises, starting with Basic tasks.
5. Add comments explaining important decisions and concepts.
6. Keep screenshots of program output and notes for your lab record.
7. Practise explaining your code for oral/viva checks.
Coding Conventions
- Use PascalCase for class names, for example StudentRecord.
- Use camelCase for methods and variables, for example calculateTotal.
- Use UPPER_SNAKE_CASE for constants, for example MAX_ATTEMPTS.
- Keep each public class in a source file with the same name.
- Validate data and handle exceptions where appropriate.
- Use comments to explain important reasoning, not just to repeat what a line of code says.
Assessment Structure
The manual suggests the following assessment breakdown:
- Lab exercises (Labs 1–10): 40%
- Viva / oral checks: 20%
- Mini-project (Lab 11): 30%
- Lab record / report: 10%
Notes
This is educational material intended for practical learning. Refer to the lab manual for the full explanations, source examples, expected outputs, and exact exercise instructions.
Author / Credits
Based on Object-Oriented Programming in Java — University Lab Manual.
