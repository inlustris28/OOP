import java.util.Scanner;

public class Tictactoe{

    public static boolean gameEnd = false;

    public static Scanner scanner = new Scanner(System.in);

    
    public static char papan[] = 
    {'_','_','_', 
    '_','_','_', 
    '_','_','_'};

    public static boolean isTie(){
        int length = 9;
        
        for (int i = 0; i < 9; i++){
            if (papan[i] != '_') length -= 1;
        }

        if (length <= 0 && !checkWin('O') && !checkWin('X')) return true;

        return false;
    }

    public static int winningMoves[][] = {
        {0,3,6}, {1,4,7}, {2,5,8}, // vertical
        {0,1,2}, {3,4,5}, {6,7,8}, // horizontal
        {6,7,8}, {0,4,8}, {2,4,6} // diagonal
    };

    public static int giliran = 0; 
    // jika 0 == player 1 (O); jika 1 == player 2 (X)

    public static void main(String[] args){
        startGame();
    }

    public static void printPapan(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(papan[i*3 + j]);
                System.out.print(" ");
            }

            System.out.println("");
        }
    }

    public static char getPlayerSign(){
        return giliran == 0? 'O' : 'X';
    };

    public static boolean checkWin(char playerSign){

        boolean win = false;

        for (int i = 0; i < 8; i++){
            boolean valid = true;

            for (int j = 0; j < 3; j++){
                if (papan[winningMoves[i][j]] != playerSign) valid = false;
            }
            
            if (valid){
                win = true;
                break;
            }

        }
        return win;
    }

    public static boolean placeMove(int x, int y){
        if (x < 0 || x > 2 || y < 0 || y > 2) return false;
        if (papan[y*3 + x] != '_') return false;
        
        papan[y*3 + x] = getPlayerSign();
        return true;
    }

    public static String getPlayerName(){

        return giliran == 0 ? "Player 1" : "Player 2";
    }

    public static void play(){
        int x;
        int y;
        boolean validMove;

        // place move
        do { 
            System.out.println((giliran == 0 ? "Player 1" : "Player 2") + " move: " );
            
            x = scanner.nextInt();
            y = scanner.nextInt();
            
            validMove = placeMove(x,y);
            
            if (!validMove){
                System.out.println("You can't insert this tile");
            }
            
            printPapan();
            
        } while (validMove == false);
        

        // check win
        if (checkWin(getPlayerSign())){
            System.out.println(getPlayerName() + " WIN");
            
            gameEnd = true;
            return;
        }

        // check tie
        if (isTie()){
            System.out.println("Game is Tie");
            
            gameEnd = true;
            return;
        }

        if (giliran == 0) giliran = 1;
        else giliran = 0;
    }

    public static void startGame(){
        System.out.println("Welcome to the TicTacToe Game!");
        
        while (!gameEnd) { 
            play();  
        }

    }
}