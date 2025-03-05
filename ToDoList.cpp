#include <iostream>
#include <vector>
#include <string>

// Structure to represent a task
struct Task {
    std::string description;
    bool isCompleted;
};

// Function to add a task to the list
void addTask(std::vector<Task>& tasks) {
    Task newTask;
    std::cout << "Enter task description: ";
    std::getline(std::cin, newTask.description);
    newTask.isCompleted = false;
    tasks.push_back(newTask);
}

// Function to view tasks in the list
void viewTasks(const std::vector<Task>& tasks) {
    std::cout << "Task List:" << std::endl;
    for (size_t i = 0; i < tasks.size(); i++) {
        std::cout << (i + 1) << ". " << tasks[i].description;
        if (tasks[i].isCompleted) {
            std::cout << " (Completed)";
        } else {
            std::cout << " (Pending)";
        }
        std::cout << std::endl;
    }
}

// Function to mark a task as completed
void markTaskAsCompleted(std::vector<Task>& tasks) {
    viewTasks(tasks);
    int taskNumber;
    std::cout << "Enter task number to mark as completed: ";
    std::cin >> taskNumber;
    std::cin.ignore(); // Ignore newline character
    if (taskNumber > 0 && taskNumber <= tasks.size()) {
        tasks[taskNumber - 1].isCompleted = true;
    } else {
        std::cout << "Invalid task number." << std::endl;
    }
}

// Function to remove a task from the list
void removeTask(std::vector<Task>& tasks) {
    viewTasks(tasks);
    int taskNumber;
    std::cout << "Enter task number to remove: ";
    std::cin >> taskNumber;
    std::cin.ignore(); // Ignore newline character
    if (taskNumber > 0 && taskNumber <= tasks.size()) {
        tasks.erase(tasks.begin() + taskNumber - 1);
    } else {
        std::cout << "Invalid task number." << std::endl;
    }
}

int main() {
    std::vector<Task> tasks;
    int choice;

    while (true) {
        std::cout << "To-Do List Manager" << std::endl;
        std::cout << "1. Add Task" << std::endl;
        std::cout << "2. View Tasks" << std::endl;
        std::cout << "3. Mark Task as Completed" << std::endl;
        std::cout << "4. Remove Task" << std::endl;
        std::cout << "5. Exit" << std::endl;
        std::cout << "Enter your choice: ";
        std::cin >> choice;
        std::cin.ignore(); // Ignore newline character

        switch (choice) {
            case 1:
                addTask(tasks);
                break;
            case 2:
                viewTasks(tasks);
                break;
            case 3:
                markTaskAsCompleted(tasks);
                break;
            case 4:
                removeTask(tasks);
                break;
            case 5:
                return 0;
            default:
                std::cout << "Invalid choice. Please try again." << std::endl;
        }
    }

    return 0;
}
