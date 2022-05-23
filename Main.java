import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // Importing ArrayList For Usage of List Interface
import java.util.Arrays; // Imports Array Class to Store Multiple Strings


class Main {
    // Creates ArrayLists of Wordle Potential Solutions and Valid Guesses
    static ArrayList <String> validSolutions = new ArrayList<String>();
    static ArrayList <String> validGuesses = new ArrayList<String>();

    static int solutionNum = 1 + (int)(Math.random() * 2315); // generates a random number (index) for all possible solutions
    static String randomSolution;

    public static void main(String[] args)
    {

    // Reads the Text Files Given for Valid Guesses and Solutions
        readFiles();
        
        // Uses BoardPlay Class to Actually Run the Game of Wordle and Introduces the User to The Game
        System.out.println("\u001B[40m"+ "Welcome to WORDLE!");
        BoardPlay game = new BoardPlay();
        game.makeBoard(6);
        int row = 0;

        // Checks for the Amount of Rounds (Columns) Played Compared to Total Amount and Then Either Ends or Continues the Game
        while(true){
          game.requestWord(row);
          
          if(Arrays.equals(game.boardMaker[row], randomSolution.toCharArray())){
            System.out.println("Congratulations! The word was..." + randomSolution + "! \n" + "The game has ended!");
            break;
          }
          else if(row >= (game.getRound()-1)){
            System.out.println("Every row has been filled... The game has ended! \n" + "The word was "+ randomSolution);
            break;
          }

          if(!Arrays.equals(game.nothing, game.boardMaker[row])){
            row++;
          }           
          
        }

    }

    // This Function Reads the Given Text Files for Valid Solutions and Guesses to Use Within the Game of Wordle
    public static void readFiles(){
        File vGuessesFile = new File("valid_guesses.txt");
        File vSolutionsFile = new File("valid_solutions.txt");

        try {
            Scanner solutionReader = new Scanner(vSolutionsFile);
            while (solutionReader.hasNextLine()) {
                validSolutions.add(solutionReader.nextLine());
            }
            solutionReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            Scanner guessesReader = new Scanner(vGuessesFile);
            while (guessesReader.hasNextLine()) {
                validGuesses.add(guessesReader.nextLine());
            }
            guessesReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        randomSolution = validSolutions.get(solutionNum);

    }
  
  // Splitting up the validGuesses text file into 26 groups to make the sorting of the file quicker (checking for approxmiately 730 words at a time rather than 12,900 at once).  
  public static boolean checkGuess(String input){
    boolean flag = false;
    switch(input.charAt(0)){
      case 'a':
        for (int i=1; i<= 737; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }     
        }
        break;
      case 'b':
        for (int i=738; i<= 1646; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }  
        }  
        break;
      case 'c':
        for (int i=1647; i<= 2568; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'd':
        for (int i=2569; i<= 3253; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'e':
        for (int i=3254; i<= 3556; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'f':
        for (int i=3557; i<= 4153; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'g':
        for (int i=4154; i<= 4791; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'h':
        for (int i=4792; i<= 5280; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'i':
        for (int i=5281; i<= 5445; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'j':
        for (int i=5446; i<= 5647; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'k':
        for (int i=5648; i<= 6023 ; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'l':
        for (int i=6024; i<= 6600; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'm':
        for (int i=6601; i<= 7293; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'n':
        for (int i= 7294; i<= 7618 ; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'o':
        for (int i=7619; i<= 7880; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'p':
        for (int i=7881; i<= 8739; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'q':
        for (int i=8740; i<= 8817; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'r':
        for (int i=8818; i<= 9445; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 's':
        for (int i= 9446; i<= 11010; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 't':
        for (int i=11011; i<= 11825; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'u':
        for (int i=11826; i<= 12014; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'v':
        for (int i=12015; i<= 12256; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'w':
        for (int i=12257; i<= 12669; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'x' :
        for (int i=12670; i<= 12685; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'y':
        for (int i=12686; i<= 12866; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      case 'z':
        for (int i=12867; i<= 12971; i++){
          if (validGuesses.get(i).equals(input)){
            flag= true;
            break;
          }
        }
        break;
      default: 
        System.out.println("You have not input a char...");
        break;
    }
    return flag;
  }
}
