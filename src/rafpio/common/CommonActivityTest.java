package rafpio.common;

import android.app.Instrumentation;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;

/**
 * The Class WelcomeActivityTest. It contains test cases for the
 * WelcomeActivity.
 */

public class CommonActivityTest extends ActivityInstrumentationTestCase2<CommonActivity> {

	private CommonActivity activity;
	private Solo solo;
	private Instrumentation instrumentation;
	private Context targetContext;
	private static final String PACKAGE_NAME = "rafpio.common";

	public CommonActivityTest() {
	    super(PACKAGE_NAME, CommonActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();

		instrumentation = getInstrumentation();
		targetContext = instrumentation.getTargetContext();
		
		activity = getActivity();
        solo = new Solo(instrumentation, activity);
	}

	/**
	 * Test press continue. <br/>
	 * <b>Preconditions:</b>  <br/>
	 * <b>Expected result:</b>
	 */
	public void testShowFirstTimeScreen() {
		//TODO put testing code here
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
