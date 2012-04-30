package org.cS2114.groupProject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Observable;
import java.util.Observer;
import org.cS2114.groupProject.actions.BaseAction;
import org.cS2114.groupProject.actions.ChangeRoomAction;
import org.cS2114.groupProject.actions.FightAction;
import org.cS2114.groupProject.actions.SearchAction;
import org.cS2114.groupProject.actions.TalkAction;
import org.cS2114.groupProject.items.BaseItem;
import org.cS2114.groupProject.items.ItemType;
import org.cS2114.groupProject.items.SimpleArmor;
import org.cS2114.groupProject.items.SimpleWeapon;

// -------------------------------------------------------------------------
/**
 * The main activity for the game.
 *
 * @author Sean Meacham (sean22)
 * @author Tim Eck (etimot2)
 * @author Nate Tucker (imtucker)
 * @version 2012.04.29
 */
public class GroupProjectActivity
    extends Activity
{
    private Room     room;

    private TextView mainCharHP;
    private TextView mainCharDEF;
    private TextView mainCharATT;

    private Spinner  actionSpinner;
    private Spinner  itemSpinner;
    private Context  context;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        context = this;
        setupInitialMap();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mainCharHP = (TextView)findViewById(R.id.mainCharHP);
        mainCharDEF = (TextView)findViewById(R.id.mainCharDEF);
        mainCharATT = (TextView)findViewById(R.id.mainCharATT);
        updateStatusBars();

        actionSpinner = (Spinner)findViewById(R.id.actionSpinner);
        actionSpinner
            .setOnItemSelectedListener(new ActionSpinnerSelectedListener());
        buildActionList();

        itemSpinner = (Spinner)findViewById(R.id.objectsSpinner);
        itemSpinner
            .setOnItemSelectedListener(new ItemSpinnerSelectedListener());
        buildStoredItemList();
    }


    /**
     * Sets up the conditions for the initial room
     */
    private void setupInitialMap()
    {
        room = new Room();
        room.addObserver(new RoomObserver());
        Room roomNorth = new Room();
        roomNorth.addObserver(new RoomObserver());
        Room roomSouth = new Room();
        roomSouth.addObserver(new RoomObserver());
        Room roomEast = new Room();
        roomEast.addObserver(new RoomObserver());
        Room roomWest = new Room();
        roomWest.addObserver(new RoomObserver());

        Room[] newLinkedRooms = room.getLinkedRooms();
        newLinkedRooms[0] = roomNorth;
        newLinkedRooms[1] = roomEast;
        newLinkedRooms[2] = roomSouth;
        newLinkedRooms[3] = roomWest;
        room.setLinkedRooms(newLinkedRooms);

        // Center room
        Character mainChar = new Character();
        mainChar.setCharacterName("Main Character");
        SimpleWeapon weapon = new SimpleWeapon();
        weapon.setDamage(5f);
        weapon.setName("Sword");
        mainChar.getEquippedItems().add(weapon);
        room.setMainCharacter(mainChar);

        NPC npc = new NPC();
        npc.setCharacterName("Sage");
        npc.setMessage("Remember to explore the room first!");
        room.getNpcs().add(npc);
        room.getCurrentActions().add(new TalkAction(npc));

        npc = new NPC();
        npc.setCharacterName("Warrior");
        npc.setCharacterHealth(10f);
        SimpleArmor armor = new SimpleArmor();
        armor.setName("Sheild");
        armor.setArmorValue(0.1f);
        npc.getEquippedItems().add(armor);
        room.getNpcs().add(npc);
        room.getHiddenActions().add(new FightAction(npc));
        room.getHiddenActions().add(new ChangeRoomAction(0));
        room.getHiddenActions().add(new ChangeRoomAction(1));
        room.getHiddenActions().add(new ChangeRoomAction(2));
        room.getHiddenActions().add(new ChangeRoomAction(3));
        room.getCurrentActions().add(new SearchAction());

        // East room
        NPC npcEast = new NPC();
        npcEast.setCharacterName("Eastern Sage");
        npcEast.setMessage("Remember to explore the room first!");
        roomEast.getNpcs().add(npcEast);

        npcEast = new NPC();
        npcEast.setCharacterName("Big Warrior");
        weapon = new SimpleWeapon();
        weapon.setDamage(7);
        npcEast.setCharacterHealth(40);
        npcEast.getEquippedItems().add(weapon);
        roomEast.getNpcs().add(npcEast);

        roomEast.getHiddenActions().add(new FightAction(npcEast));
        roomEast.getCurrentActions().add(new TalkAction(npcEast));
        roomEast.getCurrentActions().add(new ChangeRoomAction(3));
        roomEast.getCurrentActions().add(new SearchAction());
        roomEast.getLinkedRooms()[3] = room;

        // West room
        NPC npcWest = new NPC();
        npcWest.setCharacterName("Western Sage");
        npcWest.setMessage("Remember to explore the room first!");
        roomWest.getNpcs().add(npcWest);
        roomWest.getCurrentActions().add(new TalkAction(npcWest));
        roomWest.getCurrentActions().add(new ChangeRoomAction(1));
        roomWest.getLinkedRooms()[1] = room;

        // North room
        NPC npcNorth = new NPC();
        npcNorth.setCharacterName("Northern Sage");
        npcNorth.setMessage("Remember to explore the room first!");
        roomNorth.getNpcs().add(npcNorth);
        roomNorth.getCurrentActions().add(new TalkAction(npcNorth));
        roomNorth.getCurrentActions().add(new ChangeRoomAction(2));
        newLinkedRooms = roomNorth.getLinkedRooms();
        newLinkedRooms[0] = null;
        newLinkedRooms[1] = null;
        newLinkedRooms[2] = room;
        newLinkedRooms[3] = null;
        roomNorth.setLinkedRooms(newLinkedRooms);

        // South room
        NPC npcSouth = new NPC();
        npcSouth.setCharacterName("Southern Sage");
        npcSouth.setMessage("Remember to explore the room first!");
        roomSouth.getNpcs().add(npcSouth);
        roomSouth.getCurrentActions().add(new TalkAction(npcSouth));
        roomSouth.getCurrentActions().add(new ChangeRoomAction(0));
        roomSouth.getLinkedRooms()[0] = room;
    }


    /**
     * Updates the action list with the actions that are in the current room.
     */
    private void buildActionList()
    {
        ArrayAdapter<String> adapter =
            new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter.add("");
        for (BaseAction action : room.getCurrentActions())
        {
            adapter.add(action.getDescription());
        }
        actionSpinner.setAdapter(adapter);
    }


    private void buildStoredItemList()
    {
        ArrayAdapter<String> adapter =
            new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter.add("");
        for (BaseItem item : room.getMainCharacter().getEquippedItems())
        {
            if (item.getType() == ItemType.Armor
                || item.getType() == ItemType.Weapon)
            {
                adapter.add("remove: " + item.getName());
            }
            else
            {
                adapter.add("use: " + item.getName());
            }
        }

        for (BaseItem item : room.getMainCharacter().getStoredItems())
        {
            if (item.getType() == ItemType.Armor
                || item.getType() == ItemType.Weapon)
            {
                adapter.add("equip: " + item.getName());
            }
            else
            {
                adapter.add("use: " + item.getName());
            }
        }
        itemSpinner.setAdapter(adapter);
    }


    // ----------------------------------------------------------
    /**
     * Updates the status bar that display player information
     */
    public void updateStatusBars()
    {
        Character main = room.getMainCharacter();
        float att = 0;
        float def = 0;

        for (BaseItem item : main.getEquippedItems())
        {
            if (item instanceof SimpleWeapon)
            {
                att = ((SimpleWeapon)item).getDamage();
            }
            else if (item instanceof SimpleArmor)
            {
                def = ((SimpleArmor)item).getArmorValue();
            }
        }

        mainCharHP.setText("HP: " + main.getCharacterHealth());
        mainCharDEF.setText("DEF: " + def);
        mainCharATT.setText("ATT: " + att);
    }


    /**
     * Nested class to set do a specific action when one is selected by the
     * action spinner.
     */
    public class ActionSpinnerSelectedListener
        implements OnItemSelectedListener
    {

        public void onItemSelected(
            AdapterView<?> parent,
            View view,
            int pos,
            long id)
        {
            if (pos == 0 || pos > room.getCurrentActions().size())
            {
                return;
            }

            BaseAction action = room.getCurrentActions().get(pos - 1);
            if (action.applyAction(room))
            {
                room.getCurrentActions().remove(action);
            }
            buildActionList();
            buildStoredItemList();
            updateStatusBars();
        }


        public void onNothingSelected(AdapterView<?> parent)
        {
            // Do nothing.
        }

    }


    /**
     * Nested class to set do a add or remove and item when it is selected.
     */
    public class ItemSpinnerSelectedListener
        implements OnItemSelectedListener
    {

        public void onItemSelected(
            AdapterView<?> parent,
            View view,
            int pos,
            long id)
        {
            if (pos == 0)
            {
                return;
            }
            Character main = room.getMainCharacter();
            pos--;
            if (pos < main.getEquippedItems().size())
            {
                BaseItem item = main.getEquippedItems().get(pos);
                if (item.applyItem(main))
                {
                    main.getEquippedItems().remove(item);
                }
            }
            else
            {
                pos -= main.getEquippedItems().size();
                BaseItem item = main.getStoredItems().get(pos);
                if (item.applyItem(main))
                {
                    main.getEquippedItems().remove(item);
                    main.getStoredItems().remove(item);
                }
            }
            buildActionList();
            buildStoredItemList();
            updateStatusBars();
        }


        public void onNothingSelected(AdapterView<?> parent)
        {
            // Do nothing.
        }

    }


    // -------------------------------------------------------------------------
    /**
     * The observer class for the room.
     */
    public class RoomObserver
        implements Observer
    {
        public void update(Observable observered, Object param)
        {
            Room tempRoom = (Room)observered;
            if (tempRoom.hasMessage())
            {
                Toast.makeText(
                    context,
                    tempRoom.getMessage(),
                    Toast.LENGTH_LONG).show();
                tempRoom.eraseMessage();
            }
            else if (tempRoom.shouldChangeRoom())
            {

                room = tempRoom.getLinkedRooms()[(Integer)param];
                room.setMainCharacter(tempRoom.getMainCharacter());
                room.addObserver(new RoomObserver());
                buildActionList();
                buildStoredItemList();
                updateStatusBars();
            }
        }

    }

}
