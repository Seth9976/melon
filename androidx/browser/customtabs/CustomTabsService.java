package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.collection.V;
import p.i;

public abstract class CustomTabsService extends Service {
    public final V a;
    public final i b;

    public CustomTabsService() {
        this.a = new V(0);
        this.b = new i(this);
    }

    public abstract Bundle a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract int d();

    public abstract boolean e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i();

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        return this.b;
    }
}

