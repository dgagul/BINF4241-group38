
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String color;
    private String name;
    private String c_color;
    private String c_name;

    private List<Piece> rest_pieces = new ArrayList<>();
    private List<Piece> eaten_pieces = new ArrayList<>();


    public Player(String playercolor, String playername) {
        color = playercolor;
        name = playername;
        c_color = color;
        c_name = name; }

        // getter just returning copys
    public String getIswhite(){
        return c_color; }

    public String getName(){
        return c_name; }

    public List<Piece> getRest_pieces() {
        return new ArrayList<Piece>(rest_pieces); }

    public List<Piece> getEaten_pieces_pieces() {
        return new ArrayList<Piece>(rest_pieces);}
    /*
    private final int PAWNS = 8;
    private final int BISHOPS = 2;
    private final int ROOKS = 2;
    public void initializePieces(){
        if(this.white == true){
            for(int i=0; i<PAWNS; i++){ // draw pawns
                pieces.add(new Pawn(true,i,2));
            }
            pieces.add(new Rook(true, 0, 0));
            pieces.add(new Rook(true, 7, 0));
            pieces.add(new Bishop(true, 2, 0));
            pieces.add(new Bishop(true, 5, 0));
            pieces.add(new Knight(true, 1, 0));
            pieces.add(new Knight(true, 6, 0));
            pieces.add(new Queen(true, 3, 0));
            pieces.add(new King(true, 4, 0));
        }
        else{
            for(int i=0; i<PAWNS; i++){ // draw pawns
                pieces.add(new Pawn(true,i,6));
            }
            pieces.add(new Rook(true, 0, 7));
            pieces.add(new Rook(true, 7, 7));
            pieces.add(new Bishop(true, 2, 7));
            pieces.add(new Bishop(true, 5, 7));
            pieces.add(new Knight(true, 1, 7));
            pieces.add(new Knight(true, 6, 7));
            pieces.add(new Queen(true, 3, 7));
            pieces.add(new King(true, 4, 7));
        }

    }*/
}