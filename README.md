A Java-based desktop application that simulates a simplified **Bus Rapid Transit System (BRTS)**, enabling route planning, fare calculation, ticket generation, and transaction logging.

## 🚀 Features

- 🔐 **User Authentication**: Secure login system for staff/admin roles
- 🗺️ **Route Planning**: Select source and destination to get route info
- 💰 **Distance-Based Fare Calculation**
- 🎫 **Ticket Generation**: Auto-generates tickets with trip details
- 🧾 **Transaction Logging**: Saves each booking to a `.txt` log file
- ⚙️ **Admin Panel**: Manage routes, view logs (if implemented)

## 🛠️ Tech Stack

- **Frontend**: Java Swing (JFrame)
- **Backend**: Java
- **Database**: PostgreSQL
- **File Handling**: Java IO (for logs)

## 📷 Screenshots

*(Add screenshots of the UI here if available)*

## 💡 Learning Highlights

- GUI development using Java Swing
- Database connectivity with JDBC
- File management and I/O handling
- Modular design using Object-Oriented Programming principles

## 📦 How to Run

1. Clone this repo
2. Set up PostgreSQL and import the provided schema
3. Update DB credentials in the source code
4. Compile and run the `Main.java` file

```bash
javac Main.java
java Main
