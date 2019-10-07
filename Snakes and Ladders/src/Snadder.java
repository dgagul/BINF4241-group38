public class Snadder extends Square {
    boolean isSnadder;
    int end;

    Snadder(int i, boolean ladderorsnadder) {
        super(i);
        isSnadder = true;
        if (ladderorsnadder) {
            end = i + 2;
        } else {
            end = i - 2;
        }

    }

    ;
};