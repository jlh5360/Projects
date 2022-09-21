package minesweeper.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class MinesweeperTest {


    //This tests the attributes of a brand new Minesweeper instance
    @Test
    public void testNewMinesweeper(){
        //setup
        Minesweeper minesweeper = new Minesweeper(4, 4, 4);

        //analyze
//once we develop Minesweeper, we will have more tests

        assertEquals(minesweeper.getMoveCount(), 0);
        assertEquals(minesweeper.getGameState(), GameState.NOT_STARTED);
        assertEquals(minesweeper.getPossibleSelections().size(), 12);
    }

    @Test
    public void testInvalidMoveRange() {
        Minesweeper minesweeper = new Minesweeper(4, 4, 4);
        Location invalid = new Location(-1, 0, '0');

        try{
            minesweeper.makeSelection(invalid);
            assertTrue(false);
        } catch(MinesweeperException e) {
            assertTrue(true);
        }
    }

    public void testInvalidMoveAlreadySelected() {
        Minesweeper minesweeper = new Minesweeper(4, 4, 4);
        Location move = new Location(0, 0, '0');

        try{
            minesweeper.makeSelection(move);
            minesweeper.makeSelection(move);
            assertTrue(false);
        } catch(MinesweeperException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFirstMove() {
        Minesweeper minesweeper = new Minesweeper(4, 4, 4);
        Location move = new Location(2, 2, '0');

        try{
            minesweeper.makeSelection(move);
        } catch(MinesweeperException e) {
            assertTrue(false);
        }

        assertEquals(minesweeper.getMoveCount(), 1);
        assertEquals(minesweeper.getGameState(), GameState.IN_PROGRESS);
        assertEquals(minesweeper.getPossibleSelections().size(), 11);
        assertTrue(!minesweeper.getPossibleSelections().contains(move));
    }
    
    @Test
    public void testHint(){
        //getPossibleSelections is accessed by the hintButton, and displays
        //a guarenteed safe selection :)
        Minesweeper minesweeper = new Minesweeper(4, 4, 4);

        Collection<Location> safeLocation = minesweeper.getPossibleSelections();

        assertTrue(!safeLocation.iterator().next().isMine());
    }
}
