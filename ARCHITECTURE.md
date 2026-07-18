# Architecture

Atlas Cyberdeck follows a layered architecture.
UI
│
├── Dashboard
├── Linux
├── Terminal
├── Files
├── SSH
│
▼
Repositories
│
▼
Domain Models
│
▼
System Services

Business logic is separated from the user interface whenever possible.

The objective is to keep the application modular, maintainable, and portable across future platforms.