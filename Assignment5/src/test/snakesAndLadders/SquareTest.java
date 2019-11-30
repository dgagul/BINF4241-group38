package snakesAndLadders;

import main.snakesAndLadders.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class SquareTest {

    @Test
    public void squareConstructor(){
        int index = 1;
        Square testSquare = new Square(index);
        assertEquals(index, testSquare.number);
        assertTrue(!testSquare.isOccupied);
    }



}
