# S1T5 — Java Utils

This unit focuses on **Java I/O and Serialization**, covering directory manipulation, recursive file listing, and the persistence of objects using the `Serializable` interface.

## TASK 1 - LEVEL 1

### 📌 Exercise 1 — Alphabetical Directory Listing
Lists the contents of a specified directory in alphabetical order.

### 📌 Exercise 2 — Recursive Tree Listing
Extends the functionality to list the entire directory tree recursively, showing subfolders and files sorted alphabetically with their last modification dates.

### 📌 Exercise 3 — Output to File
Modifies the previous exercise so the resulting directory tree is saved directly into a `.txt` file instead of the console.

### 📌 Exercise 4 — File Reader
Reads and displays the content of any `.txt` file in the terminal.

### 📌 Exercise 5 — Serialization & Deserialization
Demonstrates how to serialize a `Book` object into a `.ser` file and then deserialize it to recover the object's state.

## 🛠 Technologies

* **Java 21 (LTS)**
* **Maven 3.6+**
* **Git & GitHub**

## ▶️ Compilation 

All programs are designed to be executed **from the command line**.
### Compile the source files

From the project root directory:

### javac -d out src/**/*.java

( This command compiles all .java source files into .class bytecode and places them in the out directory. )

## Executation

To execute an exercise, run:

java -cp out <package>.<MainClass> ( This is the generic way to execute )

java -cp out m1exercise1.Exercise1 ( This is a concrete example of this command ) 


## 🌍 Portability & Best Practices

This project is designed to be fully portable across operating systems (Windows, macOS, Linux). To achieve this:

- Only **relative paths** are used; no absolute paths are hardcoded.
- File paths rely on `File.separator` to ensure platform independence.
- All programs are compiled and executed from the **command line** for consistent behavior.

These practices ensure the project is reusable and executable in any environment.


## 🌍 Portability and Best Practices

To ensure the project is fully portable and works on any operating system (Windows, macOS, Linux), the following standards are implemented:

* **Relative Paths:** No absolute paths are used. All file references are relative to the project root directory.
* **File Separator:** The code utilizes java.io.File.separator instead of hardcoded slashes to guarantee cross-platform compatibility.
* **Version Alignment:** Both the pom.xml and the environment requirements are strictly set to Java 21 (LTS).
