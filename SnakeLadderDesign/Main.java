package SnakeLadderDesign;

public class Main {
    public static void main(String args[]){
        Player manu=new Player("manu");
        Player tanu=new Player("tanu");

        SnakeLadder game=new SnakeLadder(100, 6);
        game.addPlayers(manu);
        game.addPlayers(tanu);

        game.initializeGame();
        game.printBoard();

        game.startGame();
    }
}
