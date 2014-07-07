
package org.asha.app.ui;

import android.content.Context;

import java.util.Random;

public class UiResources {

    private static boolean mInitialized = false;

    public static final String EVENTS_KEY = "org.asha.app.util.events_key";

    public static int sBlueColor;

    public static int sGrayColor;

    public static int sWhiteColor;

    public static int sOrangeColor;

    public static int sRedColor;

    public static int sYellowColor;

    private static Random sRandom = new Random();

    public static int[] sColorList;

    public static void init(Context context) {
        if (mInitialized) {
            return;
        }
        sBlueColor = context.getResources().getColor(R.color.blue);
        sGrayColor = context.getResources().getColor(R.color.gray);
        sWhiteColor = context.getResources().getColor(android.R.color.white);
        sOrangeColor = context.getResources().getColor(R.color.orange);
        sRedColor = context.getResources().getColor(R.color.red);
        sYellowColor = context.getResources().getColor(R.color.yellow);
        sColorList = new int[] {
                sBlueColor, sGrayColor, sWhiteColor, sOrangeColor, sRedColor, sYellowColor
        };
        mInitialized = true;
    }

    public static int pickRandomColor() {
        int index = sRandom.nextInt(sColorList.length);
        return sColorList[index];
    }
}
