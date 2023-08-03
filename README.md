# Tic-Tac-Toe
Tic Tac Toe Game

The provided Java code implements a simple command-line Tic Tac Toe game between a player and a computer. The game is played on a 3x3 grid, where the player uses 'X' and the computer uses 'O'. The game board is displayed with numbers representing each cell, which the player uses to make their move. The program handles invalid inputs and informs the player about erroneous positions. After each move, the board is printed to show the current state of the game. The game continues until a player wins, loses, or the board is filled (a tie).

How to Play:
1. The game board is represented by a 3x3 grid, with each cell numbered from 1 to 9.
2. At the beginning, the player is asked to make a move by entering a number from 1 to 9.
3. The player's move is marked with 'X' on the game board.
4. The computer makes its move randomly by selecting an unoccupied cell (numbered 1 to 9).
5. The game continues with the player and computer taking turns until a winner is determined or the board is full.

How it's Played with this Code:
1. The program initializes the game board with empty cells and the display board with cell numbers.
2. The game starts by showing the display board and instructions to the player.
3. The player makes a move by entering a number representing their choice.
4. The program checks for invalid moves and keeps asking for input until a valid move is made.
5. Once the player's move is validated, it is placed on the game board and added to the player's positions list.
6. The program then checks if the player wins, loses, or ties the game based on the current positions.
7. If the game is not over, the computer makes a move by randomly selecting an unoccupied cell.
8. The program then checks again if the computer wins, the player loses, or the game ties.
9. The game continues until one of the players wins or the board is filled (tie).
10. The program prints the final result of the game and exits.

Based on the tutorial by Alex Lee on YouTube:
https://www.youtube.com/watch?v=gQb3dE-y1S4&ab_channel=AlexLee 
