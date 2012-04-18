package org.cS2114.groupProject.actions;

import java.util.ArrayList;
import org.cS2114.groupProject.Character;
import org.cS2114.groupProject.Room;
import org.cS2114.groupProject.items.BaseItem;

// -------------------------------------------------------------------------
/**
 * Applies an item to the main character.
 *
 * @author Sean Meacham (sean22)
 * @author Tim Eck (etimot2)
 * @author Nate Tucker (imtucker)
 * @version Apr 17, 2012
 */
public class ApplyItemAction
    extends BaseAction
{
    private BaseItem item;


    // ----------------------------------------------------------
    /**
     * Create a new ApplyItemAction object.
     *
     * @param item
     *            the item that this action will apply.
     */
    public ApplyItemAction(BaseItem item)
    {
        this.item = item;
    }


    // ----------------------------------------------------------
    @Override
    public String getDescription()
    {
        return "Apply " + item.getName() + " to your character";
    }


    // ----------------------------------------------------------
    @Override
    public boolean applyAction(Room room)
    {
        Character main = room.getMainCharacter();
        ArrayList<BaseItem> stored = main.getStoredItems();
        ArrayList<BaseItem> equipped = main.getEquippedItems();

        if (!stored.contains(item) && !equipped.contains(item))
        {
            return true;
        }

        if (item.applyItem(main))
        {
            stored.remove(item);
            equipped.remove(item);
            return true;
        }
        return false;
    }
}
