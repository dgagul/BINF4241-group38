package snakesAndLadders;

import main.snakesAndLadders.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class SquareTest {
    /**
     * Test Square constructor
     */
    @Test
    public void squareConstructor(){
        int index = 1;
        Square testSquare = new Square(index);
        assertEquals(index, testSquare.getNumber());
        assertTrue(!testSquare.getIsOccupied());
    }



}
