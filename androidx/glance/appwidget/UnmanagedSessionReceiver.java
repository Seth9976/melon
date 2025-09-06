package androidx.glance.appwidget;

import D2.C;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/glance/appwidget/UnmanagedSessionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "D2/C", "glance-appwidget_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class UnmanagedSessionReceiver extends BroadcastReceiver {
    public static final C a;
    public static final LinkedHashMap b;

    static {
        UnmanagedSessionReceiver.a = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
        UnmanagedSessionReceiver.b = new LinkedHashMap();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        if(q.b(intent0.getAction(), "ACTION_TRIGGER_LAMBDA")) {
            if(intent0.getStringExtra("EXTRA_ACTION_KEY") == null) {
                throw new IllegalStateException("Intent is missing ActionKey extra");
            }
            int v = intent0.getIntExtra("EXTRA_APPWIDGET_ID", -1);
            if(v == -1) {
                throw new IllegalStateException("Intent is missing AppWidgetId extra");
            }
            C.a(v);
            Log.e("GlanceAppWidget", "A lambda created by an unmanaged glance session cannot be servicedbecause that session is no longer running.");
        }
    }
}

