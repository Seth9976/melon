package androidx.glance.appwidget.action;

import E2.b;
import a.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/glance/appwidget/action/ActionCallbackBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "E2/k", "glance-appwidget_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ActionCallbackBroadcastReceiver extends BroadcastReceiver {
    public static final int a;

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        a.B(this, Dispatchers.getDefault(), new b(intent0, context0, null));
    }
}

