public class Snadder extends Square {
    boolean isSnadder;
    int end;

    Snadder(int i, boolean isLadder) {
        super(i);
        isSnadder = true;
        if (isLadder) {
            this.end = i + 2;
        } else {
            this.end = i - 2;
        }

    }

}