package org.cS2114.groupProject;

import java.util.ArrayList;
import java.util.Observable;
import org.cS2114.groupProject.actions.BaseAction;

// -------------------------------------------------------------------------
/**
 * Room class. This is the base data type that will be used to build the levels.
 *
 * @author Sean Meacham (sean22)
 * @author Tim Eck (etimot2)
 * @author Nate Tucker (imtucker)
 * @version Apr 16, 2012
 */
public class Room
    extends Observable
{
    private ArrayList<BaseAction> hiddenActions;
    private ArrayList<BaseAction> currentActions;
    private Character             mainCharacter;
    private ArrayList<NPC>        npcs;
    private Room[]                linkedRooms;
    private boolean               explored;

    private boolean               changeRoom;
    private boolean               hasMessage;
    private String                message;


    // ----------------------------------------------------------
    /**
     * Create a new Room object.
     */
    public Room()
    {
        hiddenActions = new ArrayList<BaseAction>();
        currentActions = new ArrayList<BaseAction>();
        mainCharacter = new Character();
        npcs = new ArrayList<NPC>();
        linkedRooms = new Room[4];
        explored = false;

        changeRoom = false;
        hasMessage = false;
    }


    // ----------------------------------------------------------
    /**
     * @return the currentActions
     */
    public ArrayList<BaseAction> getCurrentActions()
    {
        return currentActions;
    }


    // ----------------------------------------------------------
    /**
     * @param currentActions
     *            the currentActions to set
     */
    public void setCurrentActions(ArrayList<BaseAction> currentActions)
    {
        this.currentActions = currentActions;
    }


    // ----------------------------------------------------------
    /**
     * Gets the room state.
     *
     * @return true if the room has been explored.
     */
    public boolean getRoomState()
    {
        return explored;
    }


    // ----------------------------------------------------------
    /**
     * Sets the room as explored.
     */
    public void setRoomState()
    {
        explored = true;
    }


    // ----------------------------------------------------------
    /**
     * @return the hiddenActions
     */
    public ArrayList<BaseAction> getHiddenActions()
    {
        return hiddenActions;
    }


    // ----------------------------------------------------------
    /**
     * @param hiddenActions
     *            the hiddenActions to set
     */
    public void setHiddenActions(ArrayList<BaseAction> hiddenActions)
    {
        this.hiddenActions = hiddenActions;
    }


    // ----------------------------------------------------------
    /**
     * @return the mainCharacter
     */
    public Character getMainCharacter()
    {
        return mainCharacter;
    }


    // ----------------------------------------------------------
    /**
     * @param mainCharacter
     *            the mainCharacter to set
     */
    public void setMainCharacter(Character mainCharacter)
    {
        this.mainCharacter = mainCharacter;
    }


    // ----------------------------------------------------------
    /**
     * @return the npcs
     */
    public ArrayList<NPC> getNpcs()
    {
        return npcs;
    }


    // ----------------------------------------------------------
    /**
     * @param npcs
     *            the npcs to set
     */
    public void setNpcs(ArrayList<NPC> npcs)
    {
        this.npcs = npcs;
    }


    // ----------------------------------------------------------
    /**
     * @return the linkedRooms
     */
    public Room[] getLinkedRooms()
    {
        return linkedRooms;
    }


    // ----------------------------------------------------------
    /**
     * @param linkedRooms
     *            the linkedRooms to set
     */
    public void setLinkedRooms(Room[] linkedRooms)
    {
        this.linkedRooms = linkedRooms;
    }


    // ----------------------------------------------------------
    /**
     * Explores a room and then places all the hidden actions into the current
     * actions list.
     */
    public void exploreRoom()
    {
        currentActions.addAll(hiddenActions);
        hiddenActions.clear();
    }


    /**
     * Tells the room that an action has requested that it change to a new room.
     * The objects observing this class will be notified and passed the int
     * value for the next room to go to.
     *
     * @param nextRoom
     *            The next room to go to.
     */
    public void changeRoom(int nextRoom)
    {
        if (nextRoom < 0 || nextRoom > 3)
        {
            return;
        }

        changeRoom = true;
        setChanged();
        notifyObservers(nextRoom);
    }


    // ----------------------------------------------------------
    /**
     * Determines if the room should be changed.
     *
     * @return true if the room should be changed.
     */
    public boolean shouldChangeRoom()
    {
        return changeRoom;
    }


    // ----------------------------------------------------------
    /**
     * Sets if the room should be changed or not.
     *
     * @param change
     *            true to change.
     */
    public void setChangeRoom(boolean change)
    {
        changeRoom = change;
    }


    // ----------------------------------------------------------
    /**
     * There is a message for the player.
     * @return true is there is a message.
     */
    public boolean hasMessage()
    {
        return hasMessage;
    }


    // ----------------------------------------------------------
    /**
     * Removes the message from this room.
     */
    public void eraseMessage()
    {
        message = "";
        hasMessage = false;
    }


    // ----------------------------------------------------------
    /**
     * Gets the message for this room.
     * @return the message.
     */
    public String getMessage()
    {
        return message;
    }


    // ----------------------------------------------------------
    /**
     * Sets the message for the room.
     * @param message to set.
     */
    public void setMessage(String message)
    {
        this.message = message;
        hasMessage = true;
        setChanged();
        notifyObservers();
    }
}
