public class Printer implements Observer{

    private Board board;
    private Square[][] squares;

    public Printer(Board newBoard){
        this.board = newBoard;
        this.squares = board.getBoard();
    }

    public void update(){
        for (int i = 7; i >=0; i--) {
            for (int k = 0; k <=7; k++) {
                Piece currPiece = squares[k][i].getPiece();
                if(currPiece != null){
                    System.out.print("[" + currPiece.toString() + "] ");
                }
                else {
                    System.out.print("[  ] ");
                }
            }
            System.out.println(" ");
        }
    }

}
