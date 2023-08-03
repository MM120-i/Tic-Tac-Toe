package project;

import java.util.*;

public class TicTacToe {
	
	private static ArrayList<Integer> playerPositions = new ArrayList<Integer>(); 
	private static ArrayList<Integer> CPUPositions = new ArrayList<Integer>(); 	

	public static void main(String[] args) throws Exception {
		
		char[][] gameBoard = { 
				
				{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '} 
		 };
		
        char[][] display = { 
				
				{'1', '|', '2', '|', '3'}, 
				{'-', '+', '-', '+', '-'}, 
				{'4', '|', '5', '|', '6'},
				{'-', '+', '-', '+', '-'}, 
				{'7', '|', '8', '|', '9'} 
		 };
		
		printGameBoard(display);
		
		System.out.println("\nSee the game board layout above.\n"
				+ "Every number you input (between 1 - 9), your choice gets stored in that section of the board.\n"
				+ "You are 'X', and the computer is '0'. \n"
				+ "And you know the rest of the rules of tic tac toe....\n");
			
		while (true) {
			
		    @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);

		    System.out.println("Your turn: ");
		    int playerPosition = scan.nextInt();

		    while (playerPositions.contains(playerPosition) || CPUPositions.contains(playerPosition)) {
		    	
		        errorMessage();
		        playerPosition = scan.nextInt();
		    }

		    placePiece(gameBoard, playerPosition, "Player");

		    String result = winner();
		    if (!result.isEmpty()) {
		        System.out.println(result);
		        break;
		        
		    } else {
		        int CPUPosition;
		        do {
		        	
		            CPUPosition = new Random().nextInt(9) + 1;
		            
		        } while (playerPositions.contains(CPUPosition) || CPUPositions.contains(CPUPosition));

		        placePiece(gameBoard, CPUPosition, "CPU");
		        printGameBoard(gameBoard);

		        result = winner();
		        
		        if (!result.isEmpty()) {
		            System.out.println(result);
		            break;
		            
		        }
		    }
		}
	
	}
	
	public static void errorMessage() {
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(3) + 1;
		
		if(randomNumber == 1) {
			
			System.out.println("Invalid position. Enter a correct positon bitch ass");
		}
		else if(randomNumber == 2) {
			
			System.out.println("Bro, the computer literally placed an input there.");
		}
		else if(randomNumber == 3) {
			
			System.out.println("No man...");
		}
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		
	    int i = 0;
	    
	    while (i < gameBoard.length) {
	    	
	        int j = 0;
	        while (j < gameBoard[i].length) {
	        	
	            System.out.print(gameBoard[i][j]);
	            j++;
	        }
	        
	        System.out.println();
	        i++;
	    }
	}

	
	public static void placePiece(char[][] gameBoard, int position, String user) {
		
	    char symbol = ' ';

	    if (user.equals("Player")) {
	    	
	        symbol = 'X';
	        playerPositions.add(position);
	    } else if (user.equals("CPU")) {
	    	
	        symbol = 'O';
	        CPUPositions.add(position);
	    }

	    switch (position) {
	        case 1:
	            gameBoard[0][0] = symbol;
	            break;
	            
	        case 2:
	            gameBoard[0][2] = symbol;
	            break;
	            
	        case 3:
	            gameBoard[0][4] = symbol;
	            break;
	            
	        case 4:
	            gameBoard[2][0] = symbol;
	            break;
	            
	        case 5:
	            gameBoard[2][2] = symbol;
	            break;
	            
	        case 6:
	            gameBoard[2][4] = symbol;
	            break;
	            
	        case 7:
	            gameBoard[4][0] = symbol;
	            break;
	            
	        case 8:
	            gameBoard[4][2] = symbol;
	            break;
	            
	        case 9:
	            gameBoard[4][4] = symbol;
	            break;
	            
	        default:
	            break;
	    }
	}
	
	//@SuppressWarnings("rawtypes")
    public static String winner() {
		
		String result = new String("");
		
		 LinkedList<LinkedList<Integer>> win = new LinkedList<>();

		    win.add(new LinkedList<>(Arrays.asList(1, 2, 3))); // Top Row
		    win.add(new LinkedList<>(Arrays.asList(4, 5, 6))); // Middle Row
		    win.add(new LinkedList<>(Arrays.asList(7, 8, 9))); // Bottom Row

		    win.add(new LinkedList<>(Arrays.asList(1, 4, 7))); // Left Column
		    win.add(new LinkedList<>(Arrays.asList(2, 5, 8))); // Middle Column
		    win.add(new LinkedList<>(Arrays.asList(3, 6, 9))); // Right Column

		    win.add(new LinkedList<>(Arrays.asList(1, 5, 9))); // Diagonal 1
		    win.add(new LinkedList<>(Arrays.asList(7, 5, 3))); // Diagonal 2
		    
		    Iterator<LinkedList<Integer>> iterator = win.iterator();

		    while (iterator.hasNext()) {
		    	
		        LinkedList<Integer> list = iterator.next();

		        if (playerPositions.containsAll(list)) {
		        	
		            result = "You won!";
		            break;
		        } else if (CPUPositions.containsAll(list)) {
		        	
		            result = "You lost...";
		            break;
		        }
		    }

		    if (result.isEmpty() && playerPositions.size() + CPUPositions.size() == 9) {
		    	
		        result = "Tie";
		    }

		    return result;
	}

}
