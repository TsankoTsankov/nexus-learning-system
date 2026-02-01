# Nexus: A local-first Knowledge Manager
> **Status:** Active Development
> **Current version:** v0.1.0-alpha

Nexus is a CLI-based Personal Learning Environment (PLE) written in Java. It scans your local storage for PDF books, tracks your reading habits, and (eventually) manages yor study sessions without relying on cloud services.

## Features (Current)
* **Smart File Scanning:** recursively scans a user defined direcotry to find `.pdf` files.
* **Auto-Discovery:** automatically extracts filenames and paths to populate the library.
* **Data Validation:** Logic to prevent invalid states (e.g., setting a current page to `-1` or exceeding the total page count).
* **Unit Tested:** Core logic is verified using JUnit 5.

## Tech Stack

* **Language:** Java 21 (OpenJDK)
* **Build Tool:** Maven
* **Testing:** JUnit 5
* **Version Control:** Git & GitHub

## Getting Started

### Prerequisites
* Java JDK 17 or higher
* Maven 3.6+

### Installation
1.  **Clone the repository**
    ```bash
    git clone https://github.com/TsankoTsankov/nexus-learning-system.git
    cd nexus-learning-system
    ```
2. **Build the project**
    ```bash
    ./mvnw clean install
    ```

3.  **Run the CLI**
    You can run the application directly through Maven or your IDE.
    ```bash
    ./mvnw exec:java -Dexec.mainClass="com.nexus.NexusApp"
    ```
    
## Roadmap
- [x] The Core
  - [x] Create `Book` data model with encapsulation
  - - [x] Implement `LibraryService` using `java.nio` for file scanning
  - [x] Build basic CLI for user interaction
  - [x] Unit Testing for Models and Services
- [ ] **Phase 2: Persistence (Next Step)**
    - [x] Integrate **SQLite** database to replace temporary memory.
    - [x] Implement `BookDAO` (Data Access Object) for SQL operations.
    - [x] Save scan results to the database (`nexus.db`)
    - [ ] Refactor Main CLI to use a Menu Loop (Interactive Mode).

- [ ] **Phase 3: Logic & State**
    - [ ] Track reading sessions (Start/Stop times)
    - [ ] Calculate "Time Spent" and "Average Speed"

- [ ] **Phase 4: Distribution**
    - [ ] Package as a standalone executable `.jar`

## Contributing
This project is currently for educational purposes. Suggestions and code reviews are welcome!

---
*Created by TsankoTsankov as part of the Java "Zero to Job Ready" journey.*