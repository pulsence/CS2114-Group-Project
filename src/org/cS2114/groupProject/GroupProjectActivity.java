package org.cS2114.groupProject;

import org.cS2114.groupProject.items.BaseItem;
import android.content.Intent;
import android.widget.TextView;
import org.cS2114.groupProject.actions.ApplyItemAction;
import org.cS2114.groupProject.actions.ChangeRoomAction;
import org.cS2114.groupProject.actions.FightAction;
import org.cS2114.groupProject.actions.SearchAction;
import java.util.ArrayList;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.app.Activity;
import android.os.Bundle;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The main activity for the game.
 *
 * @author Sean Meacham (sean22)
 * @author Tim Eck (etimot2)
 * @author Nate Tucker (imtucker)
 * @version 2012.04.07
 */
public class GroupProjectActivity
    extends Activity
{
    private Room             initRoom;
    private Character        mainChar;
    private ArrayList<NPC>   npcs;
    private boolean          exploreRoom;
    private SearchAction     search;
    private FightAction      fight;
    private ChangeRoomAction changeRoom;
    private ApplyItemAction  applyItem;
    private Room             curRoom = null;
    private TextView         mainCharHP;
    private TextView         mainCharDEF;
    private TextView         mainCharATT;
    private NPC              npc1;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (curRoom == null)
        {
            initRoom = new Room();
            curRoom = initRoom;
        }

        mainChar = new Character();
        npc1 = new NPC();
        npc1.setMessage("Remember to explore the room first!");
        mainChar.setCharacterName("Main Character");
        initRoom.setMainCharacter(mainChar);

        TextView mainCharHP = (TextView)findViewById(R.id.mainCharHP);
        mainCharHP.setText("HP: " + mainChar.getCharacterHealth());

        TextView mainCharDEF = (TextView)findViewById(R.id.mainCharDEF);
        mainCharDEF.setText("DEF: ");

        TextView mainCharATT = (TextView)findViewById(R.id.mainCharATT);
        mainCharATT.setText("ATT: ");

        Spinner spinner1 = (Spinner)findViewById(R.id.actionSpinner);
        ArrayAdapter<CharSequence> adapter =
            ArrayAdapter.createFromResource(
                this,
                R.array.action_Array,
                android.R.layout.simple_spinner_item);
        adapter
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new MyOnItemSelectedListener());

        String secondarySpinner[] = new String[] { "Please select an action." };

        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 =
            new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                secondarySpinner);
        adapter
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new MyOnItemSelectedListener());

    }


    /**
     * Sets up the conditions for the initial room
     */
    private void firstRoomInit()
    {
        initRoom = new Room();
        mainChar = new Character();
        mainChar.setCharacterName("Main Character");
        initRoom.setMainCharacter(mainChar);
        NPC npc1 = new NPC();
        npc1.setMessage("You must explore the room before you can take action!");
        npcs.add(npc1);
        initRoom.setNpcs(npcs);
    }


    /**
     * // ----------------------------------------------------------------------
     * --- /** Nested class to set OnClickListeners to the data items in the
     * drop-down list and handle events.
     *
     * @author Sean Meacham
     * @version Apr 28, 2012
     */
    public class MyOnItemSelectedListener
        implements OnItemSelectedListener
    {

        @SuppressWarnings("javadoc")
        public void onItemSelected(
            AdapterView<?> parent,
            View view,
            int pos,
            long id)
        {
            if (!curRoom.getRoomState())
            {
                Toast.makeText(
                    parent.getContext(),
                    "You must explore the room first",
                    Toast.LENGTH_LONG).show();
            }

            if (pos == 0)
            {
                SearchAction search = new SearchAction();
                search.applyAction(curRoom);
                curRoom.setRoomState();
                Toast.makeText(
                    parent.getContext(),
                    "The room has now been explored.",
                    Toast.LENGTH_LONG).show();

                // Creates a string for
                String[] npcs = new String[curRoom.getNpcs().size()];

                for(int i = 0; i < curRoom.getNpcs().size(); i++)
                {
                    String value = null;
                    value = curRoom.getNpcs().get(i).toString();
                    npcs[i] = value;
                }


            }

            if (pos == 1)
            {
                FightAction fight = new FightAction(npc1);
                fight.applyAction(curRoom);
                updateStatusBars();
            }

            if (pos == 2)
            {
                int index = 0;
                changeRoom = new ChangeRoomAction(index);
                changeRoom.applyAction(curRoom);
            }

            if (pos == 3)
            {
                Toast.makeText(parent.getContext(),
                    npc1.getMessage(), Toast.LENGTH_LONG).show();
            }

            if (pos == 4)
            {

                //ApplyItemAction applyItem = new ApplyActionItem(item);
            }
        }


        public void onNothingSelected(AdapterView<?> parent)
        {
            // Do nothing.
        }

    }


    public void updateStatusBars()
    {
        mainCharHP
            .setText("" + curRoom.getMainCharacter().getCharacterHealth());

        mainCharDEF.setText(""
            + curRoom.getMainCharacter().getCharacterHealth());

        mainCharHP
            .setText("" + curRoom.getMainCharacter().getCharacterHealth());
    }

}
