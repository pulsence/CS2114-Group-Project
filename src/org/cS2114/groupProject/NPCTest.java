package org.cS2114.groupProject;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * This is a test class for the NPC class.
 *
 * @author Sean Meacham
 * @version Apr 20, 2012
 */

public class NPCTest
    extends TestCase
{
    private NPC npc;


    // ----------------------------------------------------------
    protected void setUp()
    {
        npc = new NPC();
    }


    /**
     * Test method for {@link org.cS2114.groupProject.NPC#NPC()}.
     */
    public void testNPC()
    {
        assertEquals(100f, npc.getNPCHealth());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.NPC#getNPCHealth()}.
     */
    public void testGetNPCHealth()
    {
        assertEquals(100f, npc.getNPCHealth());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.NPC#setNPCHealth(float)}.
     */
    public void testSetNPCHealth()
    {
        npc.setNPCHealth(75f);
        assertEquals(75f, npc.getNPCHealth());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.NPC#getMessage()}.
     */
    public void testGetMessage()
    {
        npc.setMessage("Message");
        assertEquals("Message", npc.getMessage());
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.NPC#setMessage(java.lang.String)}.
     */
    public void testSetMessage()
    {
        npc.setMessage("Message2");
        assertEquals("Message2", npc.getMessage());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.NPC#canFight()}.
     */
    public void testCanFight()
    {
        assertFalse(npc.canFight());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.NPC#canTalk()}.
     */
    public void testCanTalk()
    {
        assertFalse(npc.canTalk());
    }

}
