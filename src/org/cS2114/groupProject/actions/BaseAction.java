package org.cS2114.groupProject.actions;

import org.cS2114.groupProject.Room;

// -------------------------------------------------------------------------
/**
 * Abstract class that is the base for all actions.
 *
 * @author Tim Eck II (etimot2)
 * @version Apr 16, 2012
 */

public abstract class BaseAction
{
    private String actionName;
    private String actionId;


    // ----------------------------------------------------------
    /**
     * Create a new BaseAction object.
     */
    public BaseAction()
    {
        actionName = "";
        actionId = "";
    }


    // ----------------------------------------------------------
    /**
     * Gets this actions name.
     *
     * @return the actionName
     */
    public String getActionName()
    {
        return actionName;
    }


    // ----------------------------------------------------------
    /**
     * Sets this actions name.
     *
     * @param actionName
     *            the actionName to set
     */
    public void setActionName(String actionName)
    {
        this.actionName = actionName;
    }


    // ----------------------------------------------------------
    /**
     * Gets this actions id.
     *
     * @return the actionId
     */
    public String getActionId()
    {
        return actionId;
    }


    // ----------------------------------------------------------
    /**
     * Sets this actions id.
     *
     * @param actionId
     *            the actionId to set
     */
    public void setActionId(String actionId)
    {
        this.actionId = actionId;
    }


    // ----------------------------------------------------------
    /**
     * Gets the description of this action.
     *
     * @return this actions description.
     */
    public abstract String getDescription();


    // ----------------------------------------------------------
    /**
     * Applies this action to room passed.
     *
     * @param room
     *            to apply the action too.
     * @return false if the action should be removed.
     */
    public abstract boolean applyAction(Room room);
}
