public class Snadder extends Square {
    boolean isSnadder;
    int end;

    Snadder(int i, boolean isLadder) {
        super(i);
        isSnadder = true;
        if (isLadder) {
            end = i + 2;
        } else {
            end = i - 2;
        }

    }

}