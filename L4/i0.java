package l4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.mediarouter.media.MediaRouteProvider;
import df.B;
import j3.n;
import java.util.ArrayList;
import java.util.List;
import kb.D;

public final class i0 extends MediaRouteProvider implements ServiceConnection {
    public final ComponentName i;
    public final e0 j;
    public final ArrayList k;
    public boolean l;
    public boolean m;
    public c0 n;
    public boolean o;
    public n r;
    public static final int w;

    static {
        Log.isLoggable("MediaRouteProviderProxy", 3);
    }

    public i0(Context context0, ComponentName componentName0) {
        super(context0, new D(componentName0, 6));
        this.k = new ArrayList();
        this.i = componentName0;
        this.j = new e0();  // 初始化器: Landroid/os/Handler;-><init>()V
    }

    @Override  // androidx.mediarouter.media.MediaRouteProvider
    public final y a(String s, A a0) {
        if(s == null) {
            throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
        }
        B b0 = this.g;
        if(b0 != null) {
            List list0 = b0.b;
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                if(((u)list0.get(v1)).f().equals(s)) {
                    y y0 = new g0(this, s, a0);
                    this.k.add(y0);
                    if(this.o) {
                        ((g0)y0).a(this.n);
                    }
                    this.l();
                    return y0;
                }
            }
        }
        return null;
    }

    @Override  // androidx.mediarouter.media.MediaRouteProvider
    public final z c(String s, String s1) {
        if(s == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if(s1 == null) {
            throw new IllegalArgumentException("routeGroupId cannot be null");
        }
        return this.i(s, s1, A.b);
    }

    @Override  // androidx.mediarouter.media.MediaRouteProvider
    public final z d(String s, A a0) {
        if(s == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        return this.i(s, null, a0);
    }

    @Override  // androidx.mediarouter.media.MediaRouteProvider
    public final void e(v v0) {
        if(this.o) {
            int v1 = this.n.d;
            this.n.d = v1 + 1;
            this.n.b(10, v1, 0, (v0 == null ? null : v0.a), null);
        }
        this.l();
    }

    public final void h() {
        if(!this.m) {
            Intent intent0 = new Intent("android.media.MediaRouteProviderService");
            intent0.setComponent(this.i);
            try {
                this.m = this.a.bindService(intent0, this, (Build.VERSION.SDK_INT < 29 ? 1 : 0x1001));
            }
            catch(SecurityException unused_ex) {
            }
        }
    }

    public final h0 i(String s, String s1, A a0) {
        B b0 = this.g;
        if(b0 != null) {
            List list0 = b0.b;
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                if(((u)list0.get(v1)).f().equals(s)) {
                    h0 h00 = new h0(this, s, s1, a0);
                    this.k.add(h00);
                    if(this.o) {
                        h00.a(this.n);
                    }
                    this.l();
                    return h00;
                }
            }
        }
        return null;
    }

    public final void j() {
        if(this.n != null) {
            this.f(null);
            this.o = false;
            ArrayList arrayList0 = this.k;
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                ((d0)arrayList0.get(v1)).c();
            }
            c0 c00 = this.n;
            c00.b(2, 0, 0, null, null);
            c00.b.b.clear();
            c00.a.getBinder().unlinkToDeath(c00, 0);
            b0 b00 = new b0(c00, 0);
            c00.i.j.post(b00);
            this.n = null;
        }
    }

    public final void k() {
        if(this.m) {
            this.m = false;
            this.j();
            try {
                this.a.unbindService(this);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                Log.e("MediaRouteProviderProxy", this + ": unbindService failed", illegalArgumentException0);
            }
        }
    }

    public final void l() {
        if(this.l && (this.e != null || !this.k.isEmpty())) {
            this.h();
            return;
        }
        this.k();
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        if(this.m) {
            this.j();
            Messenger messenger0 = iBinder0 == null ? null : new Messenger(iBinder0);
            if(messenger0 == null) {
            label_15:
                Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
            }
            else {
                try {
                    if(messenger0.getBinder() == null) {
                        goto label_15;
                    }
                    else {
                        goto label_5;
                    }
                    return;
                }
                catch(NullPointerException unused_ex) {
                    goto label_15;
                }
            label_5:
                c0 c00 = new c0(this, messenger0);
                int v = c00.d;
                c00.d = v + 1;
                c00.g = v;
                if(c00.b(1, v, 4, null, null)) {
                    try {
                        c00.a.getBinder().linkToDeath(c00, 0);
                        this.n = c00;
                    }
                    catch(RemoteException unused_ex) {
                        c00.binderDied();
                    }
                }
            }
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        this.j();
    }

    @Override
    public final String toString() {
        return "Service connection " + this.i.flattenToShortString();
    }
}

