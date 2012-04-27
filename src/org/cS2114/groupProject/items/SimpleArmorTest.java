package org.cS2114.groupProject.items;

import org.cS2114.groupProject.Character;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for SimpleArmor class.
 *
 * @author Sean Meacham
 * @version Apr 13, 2012
 */

public class SimpleArmorTest
    extends TestCase
{
    private SimpleArmor armor;
    private Character   character;


    // ----------------------------------------------------------
    protected void setUp()
    {
        armor = new SimpleArmor();
        armor.setArmorValue(0.25f);
        character = new Character();
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.SimpleArmor#applyItem(org.cS2114.groupProject.Character)}
     * .
     */
    @SuppressWarnings("javadoc")
    public void testApplyItem()
    {
        assertFalse(armor.applyItem(character));
        assertEquals(1, character.getEquippedItems().size());
    }


    /**
     * Test method for {@link org.cS2114.groupProject.SimpleArmor#SimpleArmor()}
     * .
     */
    @SuppressWarnings("javadoc")
    public void testSimpleArmor()
    {
        assertEquals(armor.getType(), ItemType.Armor);
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.SimpleArmor#getArmorValue()}.
     */
    @SuppressWarnings("javadoc")
    public void testGetArmorValue()
    {
        assertEquals(0.25f, armor.getArmorValue(), 0.01);
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.SimpleArmor#setArmorValue(float)}.
     */
    @SuppressWarnings("javadoc")
    public void testSetArmorValue()
    {
        armor.setArmorValue(0.45f);
        assertEquals(0.45f, armor.getArmorValue(), 0.01);
    }
}
