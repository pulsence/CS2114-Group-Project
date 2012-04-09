package org.cS2114.groupProject;

// -------------------------------------------------------------------------
/**
 * This is a simple weapon item. When applied to a character it is armed as the
 * character main weapon.
 *
 * @author Tim Eck (etimot2)
 * @version 2012.4.9
 */

public class SimpleWeapon
    extends BaseItem
{
    private float damage;


    /**
     * Creates a SimpleWeapon object.
     */
    public SimpleWeapon()
    {
        super();
        setType(ItemType.Weapon);
        damage = 0f;
    }


    // ----------------------------------------------------------
    /**
     * Gets the damage of this weapon.
     *
     * @return the damage of this weapon.
     */
    public float getDamage()
    {
        return damage;
    }


    // ----------------------------------------------------------
    /**
     * Sets this weapons damage.
     *
     * @param damage
     *            the damage that this weapon will do.
     */
    public void setDamage(float damage)
    {
        if (damage < 0)
        {
            this.damage = 0;
        }
        else
        {
            this.damage = damage;
        }
    }


    // ----------------------------------------------------------
    /**
     * Equips the character with this weapon,
     *
     * @param character
     *            The character to give this weapon to.
     * @return will always be false.
     */
    @Override
    public boolean applyItem(Character character)
    {
        // get characters equipped items
        // if item is type weapon then place it in storage
        // then place this as equipped
        // else place this as equipped
        return false;
    }

}
