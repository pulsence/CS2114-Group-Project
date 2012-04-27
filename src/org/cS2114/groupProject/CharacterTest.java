package org.cS2114.groupProject;

import junit.framework.TestCase;
import org.cS2114.groupProject.items.SimpleArmor;

// -------------------------------------------------------------------------
/**
 * This is a test class for the Character class.
 *
 * @author Sean Meacham
 * @version Apr 20, 2012
 */

public class CharacterTest
    extends TestCase
{

    private Character   character;
    private SimpleArmor armor;


    // ----------------------------------------------------------
    protected void setUp()
    {
        character = new Character();
        armor = new SimpleArmor();
    }


    /**
     * Test method for {@link org.cS2114.groupProject.Character#Character()}.
     */
    public void testCharacter()
    {
        assertEquals("Un-named character", character.getCharacterName());
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.Character#getCharacterHealth()}.
     */
    public void testGetCharacterHealth()
    {
        assertEquals(100f, character.getCharacterHealth());
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.Character#setCharacterHealth(float)}.
     */
    public void testSetCharacterHealth()
    {
        character.setCharacterHealth(75f);
        assertEquals(75f, character.getCharacterHealth());
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.Character#getStoredItems()}.
     */
    public void testGetStoredItems()
    {
        character.getStoredItems().add(armor);
        assertEquals(1, character.getStoredItems().size());
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.Character#getEquippedItems()}.
     */
    public void testGetEquippedItems()
    {
        armor.applyItem(character);
        assertEquals(1, character.getEquippedItems().size());
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.Character#getCharacterName()}.
     */
    public void testGetCharacterName()
    {
        assertEquals("Un-named character", character.getCharacterName());
    }


    /**
     * Test method for
     * {@link org.cS2114.groupProject.Character#setCharacterName(java.lang.String)}
     * .
     */
    public void testSetCharacterName()
    {
        character.setCharacterName("Meach");
        assertEquals("Meach", character.getCharacterName());
    }

}
