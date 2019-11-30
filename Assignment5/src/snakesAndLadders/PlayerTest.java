package snakesAndLadders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.SortedMap;

import main.snakesAndLadders.*;



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
        assertEquals(name, testPlayer.getName());
        assertEquals(position, testPlayer.getPosition()); }

    //@Rule
    //public ExpectedException thrown = ExpectedException.none();
    @Test
    public void PlayerMakeMove()  {
        Game testGame = new Game(5, "Diego", "Lara", "None", "None");
        Player testPlayer = new Player("Diego", 0);



    }


}

