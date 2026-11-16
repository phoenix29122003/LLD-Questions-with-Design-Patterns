package TicTacToeDesign;

public class Main {
    public static void main(String args[]){
        Player manu=new Player("manu", Piece.X);
        Player tanu=new Player("tanu", Piece.O);

        TicTacToeGame game=new TicTacToeGame(3);
        game.addPlayers(manu);
        game.addPlayers(tanu);
        
        game.startGame();
    }
}
