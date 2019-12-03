package snakesAndLadders;

import main.snakesAndLadders.Snadder;
import org.junit.Test;
import static org.junit.Assert.*;


public class SnadderTest {

    /**
     * Test Snadder constructor
     */
    @Test
    public void snadderConstructor(){
        int index = 3;
        int ladderEnd = 5;
        int snakeEnd = 1;
        Snadder newSnadder = new Snadder(index);
        assertTrue(ladderEnd == newSnadder.getEnd() || snakeEnd == newSnadder.getEnd());
    }


}
