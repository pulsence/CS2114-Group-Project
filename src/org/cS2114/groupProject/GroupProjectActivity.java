package org.cS2114.groupProject;

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
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // The code below should be deleted when we really start working with
        // this class. The code is for a test to make sure that the build is
        // working properly.
        TestCase test = new TestCase();
        // If the app even loads fully then the build is working properly.
    }
}
