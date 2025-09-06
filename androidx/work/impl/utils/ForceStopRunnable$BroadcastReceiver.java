package androidx.work.impl.utils;

import U4.w;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import e5.e;

public class ForceStopRunnable.BroadcastReceiver extends BroadcastReceiver {
    public static final String a;

    static {
        ForceStopRunnable.BroadcastReceiver.a = "WM-ForceStopRunnable$Rc";
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        if(intent0 != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent0.getAction())) {
            if(w.e().a <= 2) {
                Log.v("WM-ForceStopRunnable$Rc", "Rescheduling alarm that keeps track of force-stops.");
            }
            e.c(context0);
        }
    }
}

