package org.cS2114.groupProject;

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


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView mainCharHP = (TextView)findViewById(R.id.mainCharHP);
        mainCharHP.setText("HP: ");

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

        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 =
            ArrayAdapter.createFromResource(
                this,
                R.array.action_Array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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


    public void changeRoom()
    {
        changeRoom = new ChangeRoomAction(1);
        changeRoom.applyAction(curRoom);
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

            if (!exploreRoom)
            {
                Toast.makeText(
                    parent.getContext(),
                    parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_LONG).show();
            }
            /*
             * if(parent.getItemAtPosition(pos).toString() == "Explore Room") {
             * exploreRoom = true; Toast.makeText( parent.getContext(),
             * "You have explored the room!", Toast.LENGTH_LONG).show(); return;
             * } Toast.makeText( parent.getContext(),
             * "You must first explore the room!", Toast.LENGTH_LONG).show(); }
             * else if (parent.getItemAtPosition(pos).toString() ==
             * "Explore the Room") { search.applyAction(curRoom); exploreRoom =
             * true; }
             */
        }


        public void onNothingSelected(AdapterView<?> parent)
        {
            // Do nothing.
        }
    }


    public void updateStatusBar()
    {

    }
}
