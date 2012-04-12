package org.cS2114.groupProject;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Sean Meacham
 * @version Apr 10, 2012
 */

public class NPC
    extends Character
{
    private float   npcHealth;
    private boolean canFight;
    private boolean canTalk;
    private String  message;


    // ----------------------------------------------------------
    /**
     * Create a new NPC object.
     */
    public NPC()
    {
        npcHealth = 100f;
        message = null;
        canFight = false;
        canTalk = false;
    }


    // ----------------------------------------------------------
    /**
     * Gets the amount of health the NPC has.
     *
     * @return the npcHealth
     */
    public float getNPCHealth()
    {
        return npcHealth;
    }


    // ----------------------------------------------------------
    /**
     * Gets the amount of health the NPC has.
     *
     * @param npcHealth
     *            the npcHealth to set
     */
    public void setNPCHealth(float npcHealth)
    {
        this.npcHealth = npcHealth;
    }


    // ----------------------------------------------------------
    /**
     * Gets the message that the NPC has.
     *
     * @return message the message that the NPC has.
     */
    public String getMessage()
    {
        return message;
    }


    // ----------------------------------------------------------
    /**
     * Sets the message that the NPC has.
     *
     * @param message
     */
    public void setMessage(String message)
    {
        this.message = message;
    }


    // ----------------------------------------------------------
    /**
     * Determines if the NPC can fight
     *
     * @return canFight true if the NPC can fight and false otherwise
     */
    public boolean canFight()
    {
        return canFight;
    }


    // ----------------------------------------------------------
    /**
     * Determines if the NPC can talk
     *
     * @return canTalk true if the NPC has a message and can talk, false
     *         otherwise
     */
    public boolean canTalk()
    {
        if (message != null)
        {
            return canTalk;
        }
        else
        {
            return false;
        }
    }
}
