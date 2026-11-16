package TicTacToeDesign;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToeGame {
    public Board board;
    public Queue<Player>players;
    public Integer size;

    public TicTacToeGame(int size){
        this.size=size;
        this.board=new Board(size);
        this.players=new LinkedList<>();
    }

    public void addPlayers(Player player){
        this.players.add(player);
    }

    public void startGame(){
        boolean winnerFoundOrDraw=false;
        while(winnerFoundOrDraw==false){
            Player currPlayer=players.poll();
            int x=-1,y=-1;
            Scanner sc=new Scanner(System.in);
            while((x<0 || y<0 || x>=size || y>=size) || (x>=0 && x<size && y>=0 && y<size && board.getPieceAtInd(x, y)!=null)){
                System.out.println("Hi "+currPlayer.name+ ". Enter valid position of x and y cordinates between 0 to size");
                x=sc.nextInt();
                y=sc.nextInt();

                if(x>=0 && x<size && y>=0 && y<size && board.getPieceAtInd(x, y)==null){
                    this.board.setPiece(x, y, currPlayer.piece);
                    this.board.printBoard();
                    break;
                }
            }

            if(checkWinner(board,currPlayer,x,y)){
                System.out.println("Winner found: "+currPlayer.name);
                winnerFoundOrDraw=true;
            }
            else if(checkDraw(board)){
                System.out.println("Game is drawn");
                winnerFoundOrDraw=true;
            }

            if(winnerFoundOrDraw==true) return;
            players.add(currPlayer);
        }
    }

    public boolean checkWinner(Board board,Player player,int x,int y){
        boolean drxn1=true, drxn2=true, drxn3=true, drxn4=true;
        Piece pieceAtIdx=board.getPieceAtInd(x, y);
        for(int i=0;i<size;i++){
            if(!pieceAtIdx.equals(board.getPieceAtInd(x, i))){
                drxn1=false;
            }
        }
        for(int i=0;i<size;i++){
            if(!pieceAtIdx.equals(board.getPieceAtInd(i, y))){
                drxn2=false;
            }
        }
        for(int i=0;i<size;i++){
            if(!pieceAtIdx.equals(board.getPieceAtInd(i, i))){
                drxn3=false;
            }
        }
        for(int i=0;i<size;i++){
            if(!pieceAtIdx.equals(board.getPieceAtInd(i, size-i-1))){
                drxn4=false;
            }
        }
        return drxn1 || drxn2 || drxn3 || drxn4;
    }

    public boolean checkDraw(Board board){
        boolean draw=true;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board.getPieceAtInd(i, j)==null){
                    draw=false;
                    return draw;
                }
            }
        }

        return draw;
    }

}
