package r;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.appcompat.app.z;
import androidx.lifecycle.K;

public final class d extends K {
    public final Context l;
    public final c m;
    public final z n;
    public static final Uri o;

    static {
        d.o = new Uri.Builder().scheme("content").authority("androidx.car.app.connection").build();
    }

    public d(Context context0) {
        this.l = context0;
        this.m = new c(this, context0.getContentResolver());
        this.n = new z(this, 10);
    }

    @Override  // androidx.lifecycle.K
    public final void onActive() {
        IntentFilter intentFilter0 = new IntentFilter("androidx.car.app.connection.action.CAR_CONNECTION_UPDATED");
        z z0 = this.n;
        Context context0 = this.l;
        if(Build.VERSION.SDK_INT >= 33) {
            b.a(context0, z0, intentFilter0);
        }
        else {
            context0.registerReceiver(z0, intentFilter0);
        }
        this.m.startQuery(42, null, d.o, new String[]{"CarConnectionState"}, null, null, null);
    }

    @Override  // androidx.lifecycle.K
    public final void onInactive() {
        this.l.unregisterReceiver(this.n);
        this.m.cancelOperation(42);
    }
}

