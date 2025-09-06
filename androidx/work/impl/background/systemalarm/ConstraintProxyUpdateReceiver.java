package androidx.work.impl.background.systemalarm;

import U4.w;
import V4.s;
import X4.d;
import android.content.BroadcastReceiver.PendingResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final String a;

    static {
        ConstraintProxyUpdateReceiver.a = "WM-ConstrntProxyUpdtRec";
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        String s = intent0 == null ? null : intent0.getAction();
        if(!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(s)) {
            w.e().a("WM-ConstrntProxyUpdtRec", "Ignoring unknown action " + s);
            return;
        }
        BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0 = this.goAsync();
        s s1 = s.c0(context0);
        d d0 = new d(broadcastReceiver$PendingResult0, context0, intent0);
        s1.k.a(d0);
    }
}

