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
//CREATE an randomized integer ranged from 1 to 4
	//IF the integer is 1, then generate a horizontal carrier ship
	//ELSE if the integer is 2, then generate a vertical carrier ship
	//ELSE if the integer is 3, then generate a diagonal carrier ship that descends from left to right
	//ELSE if the integer is 4, then generate a diagonal carrier ship that rises from left to right
//CREATE another randomized integer ranged from 1 to 4
	//IF the integer is 1, then generate a horizontal battle ship
	//ELSE if the integer is 2, then generate a vertical battle ship
	//ELSE if the integer is 3, then generate a diagonal battle ship that descends from left to right
	//ELSE if the integer is 4, then generate a diagonal battle ship that rises from left to right
//CREATE another randomized integer ranged from 1 to 4
	//IF the integer is 1, then generate a horizontal cruiser ship
	//ELSE if the integer is 2, then generate a vertical cruiser ship
	//ELSE if the integer is 3, then generate a diagonal cruiser ship that descends from left to right
	//ELSE if the integer is 4, then generate a diagonal cruiser ship that rises from left to right
//CREATE another randomized integer ranged from 1 to 4
	//IF the integer is 1, then generate a horizontal submarine ship
	//ELSE if the integer is 2, then generate a vertical submarine ship
	//ELSE if the integer is 3, then generate a diagonal submarine ship that descends from left to right
	//ELSE if the integer is 4, then generate a diagonal submarine ship that rises from left to right
//CREATE another randomized integer ranged from 1 to 4
	//IF the integer is 1, then generate a horizontal destroyer ship
	//ELSE if the integer is 2, then generate a vertical destroyer ship
	//ELSE if the integer is 3, then generate a diagonal destroyer ship that descends from left to right
	//ELSE if the integer is 4, then generate a diagonal destroyer ship that rises from left to right
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

public class BBoatThree {
	
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
			int[] randomRow = new int[17];
			int[] randomCol = new int[17];
			int sheeshNum = 0;
			boolean[][] sheeshExist = new boolean[10][10];
			boolean[][] shipSpace = new boolean[10][10];
			String answer;
			Background sheesh = new Background("SHEESH2.wav");
			Background choral = new Background("sheeshChoral.wav");
			
			

			//Create a nested for loop to make all boolean values in the 2D array false
			for(int i = 0; i < sheeshExist.length; i++){
				for (int j = 0; j < sheeshExist[i].length; j++){
					sheeshExist[i][j] = false;
				}
			}
			
			//Create a nested for loop to make all boolean values in the shipSpace 2D array false
			for(int i = 0; i < shipSpace.length; i++){
				for (int j = 0; j < shipSpace[i].length; j++){
					shipSpace[i][j] = false;
				}
			}
			
			//Generate one random number ranging from 1 to 4 to determine the position of the carrier ship
			int option = random.nextInt(4)+1;
			System.out.print("\033[H\033[2J");
			System.out.println("There's nothing to look at here, play the game");
			
			int pass = 1;
			int ran = random.nextInt(10);
			int col = random.nextInt(10);
			int row = random.nextInt(10);
			int counter = 0;
			
			//if option equals to 1, generate a horizontal carrier ship
			if(option == 1){
				
				for(int i = 0; i < 5; i++){
					randomRow[i] = ran;
				}
				
				//if the random col integer is between 6 to 9 inclusive, then the rest of the coordinates of the ship is generated backwards. Turn the boolean value on the coordinates that the ship occupies into "true" on the 2D array
				if(6 <= col && col <= 9){
					counter = 4;
					for(int i = col; i > col - 5; i--){
						randomCol[counter] = i;
						counter--;
					}
					for(int i = 0; i < 5; i++){
						shipSpace[ran][col] = true;
						col--;
					}
				}
				//else if the random col integer is between 0 to 5 inclusive, then the rest of the ship is generated in a forward direction. Turn the boolean value on the coordinates that the ship occupies into "true" on the 2D array
				else if(0 <= col && col <= 5){
					counter = 0;
					for(int i = col; i < col + 5; i++){
						randomCol[counter] = i;
						counter++;
					}
					for(int i = 0; i < 5; i++){
						shipSpace[ran][col] = true;
						col++;
					}
				}
			}
			
			//else if option equals to 2, generate a vertical carrier ship
			else if(option == 2){
			
				for(int i = 0; i < 5; i++){
					randomCol[i] = ran;
				}
				
				//if the random row integer is between 6 to 9 inclusive, then the rest of the coordinates of the ship are generated upward/backwards. Turn the boolean value on the coordinates that the ship occupies into "true" on the 2D array
				if(6 <= row && row <= 9){
					counter = 4;
					for(int i = row; i > row - 5; i--){
						randomRow[counter] = i;
						counter--;
					}
					for(int i = 0; i < 5; i++){
						shipSpace[row][ran] = true;
						row--;
					}
				}
				//else if the random row integer is between 0 to 5 inclusive, then the rest of the coordinates of the ship is generated forward/downward. Turn the boolean value on the coordinates that the ship occupies into "true" on the 2D array
				else if(0 <= row && row <= 5){
					counter = 0;
					for(int i = row; i < row + 5; i++){
						randomRow[counter] = i;
						counter++;
					}
					for(int i = 0; i < 5; i++){
						shipSpace[row][ran] = true;
						row++;
					}
				}
			}
			
			//else if option equals to 3, generate a diagonal carrier ship that descend from left to right
			else if(option == 3){
				
				//Since the ship takes up five coordinates, if either col or row value is larger than 5, then a part of the ship body would go out of bound, thus a new col/row value needs to be generated
				//while loop only ends when both col and row values are less than or equal to 5
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
				
				//Generate the rest of the coordinates for the ship and turn the boolean value on the coordinates that the ship occupies into "true" on the 2D array
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
				for(int i = 0; i < 5; i++){
					shipSpace[row][col] = true;
					row++;
					col++;
				}
			}
			
			//else if option equals to 4, generate a diagonal carrier ship that rises from left to right
			else if(option == 4){
				
				//Since the ship takes up five coordinates, if col value is larger than 5 or if row value is less than 4, then a part of the ship body would go out of bound, thus a new col/row value needs to be generated
				//While loop only ends when both col and row values are in the wanted range
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
				
				//Generate the rest of the coordinates for the ship and turn the boolean value on the coordinates that the ship occupies into "true" on the 2D array
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
				for(int i = 0; i < 5; i++){
					shipSpace[row][col] = true;
					row--;
					col++;
				}
			}
			
			//Generate one random number ranging from 1 to 4 to determine the position of the battle ship
			int option2 = random.nextInt(4)+1;
			
			int passBattle = 1;
			int colBattle = 0;
			int rowBattle = 0;
			
			//if option equals to 1, generate a horizontal battle ship
			if(option2 == 1){
				
				while(passBattle == 1){
				
					colBattle = random.nextInt(10);
					rowBattle = random.nextInt(10);
				
					//Since this is a horizontal battleship, the randomly generated rowBattle value is the same for all 4 coordinates
					for(int i = 5; i < 9; i++){
						randomRow[i] = rowBattle;
					}
					
					//if the colBattle value is between 7 to 9 inclusive, then the rest of the colBattle value should be smaller to avoid coordinates generated outside the board
					if(7 <= colBattle && colBattle <= 9){
						counter = 8;
						for(int i = colBattle; i > colBattle - 4; i--){
							randomCol[counter] = i;
							counter--;
						}
						
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowBattle][colBattle] == false && shipSpace[rowBattle][colBattle-1] == false && shipSpace[rowBattle][colBattle-2] == false && shipSpace[rowBattle][colBattle-3] == false){
							for(int i = 0; i < 4; i++){
								shipSpace[rowBattle][colBattle] = true;
								colBattle--;
							}
							passBattle = 0;
						}
						else{
							passBattle = 1;
						}
					}
					//else if colBattle value is between 0 and 6 inclusive, then the colBattle value increases as index increases to avoid coordinates generated outside the board
					else if(0 <= colBattle && colBattle <= 6){
						counter = 5;
						for(int i = colBattle; i < colBattle + 4; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowBattle][colBattle] == false && shipSpace[rowBattle][colBattle+1] == false && shipSpace[rowBattle][colBattle+2] == false && shipSpace[rowBattle][colBattle+3] == false){
							for(int i = 0; i < 4; i++){
								shipSpace[rowBattle][colBattle] = true;
								colBattle++;
							}
							passBattle = 0;
						}
						else{
							passBattle = 1;
						}
					}
				}	
			}
			
			//else if option equals to 2, generate a vertical battle ship
			else if(option2 == 2){
			
				passBattle = 1;
				while(passBattle == 1){
				
					colBattle = random.nextInt(10);
					rowBattle = random.nextInt(10);
					
					//Since this is a horizontal battleship, the randomly generated colBattle value is the same for all 4 coordinates
					//Because all the rows/cols of the ships are in the same row/col array, therefore i value starts at 5(previous index is for the carrier ship)
					for(int i = 5; i < 9; i++){
						randomCol[i] = colBattle;
					}
					
					//if rowBattle value is between 7 to 9 inclusive, then the rest of the rowBattle value should decrease as index increase to avoid coordinates generated outside the board
					if(7 <= rowBattle && rowBattle <= 9){
						counter = 8;
						for(int i = rowBattle; i > rowBattle - 4; i--){
							randomRow[counter] = i;
							counter--;
						}
						
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowBattle][colBattle] == false && shipSpace[rowBattle-1][colBattle] == false && shipSpace[rowBattle-2][colBattle] == false && shipSpace[rowBattle-3][colBattle] == false){
							for(int i = 0; i < 4; i++){
								shipSpace[rowBattle][colBattle] = true;
								rowBattle--;
							}
							passBattle = 0;
						}
						else{
							passBattle = 1;
						}
					}
					//else if rowBattle value is between 0 and 6 inclusive, then the rowBattle value increases as index increases to avoid coordinates generated outside the board
					else if(0 <= rowBattle && rowBattle <= 6){
						counter = 5;
						for(int i = rowBattle; i < rowBattle + 4; i++){
							randomRow[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowBattle][colBattle] == false && shipSpace[rowBattle+1][colBattle] == false && shipSpace[rowBattle+2][colBattle] == false && shipSpace[rowBattle+3][colBattle] == false){
							for(int i = 0; i < 4; i++){
								shipSpace[rowBattle][colBattle] = true;
								rowBattle++;
							}
							passBattle = 0;
						}
						else{
							passBattle = 1;
						}
					}
				}	
			}
			
			//else if option equals to 3, generate a diagonal battle ship that descend from left to right
			else if(option2 == 3){
				
				passBattle = 1;
				while(passBattle == 1){
				
					colBattle = random.nextInt(10);
					rowBattle = random.nextInt(10);
					
					//if colBattle value is larger than 6, regenerate colBattle value to avoid out of bounds error later on
					if(6 < colBattle){
						colBattle = random.nextInt(7);//Generate random colBattle value from 0 to 6 inclusive
					}
					//else if rowBattle value is larger than 6, regenerate rowBattle value to avoid out of bounds error later on
					else if(6 < rowBattle){
						rowBattle = random.nextInt(7);
					}
					//else if colBattle and rowBattle values are less than or equal to 6, increase the colBattle and rowBattle value while the index increases during the input process
					else if(colBattle <= 6 && rowBattle <= 6){
						counter = 5;
						for(int i = rowBattle; i < rowBattle + 4; i++){
							randomRow[counter] = i;
							counter++;
						}
						counter = 5;
						for(int i = colBattle; i < colBattle + 4; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowBattle][colBattle] == false && shipSpace[rowBattle+1][colBattle+1] == false && shipSpace[rowBattle+2][colBattle+2] == false && shipSpace[rowBattle+3][colBattle+3] == false){
							for(int i = 0; i < 4; i++){
								shipSpace[rowBattle][colBattle] = true;
								rowBattle++;
								colBattle++;
							}
							passBattle = 0;
						}
						else{
							passBattle = 1;
						}
					}
				}
			}
			
			//else if option equals to 4, generate a diagonal battle ship that rises from left to right
			else if(option2 == 4){
			
				passBattle = 1;
				while(passBattle == 1){
				
					colBattle = random.nextInt(10);
					rowBattle = random.nextInt(10);
				
					//if colBattle value is larger than 6, regenerate colBattle value to avoid coordinates generated outside the board later on
					if(6 < colBattle){
						colBattle = random.nextInt(7);//Generate random colBattle value from 0 to 6 inclusive
					}
					//else if rowBattle value is less than 3, regenerate rowBattle value to avoid coordinates generated outside the board later on
					else if(rowBattle < 3){
						rowBattle = random.nextInt(7)+3;//Generate random colBattle value from 3 to 9 inclusive
					}
					//else if both values are in proper ranges, then increase the colBattle and decreases the rowBattle value while the index increases during the input process
					else if(colBattle <= 6 && 3 <= rowBattle){
						counter = 5;
						for(int i = rowBattle; i > rowBattle - 4; i--){
							randomRow[counter] = i;
							counter++;
						}
						counter = 5;
						for(int i = colBattle; i < colBattle + 4; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowBattle][colBattle] == false && shipSpace[rowBattle-1][colBattle+1] == false && shipSpace[rowBattle-2][colBattle+2] == false && shipSpace[rowBattle-3][colBattle+3] == false){
							for(int i = 0; i < 4; i++){
								shipSpace[rowBattle][colBattle] = true;
								rowBattle--;
								colBattle++;
							}
							passBattle = 0;
						}
						else{
							passBattle = 1;
						}
					}
				}
			}
			
			//Generate one random number ranging from 1 to 4 to determine the position of the CRUISER ship
			int option3 = random.nextInt(4)+1;
			
			int passCruiser = 1;
			int colCruiser = 0;
			int rowCruiser = 0;
			
			//if option equals to 1, generate a horizontal CRUISER ship
			if(option3 == 1){
				
				while(passCruiser == 1){
				
					colCruiser = random.nextInt(10);
					rowCruiser = random.nextInt(10);
					
					//insert randomly generated rowCruiser value from index 9 to index 11 of the randomRow array
					for(int i = 9; i < 12; i++){
						randomRow[i] = rowCruiser;
					}
					
					//if colCruiser value is between 8 and 9 inclusive, then decrease the colCruiser value when inserting those values into the randomCol array to avoid coordinates generated outside the board
					if(8 <= colCruiser && colCruiser <= 9){
						counter = 11;
						for(int i = colCruiser; i > colCruiser - 3; i--){
							randomCol[counter] = i;
							counter--;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowCruiser][colCruiser] == false && shipSpace[rowCruiser][colCruiser-1] == false && shipSpace[rowCruiser][colCruiser-2] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowCruiser][colCruiser] = true;
								colCruiser--;
							}
							passCruiser = 0;
						}
						else{
							passCruiser = 1;
						}
					}
					//else if colCruiser value is between 0 and 7 inclusive, then increase the colCruiser value when inserting those values into the randomCol array to avoid coordinates generated outside the board
					else if(0 <= colCruiser && colCruiser <= 7){
						counter = 9;
						for(int i = colCruiser; i < colCruiser + 3; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values to true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowCruiser][colCruiser] == false && shipSpace[rowCruiser][colCruiser+1] == false && shipSpace[rowCruiser][colCruiser+2] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowCruiser][colCruiser] = true;
								colCruiser++;
							}
							passCruiser = 0;
						}
						else{
							passCruiser = 1;
						}
					}
				}
			}
			
			//else if option equals to 2, generate a vertical CRUISER ship
			else if(option3 == 2){
			
				passCruiser = 1;
				while(passCruiser == 1){
				
					colCruiser = random.nextInt(10);
					rowCruiser = random.nextInt(10);
					
					//insert randomly generated colCruiser value from index 9 to index 11 of the randomCol array
					for(int i = 9; i < 12; i++){
						randomCol[i] = colCruiser;
					}
					
					//if the rowCruiser value is between 8 and 9 inclusive, then decrease the rowCruiser value while inserting them into the index of randomRow to avoid coordinates generated outside the board
					if(8 <= rowCruiser && rowCruiser <= 9){
						counter = 11;
						for(int i = rowCruiser; i > rowCruiser - 3; i--){
							randomRow[counter] = i;
							counter--;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values to true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowCruiser][colCruiser] == false && shipSpace[rowCruiser-1][colCruiser] == false && shipSpace[rowCruiser-2][colCruiser] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowCruiser][colCruiser] = true;
								rowCruiser--;
							}
							passCruiser = 0;
						}
						else{
							passCruiser = 1;
						}
					}
					//else if rowCruiser value is between 0 and 6 inclusive, increase the rowCruiser value while inputting it into the randomRow array to avoid coordinates generated outside the board
					else if(0 <= rowCruiser && rowCruiser <= 6){
						counter = 9;
						for(int i = rowCruiser; i < rowCruiser + 3; i++){
							randomRow[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowCruiser][colCruiser] == false && shipSpace[rowCruiser+1][colCruiser] == false && shipSpace[rowCruiser+2][colCruiser] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowCruiser][colCruiser] = true;
								rowCruiser++;
							}
							passCruiser = 0;
						}
						else{
							passCruiser = 1;
						}
					}
				}	
			}
			
			//else if option equals to 3, generate a diagonal CRUISER ship that descend from left to right
			else if(option3 == 3){
			
				passCruiser = 1;
				while(passCruiser == 1){
				
					colCruiser = random.nextInt(10);
					rowCruiser = random.nextInt(10);
					
					//if the value of colCruiser is larger than 7, then randomize colCruiser value so it falls within the range from 0 to 7 inclusive
					if(7 < colCruiser){
						colCruiser = random.nextInt(8);//Generate random colCruiser value from 0 to 7 inclusive
					}
					//else if the value of rowCruiser is larger than 7, then randomize rowCruiser value so it falls within the range from 0 to 7 inclusive
					else if(7 < rowCruiser){
						rowCruiser = random.nextInt(8);
					}
					//else if both values are within proper range, then increase the rowCruiser and colCruiser value while inputting them into the randomRow array to avoid coordinates generated outside the board
					else if(colCruiser <= 7 && rowCruiser <= 7){
						counter = 9;
						for(int i = rowCruiser; i < rowCruiser + 3; i++){
							randomRow[counter] = i;
							counter++;
						}
						counter = 9;
						for(int i = colCruiser; i < colCruiser + 3; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowCruiser][colCruiser] == false && shipSpace[rowCruiser+1][colCruiser+1] == false && shipSpace[rowCruiser+2][colCruiser+2] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowCruiser][colCruiser] = true;
								rowCruiser++;
								colCruiser++;
							}
							passCruiser = 0;
						}
						else{
							passCruiser = 1;
						}
					}
				}
			}
			
			//else if option equals to 4, generate a diagonal CRUISER ship that rises from left to right
			else if(option3 == 4){
			
				passCruiser = 1;
				while(passCruiser == 1){
				
					colCruiser = random.nextInt(10);
					rowCruiser = random.nextInt(10);
					
					//if colCruiser value is larger than 7, then randomize it so it falls within the range from 0 to 7 inclusive
					if(7 < colCruiser){
						colCruiser = random.nextInt(8);//Generate random colCruiser value from 0 to 7 inclusive
					}
					//else if rowCruiser value is less than 2, then randomize it so it falls within the range from 2 to 9 inclusive
					else if(rowCruiser < 2){
						rowCruiser = random.nextInt(8)+2;//Generate random colCruiser value from 2 to 9 inclusive
					}
					//else if both values are within proper range, then decrease the rowCruiser value and increase colCruiser value while inputting them into the randomRow array to avoid coordinates generated outside the board
					else if(colCruiser <= 9 && 2 <= rowCruiser){
						counter = 9;
						for(int i = rowCruiser; i > rowCruiser - 3; i--){
							randomRow[counter] = i;
							counter++;
						}
						counter = 9;
						for(int i = colCruiser; i < colCruiser + 3; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowCruiser][colCruiser] == false && shipSpace[rowCruiser-1][colCruiser+1] == false && shipSpace[rowCruiser-2][colCruiser+2] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowCruiser][colCruiser] = true;
								rowCruiser--;
								colCruiser++;
							}
							passCruiser = 0;
						}
						else{
							passCruiser = 1;
						}
					}
				}
			}
			
			int option4 = random.nextInt(4)+1;
			
			int passSub = 1;
			int colSub = 0;
			int rowSub = 0;
			
			//if option equals to 1, generate a horizontal submarine ship
			if(option4 == 1){
				
				while(passSub == 1){
				
					colSub = random.nextInt(10);
					rowSub = random.nextInt(10);
					
					//insert randomly generated rowSub value from index 12 to index 14 of the randomRow array
					for(int i = 12; i < 15; i++){
						randomRow[i] = rowSub;
					}
					
					//if colSub value is between 8 and 9 inclusive, then decrease the colSub value when inserting those values into the randomCol array to avoid coordinates generated outside the board
					if(8 <= colSub && colSub <= 9){
						counter = 14;
						for(int i = colSub; i > colSub - 3; i--){
							randomCol[counter] = i;
							counter--;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowSub][colSub] == false && shipSpace[rowSub][colSub-1] == false && shipSpace[rowSub][colSub-2] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowSub][colSub] = true;
								colSub--;
							}
							passSub = 0;
						}
						else{
							passSub = 1;
						}
					}
					//else if colSub value is between 0 and 7 inclusive, then increase the colSub value when inserting those values into the randomCol array to avoid coordinates generated outside the board
					else if(0 <= colSub && colSub <= 7){
						counter = 12;
						for(int i = colSub; i < colSub + 3; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowSub][colSub] == false && shipSpace[rowSub][colSub+1] == false && shipSpace[rowSub][colSub+2] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowSub][colSub] = true;
								colSub++;
							}
							passSub = 0;
						}
						else{
							passSub = 1;
						}
					}
				}
			}
			
			//else if option equals to 2, generate a vertical submarine ship
			else if(option4 == 2){
			
				passSub = 1;
				while(passSub == 1){
				
					colSub = random.nextInt(10);
					rowSub = random.nextInt(10);
					
					//insert randomly generated colSub value from index 12 to index 14 of the randomCol array
					for(int i = 12; i < 15; i++){
						randomCol[i] = colSub;
					}
					
					//if rowSub value is between 8 to 9 inclusive, then decrease the rowSub value when inserting those values into the randomRow array to avoid coordinates generated outside the board
					if(8 <= rowSub && rowSub <= 9){
						counter = 14;
						for(int i = rowSub; i > rowSub - 3; i--){
							randomRow[counter] = i;
							counter--;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowSub][colSub] == false && shipSpace[rowSub-1][colSub] == false && shipSpace[rowSub-2][colSub] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowSub][colSub] = true;
								rowSub--;
							}
							passSub = 0;
						}
						else{
							passSub = 1;
						}
					}
					//else if rowSub value is between 0 to 7 inclusive, then increase the rowSub value when inserting those values into the randomRow array to avoid coordinates generated outside the board
					else if(0 <= rowSub && rowSub <= 7){
						counter = 12;
						for(int i = rowSub; i < rowSub + 3; i++){
							randomRow[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowSub][colSub] == false && shipSpace[rowSub+1][colSub] == false && shipSpace[rowSub+2][colSub] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowSub][colSub] = true;
								rowSub++;
							}
							passSub = 0;
						}
						else{
							passSub = 1;
						}
					}
				}	
			}
			
			//else if option equals to 3, generate a diagonal submarine ship that descend from left to right
			else if(option4 == 3){
			
				passSub = 1;
				while(passSub == 1){
				
					colSub = random.nextInt(10);
					rowSub = random.nextInt(10);
					
					//if colSub value is larger than 7, randomize colSub value within range 0 to 7 inclusive
					if(7 < colSub){
						colSub = random.nextInt(8);//Generate random colSub value from 0 to 7 inclusive
					}
					//else if rowSub value is larger than 7, randomize rowSub value within range 0 to 7 inclusive
					else if(7 < rowSub){
						rowSub = random.nextInt(8);
					}
					//else if colSub and rowSub values are within proper range, increase the rowSub and colSub value when inserting those values into the randomRow array to avoid coordinates generated outside the board
					else if(colSub <= 7 && rowSub <= 7){
						counter = 12;
						for(int i = rowSub; i < rowSub + 3; i++){
							randomRow[counter] = i;
							counter++;
						}
						counter = 12;
						for(int i = colSub; i < colSub + 3; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowSub][colSub] == false && shipSpace[rowSub+1][colSub+1] == false && shipSpace[rowSub+2][colSub+2] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowSub][colSub] = true;
								rowSub++;
								colSub++;
							}
							passSub = 0;
						}
						else{
							passSub = 1;
						}
					}
				}
			}
			
			//else if option equals to 4, generate a diagonal submarine ship that rises from left to right
			else if(option4 == 4){
			
				passSub = 1;
				while(passSub == 1){
				
					colSub = random.nextInt(10);
					rowSub = random.nextInt(10);
					
					//if colSub value is larger than 7, then randomize colSub value within range 0 to 7 inclusive
					if(7 < colSub){
						colSub = random.nextInt(8);//Generate random colSub value from 0 to 7 inclusive
					}
					//else if rowSub value is less than 2, randomize rowSub value within range 2 to 9 inclusive
					else if(rowSub < 2){
						rowSub = random.nextInt(8)+2;//Generate random colSub value from 2 to 9 inclusive
					}
					//else if colSub and rowSub are in proper range, decrease the rowSub value and increase colSub value when inserting those values into the randomRow array to avoid coordinates generated outside the board
					else if(colSub <= 9 && 2 <= rowSub){
						counter = 12;
						for(int i = rowSub; i > rowSub - 3; i--){
							randomRow[counter] = i;
							counter++;
						}
						counter = 12;
						for(int i = colSub; i < colSub + 3; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowSub][colSub] == false && shipSpace[rowSub-1][colSub+1] == false && shipSpace[rowSub-2][colSub+2] == false){
							for(int i = 0; i < 3; i++){
								shipSpace[rowSub][colSub] = true;
								rowSub--;
								colSub++;
							}
							passSub = 0;
						}
						else{
							passSub = 1;
						}
					}
				}
			}
			
			int option5 = random.nextInt(4)+1;
			
			int passDe = 1;
			int colDe = 0;
			int rowDe = 0;
			
			//if option equals to 1, generate a horizontal destroyer ship
			if(option5 == 1){
				
				while(passDe == 1){
				
					colDe = random.nextInt(10);
					rowDe = random.nextInt(10);
					
					//insert randomly generated rowDe value from index 15 to index 16 of the randomRow array
					for(int i = 15; i < 17; i++){
						randomRow[i] = rowDe;
					}
					//if colDe value equals to 9, then decrease the colDe values while inserting those values into the randomCol array with decreasing index to avoid coordinates generated outside the board
					if(colDe == 9){
						counter = 16;
						for(int i = colDe; i > colDe - 2; i--){
							randomCol[counter] = i;
							counter--;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowDe][colDe] == false && shipSpace[rowDe][colDe-1] == false){
							for(int i = 0; i < 2; i++){
								shipSpace[rowDe][colDe] = true;
								colDe--;
							}
							passDe = 0;
						}
						else{
							passDe = 1;
						}
					}
					//else if colDe doesn't equal to 9, then increase the colDe values while inserting those values into the randomCol array with increasing index to avoid coordinates generated outside the board
					else if(colDe != 9){
						counter = 15;
						for(int i = colDe; i < colDe + 2; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowDe][colDe] == false && shipSpace[rowDe][colDe+1] == false){
							for(int i = 0; i < 2; i++){
								shipSpace[rowDe][colDe] = true;
								colDe++;
							}
							passDe = 0;
						}
						else{
							passDe = 1;
						}
					}
				}
			}
			
			//else if option equals to 2, generate a vertical destroyer ship
			else if(option5 == 2){
			
				passDe = 1;
				while(passDe == 1){
				
					colDe = random.nextInt(10);
					rowDe = random.nextInt(10);
				
					//insert randomly generated colDe value from index 15 to index 16 of the randomCol array
					for(int i = 15; i < 17; i++){
						randomCol[i] = colDe;
					}
					//if rowDe value equals to 9, then decrease the rowDe values while inserting those values into the randomRow array with decreasing index to avoid coordinates being generated outside the board
					if(rowDe == 9){
						counter = 16;
						for(int i = rowDe; i > rowDe - 2; i--){
							randomRow[counter] = i;
							counter--;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowDe][colDe] == false && shipSpace[rowDe-1][colDe] == false){
							for(int i = 0; i < 2; i++){
								shipSpace[rowDe][colDe] = true;
								rowDe--;
							}
							passDe = 0;
						}
						else{
							passDe = 1;
						}
					}
					//else if rowDe value doesn't equal to 9, then increase the rowDe values while inserting those values into the randomRow array with increasing index to avoid coordinates being generated outside the board
					else if(rowDe != 9){
						counter = 15;
						for(int i = rowDe; i < rowDe + 2; i++){
							randomRow[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowDe][colDe] == false && shipSpace[rowDe+1][colDe] == false){
							for(int i = 0; i < 2; i++){
								shipSpace[rowDe][colDe] = true;
								rowDe++;
							}
							passDe = 0;
						}
						else{
							passDe = 1;
						}
					}
				}	
			}
			
			//else if option equals to 3, generate a diagonal destroyer ship that descend from left to right
			else if(option5 == 3){
			
				passDe = 1;
				while(passDe == 1){
				
					colDe = random.nextInt(10);
					rowDe = random.nextInt(10);
					
					//if colDe value is larger than 8, then randomize it to be in 0~8 range
					if(8 < colDe){
						colDe = random.nextInt(9);//Generate random colDe value from 0 to 8 inclusive
					}
					//else if rowDe value is larger than 8, then randomize it to be in 0~8 range
					else if(8 < rowDe){
						rowDe = random.nextInt(9);
					}
					//else if both colDe and rowDe are within proper ranges, then increase both rowDe and colDe value while inserting them into randomRow and randomCol array with increasing index
					else if(colDe <= 8 && rowDe <= 8){
						counter = 15;
						for(int i = rowDe; i < rowDe + 2; i++){
							randomRow[counter] = i;
							counter++;
						}
						counter = 15;
						for(int i = colDe; i < colDe + 2; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowDe][colDe] == false && shipSpace[rowDe+1][colDe+1] == false){
							for(int i = 0; i < 2; i++){
								shipSpace[rowDe][colDe] = true;
								rowDe++;
								colDe++;
							}
							passDe = 0;
						}
						else{
							passDe = 1;
						}
					}
				}
			}
			
			//else if option equals to 4, generate a diagonal destroyer ship that rises from left to right
			else if(option5 == 4){
			
				passDe = 1;
				while(passDe == 1){
				
					colDe = random.nextInt(10);
					rowDe = random.nextInt(10);
					
					//if colDe value is larger than 8, then randomize it to be in 0~8 range
					if(8 < colDe){
						colDe = random.nextInt(9);//Generate random colDe value from 0 to 8 inclusive
					}
					//else if rowDe value is less than 1, then randomize it to be between 1 to 9
					else if(rowDe < 1){
						rowDe = random.nextInt(9)+1;//Generate random rowDe value from 1 to 9 inclusive
					}
					//else if both colDe and rowDe are both within range, then decrease the rowDe value and increase the colDe value when inputting them into randomRow and randomCol arrays with increasing index
					else if(colDe <= 8 && 1 <= rowDe){
						counter = 15;
						for(int i = rowDe; i > rowDe - 2; i--){
							randomRow[counter] = i;
							counter++;
						}
						counter = 15;
						for(int i = colDe; i < colDe + 2; i++){
							randomCol[counter] = i;
							counter++;
						}
						//if the boolean values of coordinates that the ship occupies on the 2D array are all false, then turn these values into true and end while loop, else generate new coordinates to make sure the coordinates do not overlap 
						if(shipSpace[rowDe][colDe] == false && shipSpace[rowDe-1][colDe+1] == false){
							for(int i = 0; i < 2; i++){
								shipSpace[rowDe][colDe] = true;
								rowDe--;
								colDe++;
							}
							passDe = 0;
						}
						else{
							passDe = 1;
						}
					}
				}
			}
			
			//Introduce basic functions of battle boat to the player
			/*
			board.displayMessage("Welcome to Battle Boat");
			Thread.sleep(3000);
			board.displayMessage("Your goal is to find all 17 coordinates on which the targets are located");
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
						if(sheeshNum < 17){
							sheesh.run();
						}
						
						//Turn the coordinate that the user clicked on on the boolean 2D array from "false" to "true" because a "sheesh" emoji is added
						sheeshExist[currentClick.getRow()][currentClick.getCol()] = true;
						board.displayMessage("Still need " + (17-sheeshNum) + " hits to win");//Inform user how many more targets they need to hit
						
						//If user hits all 5 targets, play the background music named "letsGo" and end the for loop as well as the while loop
						if (sheeshNum == 17) {
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