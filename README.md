
# 📚 Library Management System using JDBC

A Java-based **Library Management System** that interacts with an Oracle database to perform CRUD (Create, Read, Update, Delete) operations on book records.

## 🔑 Features
- **Add Book Details**: Insert book information into the database.
- **View All Books**: Retrieve and display all book records from the database.
- **Search by Book Code**: Fetch details of a book using its unique book code.
- **Update Book Details**: Modify book price and quantity using book code.
- **Delete Book**: Remove a book record based on book code.

---

## ⚙️ How the Program Works
1. **Database Connection**:
   - Connects to the Oracle database using the `JDBC` driver.
   - **URL**: `jdbc:oracle:thin:@localhost:1521:xe`
   - **Username/Password**: `ADVJAVA`

2. **Prepared Statements**:
   - SQL queries are precompiled to ensure efficient execution.
   - Operations include:
     - Insert
     - Select (All or By Code)
     - Update
     - Delete

3. **User Input**:
   - Prompts the user to select an operation.
   - Gathers necessary data like book details for adding or updating.

---

## 📂 Table Structure
- **Table Name**: `BOOKDETAILS52`
- **Columns**:
  - `BCODE` - (String) Unique book code
  - `BNAME` - (String) Name of the book
  - `BAUTHOR` - (String) Author name
  - `BPRICE` - (Float) Book price
  - `BQTY` - (Integer) Quantity in stock

---

## 📖 Functional Description
| **Operation**                     | **Description**                                                                                   |
|------------------------------------|---------------------------------------------------------------------------------------------------|
| `Add Book Details`                | Insert a new book's code, name, author, price, and quantity into the database.                   |
| `View All Book Details`           | Retrieve and display all records in the `BOOKDETAILS52` table.                                   |
| `Search by Book Code`             | Find and show details of a book by its `BCODE`.                                                  |
| `Update Book Details (Price/Qty)` | Modify the `BPRICE` or increment the `BQTY` of an existing book based on its `BCODE`.           |
| `Delete Book by Code`             | Remove a book record from the database if it matches the provided `BCODE`.                       |

---

## 🚀 How to Run the Program
1. **Prerequisites**:
   - Install Java (JDK 8 or higher).
   - Install Oracle Database (Local/Remote).
   - Add Oracle JDBC Driver to your classpath.

2. **Database Setup**:
   - Create the `BOOKDETAILS52` table:
     ```sql
     CREATE TABLE BOOKDETAILS52 (
         BCODE VARCHAR2(10) PRIMARY KEY,
         BNAME VARCHAR2(50),
         BAUTHOR VARCHAR2(50),
         BPRICE FLOAT,
         BQTY INTEGER
     );
     ```
   - Ensure the table is empty before running the program.

3. **Compile and Run**:
   - Compile the Java file:
     ```bash
     javac DBCon3.java
     ```
   - Run the program:
     ```bash
     java test.DBCon3
     ```

4. **Interacting with the Application**:
   - Choose options from the menu displayed.
   - Provide required details as prompted.

---

## 📷 Program Output Example
### Menu:
```
***** Choice *****
1. AddBookDetails
2. ViewAllBookDetails
3. ViewBookByCode
4. UpdateBookByBookCode(Price/Qty)
5. DeleteBookByCode
6. Exit
Enter choice:
```

### Adding a New Book:
```
Enter the BookCode: B101
Enter the BookName: Java Programming
Enter the BookAuthor: John Doe
Enter the BookPrice: 500.50
Enter the BookQty: 10
BookDetails inserted Successfully...
```

### Viewing All Books:
```
***** Book-Details *****
B101    Java Programming    John Doe    500.5    10
```

---

## 🛠️ Technologies Used
- **Programming Language**: Java
- **Database**: Oracle
- **API**: Java JDBC
- **Development Environment**: IntelliJ IDEA / Eclipse

---

## 📑 Additional Notes
- Make sure to handle exceptions in a real-world application for better reliability.
- Avoid hardcoding credentials; use configuration files for secure setups.

---

## 🤝 Contribution
Feel free to submit issues or pull requests if you have improvements for this project.

---

## 📧 Contact
- **LinkedIn**: [Aman Kumar](https://www.linkedin.com/in/aman-kumar-64b22b270/)
- **Portfolio**: [Visit Here](https://aman-first-portfolio.netlify.app/)

---

### 🌟 Show your support by giving this repository a ⭐!
