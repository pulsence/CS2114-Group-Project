package org.cS2114.groupProject.items;

import junit.framework.TestCase;
import org.cS2114.groupProject.Character;

// -------------------------------------------------------------------------
/**
 * Test class for HealthPotion class.
 *
 * @author Sean Meacham
 * @version Apr 19, 2012
 */

public class HealthPotionTest
    extends TestCase
{
    private HealthPotion potion;
    private Character    character;
    private String       name;
    private String       itemType;
    private String       itemDescription;


    // ----------------------------------------------------------
    protected void setUp()
    {
        name = new String("I'm a potion");
        itemDescription = new String("I heal things");
        potion = new HealthPotion();
        potion.setHealAmount(50f);
        character = new Character();
    }


    /**
     * Test method for setName()
     */
    public void testSetName()
    {
        potion.setName(name);
        assertEquals("I'm a potion", potion.getName());
    }

    /**
     * Test method for getName()
     */
    public void testGetName()
    {
        potion.setName("potion");
        assertEquals("potion", potion.getName());
    }

    /**
     * test method for getDescription()
     */
    public void testGetDescription()
    {
        potion.setDescription(itemDescription);
        assertEquals("I heal things", potion.getDescription());
    }

    /**
     * Test method for setDescription()
     */
    public void testSetDescription()
    {
        potion.setDescription("new potion");
        assertEquals("new potion", potion.getDescription());
    }

    /**
     * Test method for
     * {@link org.cS2114.groupProject.items.HealthPotion#applyItem(org.cS2114.groupProject.Character)}
     * .
     */
    public void testApplyItem()
    {
        character.setCharacterHealth(50f);
        potion.setHealAmount(25f);
        assertTrue(potion.applyItem(character));
        assertEquals(75f, character.getCharacterHealth());
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.items.HealthPotion#HealthPotion()}.
     */
    public void testHealthPotion()
    {
        assertEquals(potion.getType(), ItemType.Potion);
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.items.HealthPotion#getHealAmount()}.
     */
    public void testGetHealAmount()
    {
        assertEquals(50f, potion.getHealAmount(), 0.01);
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.items.HealthPotion#setHealAmount(float)}.
     */
    public void testSetHealAmount()
    {
        potion.setHealAmount(30f);
        assertEquals(30f, potion.getHealAmount(), 0.01);
    }

}
