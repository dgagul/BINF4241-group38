import java.util.ArrayList;
import java.util.List;

public class Player {

    private boolean iswhite;
    private boolean isChecked;
    private String name;

    private List<Piece> rest_pieces = new ArrayList<>();
    private List<Piece> eaten_pieces = new ArrayList<>();


    public Player(boolean whiteplayer, String playername) {
        iswhite = whiteplayer;
        isChecked = false;
        name = playername;
 }

    public boolean getIswhite(){
        boolean c_iswhite = iswhite;
        return c_iswhite; }

    public String getName(){
        String c_name = name;
        return c_name; }

    public List<Piece> getRest_pieces() {
        return new ArrayList<Piece>(rest_pieces); }

    public List<Piece> getEaten_pieces_pieces() {
        return new ArrayList<Piece>(rest_pieces);}
}