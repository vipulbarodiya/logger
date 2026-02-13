# Distributed Logger System (LLD)

A highly extensible, thread-safe Logger implementation in Java. This project demonstrates Low-Level Design (LLD) principles, focusing on the **Chain of Responsibility** and **Observer** patterns to create a decoupled and production-ready utility.

---

## 🏗️ Design Patterns Used

### 1. Chain of Responsibility
Used to process log levels. Each logger in the chain decides whether to process the message or pass it to the next handler. This eliminates nested `if-else` or `switch` statements and keeps the logic clean.

### 2. Observer Pattern
The system treats log destinations (Console, File, DB) as **Observers**. This allows the logger to broadcast a single message to multiple "sinks" simultaneously without the core logic knowing the details of the output destination.

### 3. Singleton Pattern
The `LogManager` is implemented as a Singleton to ensure there is only one centralized logging configuration throughout the application lifecycle.

### 4. Factory Pattern
Used to construct the chain of loggers and initialize the observers, abstracting the setup complexity away from the client.

---

## 🚀 Key Features
* **Decoupled Levels:** Supports `INFO`, `DEBUG`, and `ERROR` levels.
* **Multi-Sink Support:** Simultaneously log to different outputs (Console, File, etc.).
* **Thread Safety:** Designed to handle concurrent logging requests from multiple threads.
* **Open-Closed Principle:** Easily add a new Log Level (e.g., `FATAL`) or a new Sink (e.g., `SlackNotification`) without modifying existing code.

---

## 🛠️ System Architecture



### Core Components:
1.  **AbstractLogger:** The base class for the chain.
2.  **LogSubject:** The "Observable" that manages all registered sinks.
3.  **LogObserver:** The interface implemented by any new output destination.
4.  **LogManager:** The singleton facade used by the application to log messages.

---

## 💻 Usage Example

```java
public class Application {
    public static void main(String[] args) {
        // Retrieve the thread-safe Singleton instance
        Logger logger = Logger.getInstance();
        
        // Log messages at different levels
        logger.info("Application started successfully.");
        logger.debug("Processing user request ID: 12345");
        logger.error("Database connection timeout occurred!");
    }
}