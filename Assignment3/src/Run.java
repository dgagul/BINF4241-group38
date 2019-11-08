public class Run {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        Observer printer = new Printer(game.getBoard());
        Observer scoreboard = new Scoreboard(Game.getPlayerWhite(), Game.getPlayerBlack());
        Game.registerObserver(printer);
        Game.registerObserver(scoreboard);
        Game.play();
    }
}
