import java.util.Scanner; // Imports Scanners to Be Used For Inputs in the Code
import java.util.Arrays; // Imports the Array Class's methods to use in the code.

// Board Play Class Allows the Game to Be Played
public class BoardPlay{
    // Creates an Unchangeable Integer Which Represents the Letter Count for Each Word
    final int LETTERNUM = 5;
    int round = 6;

    // Creates Various Character Arrays Which Store the Solution and Guesses
    char[] solution = new char[5];
    char[] copyArr = new char[5]; //solution but sorted
  
    char[] nothing = {'_','_','_','_','_'};

    // Creates an Array of Vertical Length Round and Horizontal Length LETTERNUM (5)
    char[][] boardMaker = new char [round][LETTERNUM];


    // Creates the Board Which the User Will Use to Play Wordle
    public void makeBoard(int round){
        solution = Main.randomSolution.toCharArray();
        //System.out.println(solution); //for testing ~~~ PRINTS OUT SOLUTION
      
        copyArr = Arrays.copyOf(solution,5);
        //Arrays.sort(copyArr);
        //System.out.println(copyArr);
         
      
        for (int i = 0; i < round; i++){
            for (int j = 0; j < LETTERNUM; j++){
                boardMaker[i][j] = '_';
            }
        }
        displayBoard();
    }
  
  // Displays Visually to the User the Board Which Was Created to Play the Game
  public void displayBoard(){
      for (int i = 0; i < round; i++){
          for (int j = 0; j < LETTERNUM; j++){
            System.out.print(colorPicker(boardMaker[i][j], j) + "[" + boardMaker[i][j] + "] ");
          }
          System.out.println("\u001B[40m");
          
          copyArr = Arrays.copyOf(solution,5);
          Arrays.sort(copyArr);
        }
  }

  // Takes in the User's Guess for the Wordle Game and Checks if it Is Valid 
  public void requestWord(int row){
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Input a 5 letter word:");
    String tempWord = sc.next();
    
    if (tempWord.length() != 5){
      System.out.println("Your String is not 5 char long. Try again...");
    }else if(Main.checkGuess(tempWord)){
        System.out.println("You have used a valid guess!");
        boardMaker[row] = tempWord.toCharArray(); 
        displayBoard();  
    }else{
      System.out.println("Invalid guess! Try again...");
    }
    
  }

  public String colorPicker(char currentChar, int index){
    String ANSI_BLACK_BACKGROUND = "\u001B[40m"; // default color for letter
    String ANSI_RED_BACKGROUND = "\u001B[41m"; // red is when letter is wrong/not used
    String ANSI_GREEN_BACKGROUND = "\u001B[42m"; // green is when letter is in the right place
    String ANSI_YELLOW_BACKGROUND = "\u001B[43m"; // yellow is when letter is used but in the wrong place
    
    if (currentChar == solution[index]){
      //copyArr[Arrays.binarySearch(copyArr,currentChar)] = '_'; 
      //System.out.println(copyArr);
      return ANSI_GREEN_BACKGROUND;
    }
    else if(currentChar == '_'){
      return ANSI_BLACK_BACKGROUND;
    }else if(Arrays.binarySearch(copyArr,currentChar) >= 0){
      //copyArr[Arrays.binarySearch(copyArr,currentChar)] = '_'; 
      //System.out.println(copyArr);
      return ANSI_YELLOW_BACKGROUND;
    }else{
      return ANSI_RED_BACKGROUND;
    }
  }

  public int getRound(){
    return round;
  }
}