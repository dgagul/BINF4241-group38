import java.util.Random;

public class Snadder extends Square {
    boolean isLadder;
    boolean isSnadder;
    int end;

    Snadder(int i) {
        super(i);
        isSnadder = true;
        Random random = new Random();
        isLadder = random.nextBoolean();
        if (isLadder) {
            isLadder = true;
            this.end = i + 2;
        } else {
            this.end = i - 2;
            isLadder = false;
        }

    }




}