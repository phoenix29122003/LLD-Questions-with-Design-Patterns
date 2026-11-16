package TicTacToeDesign;

public class Board {
    public Piece[][] board;
    public int size;

    public Board(int size){
        this.size=size;
        this.board=new Piece[size][size];

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j]=null;
            }
        }
    }

    public Piece getPieceAtInd(int x,int y){
        return this.board[x][y];
    }

    public void setPiece(int x,int y,Piece piece){
        this.board[x][y]=piece;
    }

    public void printBoard(){
        System.out.println("Here is your printed board.");

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null) System.out.print("-");
                else System.out.print(board[i][j].toString());
            }
            System.out.println();
        }
    }
}
