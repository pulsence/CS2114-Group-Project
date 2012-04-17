package org.cS2114.groupProject.actions;

import java.util.ArrayList;
import org.cS2114.groupProject.Character;
import org.cS2114.groupProject.NPC;
import org.cS2114.groupProject.Room;
import org.cS2114.groupProject.items.BaseItem;
import org.cS2114.groupProject.items.SimpleArmor;
import org.cS2114.groupProject.items.SimpleWeapon;

// -------------------------------------------------------------------------
/**
 * Simple action class that allows the user to fight an enemy.
 *
 * @author Tim Eck II (etimot2)
 * @version Apr 16, 2012
 */
public class FightAction
    extends BaseAction
{
    private NPC enemy;


    // ----------------------------------------------------------
    /**
     * Create a new FightAction object.
     *
     * @param enemy
     *            The enemy that this action will fight against.
     * @precondition the enemy must be able to fight.
     */
    public FightAction(NPC enemy)
    {
        assert enemy.canFight();
        this.enemy = enemy;
    }


    /**
     * Gets the description of this room.
     *
     * @return the rooms descriptions.
     */
    @Override
    public String getDescription()
    {
        String description =
            "Fight " + enemy.getCharacterName() + ", they have "
                + enemy.getCharacterHealth() + " health points left";

        return description;
    }


    /**
     * Applies this action to the passed room. This actions has the enemy
     * specified to this action fight the main character in the room.
     *
     * @param room
     *            the room to apply this action too.
     * @return true is the enemy is killed.
     */
    @Override
    public boolean applyAction(Room room)
    {
        Character mainCharacter = room.getMainCharacter();

        // Gets the characters weapon and armor.
        ArrayList<BaseItem> mainCharacterItems =
            mainCharacter.getEquippedItems();
        SimpleWeapon mainCharacterWeapon = new SimpleWeapon();
        SimpleArmor mainCharacterArmor = new SimpleArmor();
        for (BaseItem item : mainCharacterItems)
        {
            if (item instanceof SimpleWeapon)
            {
                mainCharacterWeapon = (SimpleWeapon)item;
            }
            else if (item instanceof SimpleArmor)
            {
                mainCharacterArmor = (SimpleArmor)item;
            }
        }

        // Gets the characters weapon and armor.
        ArrayList<BaseItem> enemyItems = enemy.getEquippedItems();
        SimpleWeapon enemyWeapon = new SimpleWeapon();
        SimpleArmor enemyArmor = new SimpleArmor();
        for (BaseItem item : enemyItems)
        {
            if (item instanceof SimpleWeapon)
            {
                enemyWeapon = (SimpleWeapon)item;
            }
            else if (item instanceof SimpleArmor)
            {
                enemyArmor = (SimpleArmor)item;
            }
        }

        // Damages both characters.
        float damage =
            enemyArmor.getArmorValue() * mainCharacterWeapon.getDamage();
        enemy.setCharacterHealth(enemy.getCharacterHealth() - damage);

        damage = mainCharacterArmor.getArmorValue() * enemyWeapon.getDamage();
        mainCharacter.setCharacterHealth(mainCharacter.getCharacterHealth()
            - damage);

        if (enemy.getCharacterHealth() <= 0)
        {
            return true;
        }
        return false;
    }
}
