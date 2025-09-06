package com.iloen.melon.playback;

import Q1.c;
import android.content.Context;
import android.content.Intent;
import com.iloen.melon.utils.log.LogU;

public class PlayStateIntent {
    private static final String TAG = "PlayStateIntent";

    public static void post(Context context0) {
        LogU.v("PlayStateIntent", "post()");
        Intent intent0 = new Intent();
        c.Y(intent0, "android.appwidget.action.APPWIDGET_UPDATE", false);
        intent0.putExtra("com.iloen.melon.intent.action", "com.iloen.melon.intent.action.playback.statechanged");
        context0.sendBroadcast(intent0);
    }
}

