import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.SortedMap;


public class PlayerTest {

    /**
     * Test Player Constructor
     *
     */
    @Test
    public void PlayerConstructor(){
        String name = "Diego";
        int position = 1;
        Player testPlayer = new Player(name, position);
        assertEquals(name, testPlayer.name);
        assertEquals(position, testPlayer.getPosition());
    }

    //@Rule
    //public ExpectedException thrown = ExpectedException.none();

}

