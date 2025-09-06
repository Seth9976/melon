package X4;

import U4.w;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmService;

public abstract class c extends BroadcastReceiver {
    public static final String a;

    static {
        c.a = "WM-ConstraintProxy";
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        w.e().a("WM-ConstraintProxy", "onReceive : " + intent0);
        Intent intent1 = new Intent(context0, SystemAlarmService.class);
        intent1.setAction("ACTION_CONSTRAINTS_CHANGED");
        context0.startService(intent1);
    }
}

