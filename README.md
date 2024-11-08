# To-Do List Application

## Overview

This is a simple, intuitive to-do list application built in Java with JavaFX. The application enables users to manage their tasks effectively by adding, editing, marking as complete, and deleting tasks. It leverages design patterns like MVC, Singleton, Observer, and Strategy to ensure scalability, maintainability, and clean separation of concerns.

## Table of Contents

1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Design Patterns](#design-patterns)
4. [Project Structure](#project-structure)
5. [Setup and Installation](#setup-and-installation)
6. [Usage](#usage)
7. [Limitations](#limitations)
8. [Future Improvements](#future-improvements)
9. [Contributing](#contributing)
10. [License](#license)

## Features

- **Add Task**: Create a new task with details such as name, description, deadline, and priority.
- **Edit Task**: Modify details of an existing task.
- **Mark as Completed**: Mark tasks as completed to keep track of progress.
- **Delete Task**: Remove tasks from the list.
- **User-Friendly Interface**: Simple and easy-to-navigate interface built with JavaFX.

## Technologies Used

- **Java**: Core language for application logic.
- **JavaFX**: Used for the graphical user interface.
- **Maven**: Build tool for dependency management and project setup.

## Design Patterns

This project implements the following design patterns to maintain clean code architecture:

- **MVC (Model-View-Controller)**: Separates the application into three main components to manage data, display, and user interaction separately.
- **Singleton**: Ensures that only one instance of the `TaskManager` class (responsible for managing tasks) exists across the application.
- **Observer**: Enables automatic UI updates when changes occur in the task list.
- **Strategy**: Allows switching between different strategies for task management, such as sorting tasks by priority, due date, or category.

## Project Structure

The project is organized as follows:


## Setup and Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/mshadiyar/todo-list-app.git
   cd todo-list-app
