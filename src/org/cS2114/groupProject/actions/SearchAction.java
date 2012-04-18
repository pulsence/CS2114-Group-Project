package org.cS2114.groupProject.actions;

import org.cS2114.groupProject.Room;

// -------------------------------------------------------------------------
/**
 * Explores the room so that all the hidden actions are now available.
 *
 * @author Sean Meacham (sean22)
 * @author Tim Eck (etimot2)
 * @author Nate Tucker (imtucker)
 * @version Apr 17, 2012
 */
public class SearchAction
    extends BaseAction
{

    // ----------------------------------------------------------
    @Override
    public String getDescription()
    {
        return "Search this room";
    }


    // ----------------------------------------------------------
    @Override
    public boolean applyAction(Room room)
    {
        room.exploreRoom();
        return true;
    }

}
