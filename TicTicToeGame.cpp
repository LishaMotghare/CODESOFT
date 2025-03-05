#include <iostream>
#include <vector>

// Function to draw the game board
void drawBoard(const std::vector<std::vector<char>>& board) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            std::cout << board[i][j] << " ";
        }
        std::cout << std::endl;
    }
}

// Function to check if a player has won
bool checkWin(const std::vector<std::vector<char>>& board, char player) {
    // Check rows and columns
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
        if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
    }

    // Check diagonals
    if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
        (board[0][2] == player && board[1][1] == player && board[2][0] == player)) return true;

    return false;
}

// Function to check if the game is a draw
bool checkDraw(const std::vector<std::vector<char>>& board) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == '-') return false;
        }
    }
    return true;
}

int main() {
    std::vector<std::vector<char>> board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    char currentPlayer = 'X';

    while (true) {
        drawBoard(board);
        std::cout << "Player " << currentPlayer << "'s turn. Enter row and column (1-3): ";
        int row, col;
        std::cin >> row >> col;

        // Validate input
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            std::cout << "Invalid input. Please try again." << std::endl;
            continue;
        }

        // Check if position is already occupied
        if (board[row - 1][col - 1] != '-') {
            std::cout << "Position already occupied. Please try again." << std::endl;
            continue;
        }

        // Update board with player's move
        board[row - 1][col - 1] = currentPlayer;

        // Check if player has won
        if (checkWin(board, currentPlayer)) {
            drawBoard(board);
            std::cout << "Player " << currentPlayer << " wins!" << std::endl;
            break;
        }

        // Check if game is a draw
        if (checkDraw(board)) {
            drawBoard(board);
            std::cout << "It's a draw!" << std::endl;
            break;
        }

        // Switch players
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    return 0;
}
