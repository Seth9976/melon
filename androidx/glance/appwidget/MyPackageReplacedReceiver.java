package androidx.glance.appwidget;

import D2.A0;
import a.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/glance/appwidget/MyPackageReplacedReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "glance-appwidget_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MyPackageReplacedReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        a.B(this, Dispatchers.getDefault(), new A0(context0, null));
    }
}

