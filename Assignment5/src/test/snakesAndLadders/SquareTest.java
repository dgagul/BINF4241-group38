package snakesAndLadders;

import main.snakesAndLadders.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class SquareTest {

    @Test
    public void shouldNotAllowNegativeNumbers() throws Exception{
        Square square = new Square(-1);
        assertTrue(0 <= square.number);



    }

}
