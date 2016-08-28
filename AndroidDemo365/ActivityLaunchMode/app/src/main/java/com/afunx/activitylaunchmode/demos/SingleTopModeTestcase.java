package com.afunx.activitylaunchmode.demos;

import android.content.Context;
import android.content.Intent;

import com.afunx.activitylaunchmode.activities.Action;
import com.afunx.activitylaunchmode.activities.ActivityA;
import com.afunx.activitylaunchmode.activities.ActivityB;
import com.afunx.activitylaunchmode.activities.ActivityC;

import java.util.ArrayList;

/**
 * Created by afunx on 16-8-27.
 */
public class SingleTopModeTestcase {

    public static void demo0(Context context){

        // ABCA -> ABCA
        Action actionA = new Action(Intent.FLAG_ACTIVITY_SINGLE_TOP, ActivityA.class);
        Action actionB = new Action(-1, ActivityB.class);
        Action actionC = new Action(-1, ActivityC.class);

        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(actionA);
        actionList.add(actionB);
        actionList.add(actionC);
        actionList.add(actionA);
    }

    public static void demo1(Context context) {

        // ABCC -> ABC
        Action actionA = new Action(-1, ActivityA.class);
        Action actionB = new Action(-1, ActivityB.class);
        Action actionC = new Action(Intent.FLAG_ACTIVITY_SINGLE_TOP, ActivityC.class);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(actionA);
        actionList.add(actionB);
        actionList.add(actionC);
        actionList.add(actionC);

        ModeTestcaseUtil.execute(context, actionList);
    }
}
