#include <iostream>

// Function to add two numbers
double add(double num1, double num2) {
    return num1 + num2;
}

// Function to subtract two numbers
double subtract(double num1, double num2) {
    return num1 - num2;
}

// Function to multiply two numbers
double multiply(double num1, double num2) {
    return num1 * num2;
}

// Function to divide two numbers
double divide(double num1, double num2) {
    if (num2 == 0) {
        throw std::runtime_error("Cannot divide by zero!");
    }
    return num1 / num2;
}

int main() {
    double num1, num2;
    char operation;

    std::cout << "Simple Calculator Program" << std::endl;
    std::cout << "---------------------------" << std::endl;

    std::cout << "Enter the first number: ";
    std::cin >> num1;

    std::cout << "Enter the operation (+, -, *, /): ";
    std::cin >> operation;

    std::cout << "Enter the second number: ";
    std::cin >> num2;

    try {
        switch (operation) {
            case '+':
                std::cout << "Result: " << add(num1, num2) << std::endl;
                break;
            case '-':
                std::cout << "Result: " << subtract(num1, num2) << std::endl;
                break;
            case '*':
                std::cout << "Result: " << multiply(num1, num2) << std::endl;
                break;
            case '/':
                std::cout << "Result: " << divide(num1, num2) << std::endl;
                break;
            default:
                std::cout << "Invalid operation!" << std::endl;
                break;
        }
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }

    return 0;
}
