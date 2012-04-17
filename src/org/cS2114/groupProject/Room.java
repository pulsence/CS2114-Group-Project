package org.cS2114.groupProject;

import org.cS2114.groupProject.actions.BaseAction;
import java.util.ArrayList;
import java.util.Observable;

// -------------------------------------------------------------------------
/**
 * Room class. This is the base data type that will be used to build the levels.
 *
 * @author Tim Eck II (etimot2)
 * @version Apr 16, 2012
 */
public class Room extends Observable
{
    private ArrayList<BaseAction> hiddenActions;
    private ArrayList<BaseAction> currentActions;
    private Character             mainCharacter;
    private ArrayList<NPC>        npcs;
    private Room[]                linkedRooms;


    // ----------------------------------------------------------
    /**
     * Create a new Room object.
     */
    public Room()
    {
        hiddenActions = new ArrayList<BaseAction>();
        currentActions = new ArrayList<BaseAction>();
        mainCharacter = new Character();
        setNpcs(new ArrayList<NPC>());
        setLinkedRooms(new Room[4]);
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
}
