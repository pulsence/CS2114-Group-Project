package org.cS2114.groupProject.items;

import org.cS2114.groupProject.Character;

// -------------------------------------------------------------------------
/**
 * The base of all items. An item can effect stats of a character.
 *
 * @author Tim Eck (etimot2)
 * @version 2012.4.9
 */
public abstract class BaseItem
{
    private String   name;
    private String   description;
    private ItemType type;


    // ----------------------------------------------------------
    /**
     * Create a new BaseItem object.
     */
    public BaseItem()
    {
        this("Base Item", "This is a base item", ItemType.Other);
    }


    /**
     * Creates a new BaseItem object.
     *
     * @param itemName
     *            The name of this item.
     * @param itemDescription
     *            The description for this item.
     * @param itemType
     *            The type of this item.
     */
    public BaseItem(String itemName, String itemDescription, ItemType itemType)
    {
        name = itemName;
        description = itemDescription;
        type = itemType;
    }


    // ----------------------------------------------------------
    /**
     * Gets the name of this item.
     *
     * @return the name of this item.
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Sets this items name.
     *
     * @param name
     *            the new name of this item.
     */
    public void setName(String name)
    {
        this.name = name;
    }


    // ----------------------------------------------------------
    /**
     * Gets the description of this item.
     *
     * @return the description if this item.
     */
    public String getDescription()
    {
        return description;
    }


    // ----------------------------------------------------------
    /**
     * Sets this items description.
     *
     * @param description
     *            the new description for this item.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }


    // ----------------------------------------------------------
    /**
     * Gets this items type.
     *
     * @return the type of this item.
     */
    public ItemType getType()
    {
        return type;
    }


    // ----------------------------------------------------------
    /**
     * Sets this item's type.
     *
     * @param type
     *            the new type of this item.
     */
    public void setType(ItemType type)
    {
        this.type = type;
    }


    // ----------------------------------------------------------
    /**
     * Applies this items effect upon a character.
     *
     * @param character
     *            The character that this item is being applied to.
     * @return true if this item should be destroyed.
     */
    public abstract boolean applyItem(Character character);
}
