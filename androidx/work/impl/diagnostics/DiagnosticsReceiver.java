package androidx.work.impl.diagnostics;

import U4.w;
import V4.p;
import V4.s;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import e.k;
import java.util.List;
import kotlin.jvm.internal.q;

public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String a;

    static {
        DiagnosticsReceiver.a = "WM-DiagnosticsRcvr";
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        if(intent0 == null) {
            return;
        }
        w.e().a("WM-DiagnosticsRcvr", "Requesting diagnostics");
        try {
            q.g(context0, "context");
            s s0 = s.c0(context0);
            List list0 = k.z(new y8.s(DiagnosticsWorker.class).b());
            if(list0.isEmpty()) {
                throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
            }
            new p(s0, null, 2, list0).L();
        }
        catch(IllegalStateException illegalStateException0) {
            w.e().d("WM-DiagnosticsRcvr", "WorkManager is not initialized", illegalStateException0);
        }
    }
}

