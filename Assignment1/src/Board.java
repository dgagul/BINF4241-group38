import java.util.Random;

public class Board {
    int boardsize;
    Object[] squares;
    StringBuilder boardview;
    FirstSquare firstsquare;
    LastSquare lastsquare;

    public Board(int boardsize){
        this.boardsize = boardsize;
        squares = new Object[boardsize];
    }

    public Object[] initializeSquares() {
        firstsquare = new FirstSquare(1);
        squares[0] = firstsquare;
        for (int i = 1; i < boardsize - 1; i++) {
            Square square = new Square(i + 1);
            squares[i] = square;
        }
        lastsquare = new LastSquare(boardsize);
        squares[boardsize] = lastsquare;
        return squares;
    }

    public void setSnakesAndLadders() {
        if (boardsize > 9) {
            for (int j = 3; j < boardsize - 4; j += 5) {
                Snadder snadder = new Snadder(j);
                squares[j] = snadder;
            }
        }
        else if (boardsize > 4) {
                Snadder snadder = new Snadder(2);
                snadder.isLadder = true;
                squares[2] = snadder;
            }
    }

    public StringBuilder calculateBoard() {
        for (int i = 0; i < boardsize; i++) {
            boardview = new StringBuilder();
            boardview.append("[");

            if (squares[i].isOccupied) {
                boardview.append(squares[i].number);
                for (int j = 0; j < squares[i].occupants.size(); j++) {
                    if (squares[i].occupants[j]) {
                        boardview.append("<" + squares[i].occupants[j] + ">");
                    }
                }
                boardview.append("]");
            }
            else if (squares[i].isSnadder) {
                if (squares[i].isLadder) {
                    boardview.append(squares[i].number + "->" + squares[i].end + "] ");
                }
                else {
                    boardview.append(squares[i].end + "<-" + squares[i].number + "] ");
                }
            }
            else {
                boardview.append("] ");
            }
        }
        return boardview;
    }
}
