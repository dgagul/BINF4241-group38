public class Run {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        Observer printer = new Printer(game.getBoard());
        Game.registerObserver(printer);
        Game.play();
    }
}
