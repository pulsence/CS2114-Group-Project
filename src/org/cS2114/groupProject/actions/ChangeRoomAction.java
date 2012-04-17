package org.cS2114.groupProject.actions;

import org.cS2114.groupProject.Room;

// -------------------------------------------------------------------------
/**
 * Tells the game to update the room that the main character is currently in.
 *
 * @author Tim Eck II (etimot2)
 * @version Apr 17, 2012
 */
public class ChangeRoomAction
    extends BaseAction
{
    private int roomIndex;


    // ----------------------------------------------------------
    /**
     * Create a new ChangeRoomAction object.
     *
     * @param roomIndex
     *            of the room that this action will signal to move to.
     */
    public ChangeRoomAction(int roomIndex)
    {
        if (roomIndex < 0)
        {
            this.roomIndex = 0;
        }
        else if (roomIndex > 3)
        {
            this.roomIndex = 3;
        }
        else
        {
            this.roomIndex = roomIndex;
        }
    }


    // ----------------------------------------------------------
    @Override
    public String getDescription()
    {
        String description = "Go to the room to the ";
        if (roomIndex == 0)
        {
            description += "north";
        }
        else if (roomIndex == 1)
        {
            description += "east";
        }
        else if (roomIndex == 2)
        {
            description += "south";
        }
        else
        {
            description += "west";
        }

        return description;
    }


    // ----------------------------------------------------------
    @Override
    public boolean applyAction(Room room)
    {
        room.changeRoom(roomIndex);
        return false;
    }
}
