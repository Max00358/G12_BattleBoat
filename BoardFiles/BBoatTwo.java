//START program
//CREATE public static boolean check method so that this method can be used later on to determine if the coordinate that the user picks is the same as the random coordinate generated
	//SET the checkRandom value to false
	//CREATE a for loop that loops through all ten rolls and columns
	//IF the column and roll that the user clicked on is the same as the plugged in column and roll value, then set the checkRandom value to true
	//RETURN checkRandom value
//CREATE a main method
//CREATE a while loop that only stops looping through the entire program if restart doesn't equal to 1
//CONSTRUCT variables
//CREATE a nested for loop to make all boolean values in the 2D arrays false
//CREATE a for loop to generate 10 random column and random row values ranging from 0 to 10
//CREATE a while loop that stops looping if repeat is set to false
	//CONSTRUCT a nested for loop so that every element in randomRow and randomCol can be reached
	//IF randomRow on index c equals to randomRow on index r and randomCol on index c equals to randomCol on index r, then set randomCol on index c to 0 if randomCol equals to 9, else increase randomCol value on index c by 1
	//ELSE end the while loop
//INFORM the user about the basic rules of the battle boat game before they start playing
//CREATE a while loop that only ends if the unWon value is set to false
	//CREATE a for loop that loops 10 times so that if the user didn't win the game in ten clicks, the while loop would loop back to the for loop and the process starts again
	//CONSTRUCT variables
	//IF the check method returns true, and the 2D boolean array value on the coordinate that the user clicked on is true, then display message to tell user that this coordinate is already clicked on
	//CREATE an else if statement that states if the check method returns true, and the 2D boolean array value on the coordinate that the user clicked on is false, then put the "sheesh" emoji on the current coordinate that the user clicked on
	//VIBRATE the board 
	//INCREASE sheeshNum that represents the number of sheesh emoji that is added by 1
		//IF sheeshNum is less than 10, then play the background music named sheesh
	//SET the 2D boolean array value on the coordinate that the user clicked on to true
	//DISPLAY a message on the board to tell the user how many more targets they need to hit to win the game
		//IF sheeshNum equals to ten, then play the sound effect named letsGo and set the unWon value to false and set c value to 10 to end both the while loop and the for loop
		//ASK user if they want to play the game again.
		//COLLECT and store user input in a string named answer
			//IF user answers "yes", then the visibility of the previous board to false and set the restart value to 1 to continue the while loop that loops through the entire main method
			//ELSE thank the user for trying out the program and end the program
	//ELSE if the 2D boolean array value on the coordinate that the user clicked on is false, then put the cross on the coordinate that the user clicked on and display "Missed" on the board

import java.util.*;

public class BBoatTwo {
	
	//Create a public static boolean check method so that this method can be used later on to determine if the coordinate that the user picks is the same as the random coordinate generated
	public static boolean check(int[] row, int[] col, Coordinate click) {

		boolean checkRandom = false;
		
		//Create a for loop and an if statement within to see if the row and the column that the user clicked on is the same as the values that the index of row and col arrays refer to
		for (int i = 0; i < row.length; i++) {
			if (click.getRow() == row[i] && click.getCol() == col[i]) {
				checkRandom = true;//Change the checkRandom boolean value to true if the row & column that the user clicked on is the same as the input element in array row and col
			}
		}
		return checkRandom;
	}

	public static void main(String[] args) throws Exception {
	
		int restart = 1;
		
		while(restart == 1){//Create a while loop to loop the battle boat game
		
			//Construct variables
			Scanner userInput = new Scanner(System.in);
			boolean unWon = true;// variable to determine if game is over
			Random random = new Random();
			Board board = new Board(10, 10);//Build a Board object of 10 * 10 size.

			//Construct more variables
			int[] randomRow = new int[5];
			int[] randomCol = new int[5];
			int option = 0;
			int sheeshNum = 0;
			boolean[][] sheeshExist = new boolean[10][10];
			boolean repeat = true;
			String answer;
			Background sheesh = new Background("SHEESH2.wav");
			Background choral = new Background("sheeshChoral.wav");

			//Create a nested for loop to make all boolean values in the 2D array false
			for(int i = 0; i < sheeshExist.length; i++){
				for (int j = 0; j < sheeshExist[i].length; j++){
					sheeshExist[i][j] = false;
				}
			}
			
			//Generate one random number ranging from 1 to 4
			option = random.nextInt(4)+1;
			System.out.println(option);
			
			int pass = 1;
			int ran = random.nextInt(10);
			int col = random.nextInt(10);
			int row = random.nextInt(10);
			int counter = 0;
			System.out.println("first gen row: " + row);
			System.out.println("first gen col: " + col);
			
			//if option equals to 1, generate a horizontal ship
			if(option == 1){
				
				for(int i = 0; i < 5; i++){
					randomRow[i] = ran;
				}
				
				if(5 <= col && col <= 9){
					counter = 4;
					for(int i = col; i > col - 5; i--){
						randomCol[counter] = i;
						counter--;
					}
				}
				else if(0 <= col && col <= 4){
					counter = 0;
					for(int i = col; i < col + 5; i++){
						randomCol[counter] = i;
						counter++;
					}
				}
			}
			
			//else if option equals to 2, generate a vertical ship
			else if(option == 2){
			
				for(int i = 0; i < 5; i++){
					randomCol[i] = ran;
				}
				
				if(5 <= row && row <= 9){
					counter = 4;
					for(int i = row; i > row - 5; i--){
						randomRow[counter] = i;
						counter--;
					}
				}
				else if(0 <= row && row <= 4){
					counter = 0;
					for(int i = row; i < row + 5; i++){
						randomRow[counter] = i;
						counter++;
					}
				}
			}
			
			//else if option equals to 3, generate a diagonal ship that descend from left to right
			else if(option == 3){
				
				while(pass == 1){
					if(5 < col){
						col = random.nextInt(6);
					}
					else if(5 < row){
						row = random.nextInt(6);
					}
					else if(col <= 5 && row <= 5){
						pass = 0;
					}
				}
				
				counter = 0;
				for(int i = row; i < row + 5; i++){
					randomRow[counter] = i;
					counter++;
				}
				counter = 0;
				for(int i = col; i < col + 5; i++){
					randomCol[counter] = i;
					counter++;
				}
			}
			
			//else if option equals to 4, generate a diagonal ship that rises from left to right
			else if(option == 4){
				
				pass = 1;
				while(pass == 1){
					if(5 < col){
						col = random.nextInt(6);
					}
					else if(row < 4){
						row = random.nextInt(6) + 4;
					}
					else if(col <= 5 && 4 <= row && row <= 9){
						pass = 0;
					}
				}
				
				counter = 0;
				for(int i = row; i > row - 5; i--){
					randomRow[counter] = i;
					counter++;
				}
				counter = 0;
				for(int i = col; i < col + 5; i++){
					randomCol[counter] = i;
					counter++;
				}
			}
			
			System.out.println("row: " + row);
			System.out.println("col: " + col);
			
			System.out.println(Arrays.toString(randomRow));
			System.out.println(Arrays.toString(randomCol));
			
			//Create a for loop to generate 10 int elements into randomRow array and 10 int elements in randomCol array ranging from 0 to 9
			/*
			for (int i = 0; i < randomRow.length; i++){
				randomRow[i] = random.nextInt(10);
				randomCol[i] = random.nextInt(10);
			}
			*/
			
			//Introduce basic functions of battle boat to the player
			/*
			board.displayMessage("Welcome to Battle Boat");
			Thread.sleep(3000);
			board.displayMessage("Your goal is to find all 10 coordinates on which the targets are located");
			Thread.sleep(5000);
			board.displayMessage("If you hit the target, an emoji will be placed on your mouse's position");
			Thread.sleep(5000);
			board.displayMessage("If you miss the target, a cross will be placed on your mouse's position");
			Thread.sleep(5000);
			board.displayMessage("Good luck!");
			*/
			
			//Create a while loop so that if the user didn't win the game, the while loop would loop to allow the game to function until the user clicks all ten targets
			while (unWon) {
				
				//Create a for loop to run the code below ten times, and if the player still didn't win the game after the for loop ends, the while loop can allow the for loop 
				for (int c = 0; c < randomRow.length; c++) {

					Coordinate currentClick = board.getClick();//Get the coordinate where the user clicked (the mouse) on the board
					int currentCol = currentClick.getCol();//Get the column where the user clicked on the board
					int currentRow = currentClick.getRow();//Get the row where the user clicked on the board
					
					//If the check method returns a checkRandom value that's true and if the coordinate that the user clicked on on the boolean 2D array states "true", then tell user they already clicked on this target
					if (check(randomRow, randomCol, currentClick) == true && sheeshExist[currentClick.getRow()][currentClick.getCol()] == true) {
						board.displayMessage("You just hit this target, move on!");
					}
					//Else if the check method returns a checkRandom value that's true and if the coordinate that the user clicked on on the boolean 2D array states "false", then put a "sheesh" emoji because the user guessed the random coordinate
					else if (check(randomRow, randomCol, currentClick) == true && sheeshExist[currentClick.getRow()][currentClick.getCol()] == false) {
						board.putPeg(new Peg("sheesh.png"), currentClick.getRow(), currentClick.getCol());
						
						board.vibrate(10,5);//Vibrate the board for additional effects
						sheeshNum++;//Increase the sheeshNum integer value by 1
						
						//When the user guess the random coordinate and the total target that the user hit is less than 5, then play the background music named "sheesh" 
						if(sheeshNum < 5){
							sheesh.run();
						}
						
						//Turn the coordinate that the user clicked on on the boolean 2D array from "false" to "true" because a "sheesh" emoji is added
						sheeshExist[currentClick.getRow()][currentClick.getCol()] = true;
						board.displayMessage("Still need " + (5-sheeshNum) + " hits to win");//Inform user how many more targets they need to hit
						
						//If user hits all 5 targets, play the background music named "letsGo" and end the for loop as well as the while loop
						if (sheeshNum == 5) {
							choral.run();
							unWon = false;
							c = randomRow.length;
							board.displayMessage("Game Over, please check the console for more info");//Inform user the game is over
							
							//Ask user whether they want to play again, collect and store user inputs
							System.out.print("\033[H\033[2J");
							System.out.println("Do you want to play again? (yes / no)");
							answer = userInput.next();
							
							//If user answers "yes", then set the board to invisible so that when the new board is generated, the player wouldn't be distracted by the previous board
							if(answer.equalsIgnoreCase("yes")){
								board.setVisible(false);
								restart = 1;
							}
							//Else thank the user for trying out the game and end the program
							else{
								System.out.print("\033[H\033[2J");
								System.out.println("Thank you for trying out the program, goodbye!");
								System.exit(0);
							}
						}
					} 
					//Else if the coordinate that the user clicked on on the boolean 2D array states "false", then add a "cross" to coordinate that the user clicked on and display "Miss" on the board to tell the user that they missed the target
					else if (sheeshExist[currentClick.getRow()][currentClick.getCol()] == false) {
						board.putPeg(new Peg("cross.png"), currentClick.getRow(), currentClick.getCol());
						board.displayMessage("Miss");
					}
				}
			}
		}
	}
}