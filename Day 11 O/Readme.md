# 📚 Library Management System

This is a **console-based Java application** that simulates the operations of a real-world library. It allows you to manage books, members, and lending activities in a structured and user-friendly way. Built using **OOP principles**, **Java Collections**, and **custom exception handling**, this system is ideal for educational purposes or as a base for a more advanced library management tool.

---

## ✨ Key Highlights

* **Modular Design**: Clean separation of concerns using `model`, `service`, `repository`, and `exception` packages.
* **User Interaction**: Text-based menu-driven interface for simple and intuitive user experience.
* **Custom Exceptions**: Handles real-world scenarios like unavailable books, overdue returns, or non-existent records.
* **Live Monitoring**: A background thread (`OverdueMonitor`) continuously checks and reports overdue books every minute.
* **Feedback-Oriented**: After every operation, users are notified of success or failure clearly.
* **Scalability-Ready**: Designed with extensibility in mind—easy to plug in new features like file/database storage.

---

## 🔧 Features in Detail

| Feature                    | Description                                                         |
| -------------------------- | ------------------------------------------------------------------- |
| ✅ Add Book                 | Add new books with unique IDs to the catalog.                       |
| ❌ Remove Book              | Remove existing books by their IDs.                                 |
| 🧑 Add Member              | Register new library members.                                       |
| 👋 Remove Member           | Delete existing members.                                            |
| 🔍 Search Books            | Search by book title or author (partial match supported).           |
| 🔎 Search Members          | Search members by name or email.                                    |
| 📚 Issue Book              | Issue a book if it’s available and the member has no overdue books. |
| 🔁 Return Book             | Return previously issued books, updates the status immediately.     |
| 📖 List Available Books    | View all books that are currently not issued.                       |
| 🧾 Borrower Report         | List members who currently have at least one book issued.           |
| ⏳ Overdue Detection        | Automatically detect and list overdue books.                        |
| ⚠️ Real-Time Notifications | Background thread prints overdue book info every 60 seconds.        |
| 🧹 Graceful Exit           | Application closes cleanly with all threads stopped.                |

---

## 🗂️ Project Structure Overview

```
LibraryManagementSystem/
├── Exception/
│   └── LibExcep.java         # Custom exceptions for business logic
├── MainLib/
│   ├── Book.java                      # Book entity
│   ├── Member.java                    # Member entity
│   └── LendingRecords.java            # Lending details
│   └── Repo.java                # (Optional) Reusable generic repository
├── Services/
│   ├── LibraryS.java            # Core service logic for books and members
│   └── DueS.java            # Background thread for overdue tracking
└── Main.java                          # CLI-based program entry point
```

---

## ▶️ How to Run the Program

### 🧑‍💻 Prerequisites

* Java JDK 8 or above installed
* Basic command-line knowledge or a Java IDE like IntelliJ, Eclipse, or VS Code

### 🛠️ Steps

1. **Clone the Repository**

   ```bash
   git clone https://github.com/dixit-raj/Accolite-Training.git
   cd Day 11 O
   ```

2. **Compile the Code**

   ```bash
   javac MainL.java MainLib/*.java Services/*.java Exception/*.java
   ```

3. **Run the Program**

   ```bash
   java MainL
   ```

---
