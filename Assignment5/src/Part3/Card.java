package Part3;

public class Card {

    public enum Color {BLACK, RED, YELLOW, GREEN, BLUE};
    public enum Type {WILD, WILD_4, DRAW_2, SKIP, REVERSE}

    public Card.Color color;
    public Card.Type type;
    public int points;

    public String getName(){
        return color.toString() + type.toString();
    }
}
