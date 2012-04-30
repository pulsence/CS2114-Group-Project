package org.cS2114.groupProject.actions;

import org.cS2114.groupProject.NPC;
import org.cS2114.groupProject.Room;

// -------------------------------------------------------------------------
/**
 * Talks to the npc character.
 *
 * @author Sean Meacham (sean22)
 * @author Tim Eck (etimot2)
 * @author Nate Tucker (imtucker)
 * @version 2012.04.29
 */
public class TalkAction
    extends BaseAction
{
    private NPC npc;


    // ----------------------------------------------------------
    /**
     * Create a new TalkAction object.
     *
     * @param npc
     *            the npc to talk to.
     */
    public TalkAction(NPC npc)
    {
        this.npc = npc;
    }


    // ----------------------------------------------------------
    @Override
    public String getDescription()
    {
        return "get the message from " + npc.getCharacterName();
    }


    // ----------------------------------------------------------
    @Override
    public boolean applyAction(Room room)
    {
        room.setMessage(npc.getMessage());
        return false;
    }

}
