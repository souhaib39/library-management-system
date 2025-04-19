# Library Management System - Java

Full Name: Souhaib Laouedj 
Group: G2  

---

## Project Description

A simple Java-based Library Management System that supports two types of roles:

- Admin:
  - Add books (printed and electronic).
  - Add borrowers.
  - Return borrowed books.
  - View all books and borrowers.

- User:
  - Search for books by title or ISBN.
  - Borrow available books.
  - View list of borrowed books.

---

##  How to Run the Project

1. Open the project in IntelliJ IDEA, VS Code, or any Java IDE.
2. Ensure that all project files are located within the src/ folder.
3. Run the main file located at:
   src/dz/univeloued/tps/Apps/Main.java
  Or from the terminal:
```bash
   javac src/dz/univeloued/tps/Apps/Main.java
   java -cp src dz.univeloued.tps.Apps.Main
```

## Project Structure

The project is organized as follows:

project-root/
    ├── docs/
    |     └── README.md
    └──src
         └── dz/univeloued/tps/
                  ├── classes
                  │     ├── Book.java
                  │     ├── Borrower.java
                  │     ├── BorrowingProcess.java
                  │     ├── E_book.java
                  │     ├── PrintedBook.java
                  |     └── role
                  │          ├── Admin.java
                  │          └── User.java
                  ├── Apps
                  │    └── Main.java



![IntelliJ Terminal](/docs/Screenshot%202025-04-19%20223918.png)


![IntelliJ Terminal](/docs/Screenshot%202025-04-19%20223646.png)                  


   
