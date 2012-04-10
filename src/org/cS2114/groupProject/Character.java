package org.cS2114.groupProject;

import java.util.ArrayList;

/**
 * This is the character class includes Name, StoredItems, Equipped Items
 *
 * @author Nate
 * @version 2012.4.10
 */

public class Character
{

    // the character health
    private float                         characterHealth;
    private ArrayList<BaseItem> storedItems;
    private ArrayList<BaseItem> equippedItems;


    /**
     * Creates a Character object.
     */
    public Character()
    {
        characterHealth = 100f;
        storedItems = new ArrayList<BaseItem>();
        equippedItems = new ArrayList<BaseItem>();
    }


    // ----------------------------------------------------------
    /**
     * Gets the amount of health the character has.
     *
     * @return the charachterHealth
     */
    public float getCharacterHealth()
    {
        return characterHealth;
    }


    // ----------------------------------------------------------
    /**
     * Gets the amount of health the character has.
     *
     * @param characterHealth
     *            the charachterHealth to set
     */
    public void setCharachterHealth(float characterHealth)
    {
        this.characterHealth = characterHealth;
    }


    /**
     * gets the stored Items
     *
     * @return the storedItems
     */
    public ArrayList<BaseItem> getStoredItems()
    {
        return storedItems;
    }


    /**
     * gets the stored Items
     *
     * @return the equippedItems
     */
    public ArrayList<BaseItem> getEquippedItems()
    {
        return equippedItems;
    }

}
