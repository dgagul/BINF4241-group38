import java.util.Random;

class Snadder extends Square {
    int end;

    Snadder(int i) {
        super(i);
        Random random = new Random();
        boolean isLadder = random.nextBoolean();
        if (isLadder) {
            end = number + 2;
        } else {
            end = number - 2;
        }

    }

}