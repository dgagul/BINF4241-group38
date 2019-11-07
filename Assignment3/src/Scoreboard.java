import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scoreboard implements Observer {
    private Map<Player, Integer> scoreList = new HashMap<>();
    private Player white;
    private Player black;
    private ArrayList<Piece> capturedWhite = new ArrayList<>();
    private ArrayList<Piece> capturedBlack = new ArrayList<>();

    public Scoreboard(Player white, Player black) {
        this.white = white;
        this.black = black;
        scoreList.put(white, 0);
        scoreList.put(black, 0);
    }

    @Override
    public void update(Color.color color) {
        ArrayList<Piece> newCapturedWhite = white.getCaptured_pieces();
        ArrayList<Piece> newCapturedBlack = black.getCaptured_pieces();

        if(didCapture(capturedWhite, newCapturedWhite) || didCapture(capturedBlack, newCapturedBlack)){
            Piece captured;
            Player p;
            if(color == Color.color.WHITE){
                p = white;
                captured = newCapturedBlack.get(newCapturedBlack.size() - 1);
                capturedBlack.add(captured);
            }
            else{
                p = black;
                captured = newCapturedWhite.get(newCapturedWhite.size() - 1);
                capturedWhite.add(captured);
            }

            if(captured.getClass() == Queen.class){
                scoreList.put(p, scoreList.get(p) + 5);
            }
            else{
                scoreList.put(p, scoreList.get(p) + 1);
            }
        }
        printScoreboard();
    }

    private boolean didCapture(ArrayList oldList, ArrayList newList) {
        return oldList.size() != newList.size();
    }

    private void printScoreboard(){
        System.out.format("\n%s's score: %d.\n", white.getName(), scoreList.get(white));
        System.out.format("%s's score: %d.\n\n", black.getName(), scoreList.get(black));
    }
}
