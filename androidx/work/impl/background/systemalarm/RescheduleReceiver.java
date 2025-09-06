package androidx.work.impl.background.systemalarm;

import U4.w;
import V4.s;
import android.content.BroadcastReceiver.PendingResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RescheduleReceiver extends BroadcastReceiver {
    public static final String a;

    static {
        RescheduleReceiver.a = "WM-RescheduleReceiver";
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        w.e().a("WM-RescheduleReceiver", "Received intent " + intent0);
        try {
            s s0 = s.c0(context0);
            BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0 = this.goAsync();
            synchronized(s.t) {
                BroadcastReceiver.PendingResult broadcastReceiver$PendingResult1 = s0.p;
                if(broadcastReceiver$PendingResult1 != null) {
                    broadcastReceiver$PendingResult1.finish();
                }
                s0.p = broadcastReceiver$PendingResult0;
                if(s0.o) {
                    broadcastReceiver$PendingResult0.finish();
                    s0.p = null;
                }
            }
        }
        catch(IllegalStateException illegalStateException0) {
            w.e().d("WM-RescheduleReceiver", "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", illegalStateException0);
        }
    }
}

