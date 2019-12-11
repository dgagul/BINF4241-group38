package Part3;

public class Card {

    public enum Color {BLACK, RED, YELLOW, GREEN, BLUE}
    public enum Type {NORMAL, WILD, WILD_4, DRAW_2, SKIP, REVERSE}

    public Color color;
    public Type type;
    public int points = -1;

    public Card(Color color, Type type, int points){
        this.color = color;
        this.type = type;
        this.points = points;
    }

    public String getName(){
        return color.toString() + type.toString();
    }
}
