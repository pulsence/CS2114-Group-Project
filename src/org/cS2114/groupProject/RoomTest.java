package org.cS2114.groupProject;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.cS2114.groupProject.actions.BaseAction;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Sean Meacham
 *  @version Apr 20, 2012
 */

public class RoomTest
    extends TestCase
{
    private Room room;
    private NPC npc;
    private NPC npc2;
    private Character character;
    private Character character2;
    private ArrayList<NPC> npcs;
    private BaseAction action1;
    private BaseAction action2;
    private ArrayList<BaseAction> currentActions;
    private ArrayList<BaseAction> hiddenActions;
    private Room[] rooms;

    // ----------------------------------------------------------
    protected void setUp()
    {
        room = new Room();
        npcs = new ArrayList<NPC>();
        rooms = new Room[4];
        currentActions = new ArrayList<BaseAction>();
        hiddenActions = new ArrayList<BaseAction>();
        room.setMainCharacter(character);
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#Room()}.
     */
    public void testRoom()
    {
        assertEquals(4, room.getLinkedRooms().length);
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#getCurrentActions()}.
     */
    public void testGetCurrentActions()
    {
        currentActions.add(action1);
        assertEquals(1, currentActions.size());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#setCurrentActions(java.util.ArrayList)}.
     */
    public void testSetCurrentActions()
    {
        currentActions.add(action1);
        room.setCurrentActions(currentActions);
        assertEquals(1, room.getCurrentActions().size());

    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#getHiddenActions()}.
     */
    public void testGetHiddenActions()
    {
        hiddenActions.add(action2);
        room.setHiddenActions(hiddenActions);
        assertEquals(1, room.getHiddenActions().size());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#setHiddenActions(java.util.ArrayList)}.
     */
    public void testSetHiddenActions()
    {
        hiddenActions.add(action2);
        room.setHiddenActions(hiddenActions);
        assertEquals(1, room.getHiddenActions().size());
    }



    /**
     * Test method for {@link org.cS2114.groupProject.Room#getMainCharacter()}.
     */
    public void testGetMainCharacter()
    {
        assertEquals(character, room.getMainCharacter());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#setMainCharacter(org.cS2114.groupProject.Character)}.
     */
    public void testSetMainCharacter()
    {
        room.setMainCharacter(character2);
        assertEquals(character2, room.getMainCharacter());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#getNpcs()}.
     */
    public void testGetNpcs()
    {
        npcs.add(npc);
        room.setNpcs(npcs);
        assertEquals(1, room.getNpcs().size());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#setNpcs(java.util.ArrayList)}.
     */
    public void testSetNpcs()
    {
        npcs.add(npc2);
        room.setNpcs(npcs);
        assertEquals(1, npcs.size());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#getLinkedRooms()}.
     */
    public void testGetLinkedRooms()
    {
        room.setLinkedRooms(rooms);
        assertEquals(4, room.getLinkedRooms().length);
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#setLinkedRooms(org.cS2114.groupProject.Room[])}.
     */
    public void testSetLinkedRooms()
    {
        room.setLinkedRooms(rooms);
        assertEquals(4, room.getLinkedRooms().length);
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Room#exploreRoom()}.
     */
    public void testExploreRoom()
    {
        hiddenActions.add(action1);
        hiddenActions.add(action2);
        room.setHiddenActions(hiddenActions);
        room.exploreRoom();
        assertEquals(0, room.getHiddenActions().size());
        assertEquals(2, room.getCurrentActions().size());
    }

}
