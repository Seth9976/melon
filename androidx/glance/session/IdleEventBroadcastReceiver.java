package androidx.glance.session;

import G.g;
import L2.a;
import L2.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import e.k;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/glance/session/IdleEventBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "glance_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class IdleEventBroadcastReceiver extends BroadcastReceiver {
    public final g a;
    public static final List b;
    public static final IntentFilter c;

    static {
        List list0 = k.A(new String[]{"android.os.action.DEVICE_IDLE_MODE_CHANGED", "android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED", "android.os.action.LOW_POWER_STANDBY_ENABLED_CHANGED"});
        IdleEventBroadcastReceiver.b = list0;
        IntentFilter intentFilter0 = new IntentFilter();
        for(Object object0: list0) {
            intentFilter0.addAction(((String)object0));
        }
        IdleEventBroadcastReceiver.c = intentFilter0;
    }

    public IdleEventBroadcastReceiver(g g0) {
        this.a = g0;
    }

    public final void a(Context context0) {
        int v = Build.VERSION.SDK_INT;
        Object object0 = context0.getSystemService("power");
        q.e(object0, "null cannot be cast to non-null type android.os.PowerManager");
        boolean z = a.a.a(((PowerManager)object0));
        if(v >= 33) {
            z = z || b.a.a(((PowerManager)object0));
        }
        if(z) {
            this.a.invoke();
        }
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        String s = intent0.getAction();
        if(p.d0(IdleEventBroadcastReceiver.b, s)) {
            this.a(context0);
        }
    }
}

