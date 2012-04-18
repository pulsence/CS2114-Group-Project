package org.cS2114.groupProject;

import java.util.ArrayList;
import org.cS2114.groupProject.items.BaseItem;

/**
 * This is the character class includes Name, StoredItems, Equipped Items
 *
 * @author Sean Meacham (sean22)
 * @author Tim Eck (etimot2)
 * @author Nate Tucker (imtucker)
 * @version 2012.4.10
 */
public class Character
{

    // the character health
    private float               characterHealth;
    private ArrayList<BaseItem> storedItems;
    private ArrayList<BaseItem> equippedItems;
    private String              characterName;


    /**
     * Creates a Character object.
     */
    public Character()
    {
        characterHealth = 100f;
        storedItems = new ArrayList<BaseItem>();
        equippedItems = new ArrayList<BaseItem>();
        characterName = "Un-named character";
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
    public void setCharacterHealth(float characterHealth)
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


    // ----------------------------------------------------------
    /**
     * @return the characterName
     */
    public String getCharacterName()
    {
        return characterName;
    }


    // ----------------------------------------------------------
    /**
     * @param characterName the characterName to set
     */
    public void setCharacterName(String characterName)
    {
        this.characterName = characterName;
    }

}
