package org.cS2114.groupProject.items;

import junit.framework.TestCase;
import org.cS2114.groupProject.Character;

// -------------------------------------------------------------------------
/**
 * Test class for SimpleWeapon class.
 *
 * @author Sean Meacham
 * @version Apr 19, 2012
 */

public class SimpleWeaponTest
    extends TestCase
{
    private SimpleWeapon weapon;
    private Character    character;


    // ----------------------------------------------------------
    protected void setUp()
    {
        weapon = new SimpleWeapon();
        character = new Character();
        weapon.setDamage(10f);
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.items.SimpleWeapon#applyItem(org.cS2114.groupProject.Character)}
     * .
     */
    public void testApplyItem()
    {
        assertFalse(weapon.applyItem(character));
        assertEquals(1, character.getEquippedItems().size());
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.items.SimpleWeapon#SimpleWeapon()}.
     */
    public void testSimpleWeapon()
    {
        assertEquals(weapon.getType(), ItemType.Weapon);
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.items.SimpleWeapon#getDamage()}.
     */
    public void testGetDamage()
    {
        assertEquals(10f, weapon.getDamage(), 0.01);
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.items.SimpleWeapon#setDamage(float)}.
     */
    public void testSetDamage()
    {
        weapon.setDamage(25f);
        assertEquals(25f, weapon.getDamage(), 0.01);
    }

}
