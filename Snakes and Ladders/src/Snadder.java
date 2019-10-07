public class Snadder extends Square {
    boolean isSnadder;
    int end;

    Snadder(int i, boolean ladderorsnadder) {
        super(i);
        isSnadder = true;
        if (ladderorsnadder) {
            this.end = i + 2;
        } else {
            this.end = i - 2;
        }

    }

    ;
};