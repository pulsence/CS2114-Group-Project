package org.cS2114.groupProject.items;

import org.cS2114.groupProject.Character;

// -------------------------------------------------------------------------
/**
 * This object will heal characters when it is applied. However once applied it
 * should be destroyed and removed from the characters inventory.
 *
 * @author Tim Eck (etimot2)
 * @version 2012.4.9
 */

public class HealthPotion
    extends BaseItem
{
    private float healAmount;


    /**
     * Creates a HealthPotion object.
     */
    public HealthPotion()
    {
        super();
        setType(ItemType.Potion);
        healAmount = 0f;
    }


    // ----------------------------------------------------------
    /**
     * Gets the amount of health this potion will replenish.
     *
     * @return the amount this potion will heal a character.
     */
    public float getHealAmount()
    {
        return healAmount;
    }


    // ----------------------------------------------------------
    /**
     * Sets the amount of health this potion will add to a character.
     *
     * @param healAmount
     *            the amount of health this potion will heal.
     */
    public void setHealAmount(float healAmount)
    {
        if (healAmount < 0f)
        {
            this.healAmount = 0f;
        }
        else
        {
            this.healAmount = healAmount;
        }
    }


    // ----------------------------------------------------------
    /**
     * Heals the character the amount that this potion can.
     *
     * @param character
     *            The character to heal.
     * @return will always be true.
     */
    @Override
    public boolean applyItem(Character character)
    {
        float characterHealth = character.getCharacterHealth();
        characterHealth += healAmount;
        character.setCharacterHealth(characterHealth);
        return true;
    }

}
