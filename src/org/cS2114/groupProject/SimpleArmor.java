package org.cS2114.groupProject;

// -------------------------------------------------------------------------
/**
 * This is a simple armor item. If allows a character to better absorb damage.
 *
 * @author Tim Eck (etimot2)
 * @version 2012.4.9
 */

public class SimpleArmor
    extends BaseItem
{
    /**
     * This value can be between 0 and 1 inclusive. The value represents the
     * percentage of damage that it stops.
     */
    private float armorValue;


    /**
     * Creates a SimpleArmor object.
     */
    public SimpleArmor()
    {
        super();
        setType(ItemType.Armor);
        armorValue = 0f;
    }


    // ----------------------------------------------------------
    /**
     * Gets the value of this armor. The value represents the percentage of
     * damage that it stops and is between 0 and 1 inclusive.
     *
     * @return the armorValue of this item.
     */
    public float getArmorValue()
    {
        return armorValue;
    }


    // ----------------------------------------------------------
    /**
     * Sets the armor value of this object. This value must be between 0 and 1
     * inclusive.
     *
     * @param armorValue
     *            the armorValue to set
     */
    public void setArmorValue(float armorValue)
    {
        if (armorValue < 0f)
        {
            this.armorValue = 0f;
        }
        else if (armorValue > 1f)
        {
            this.armorValue = 1f;
        }
        else
        {
            this.armorValue = armorValue;
        }
    }


    // ----------------------------------------------------------
    /**
     * Sets this armor as the character armor.
     *
     * @param character
     *            The character to add this armor to.
     * @return will always be false.
     */
    @Override
    public boolean applyItem(Character character)
    {
        // get characters equipped items
        // if item is type armor then place it in storage
        // then place this as equipped
        // else place this as equipped
        return false;
    }

}
