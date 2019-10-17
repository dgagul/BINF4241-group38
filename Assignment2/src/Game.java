public class Game{
    private static boolean isFinished = false;
    private Player playerWhite;
    private Player playerBlack;
    private Board board;

    public Game(){
        playerWhite = new Player(Player.Color.WHITE);
        playerBlack = new Player(Player.Color.BLACK);
        board = new Board();
    }

    public static void main(String args[]) {
        Game game = new Game();


        //currentPlayer = player1;
    }
}
