import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class DieTest {
    /**
     * Perform a valid die roll
     */
    @Test
    public void testDieRange(){
        // DieTest newDie =  new DieTest();
        Die die = new Die();
        int result = die.roll();
        assertTrue(1 <= result && result <= 6);
    }

    @Test
    public void testConstructor(){

    }

}
