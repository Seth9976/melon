package androidx.media3.session.legacy;

import Bb.e;
import E9.g;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.collection.f;
import androidx.lifecycle.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k8.Y;

public abstract class MediaBrowserServiceCompat extends Service {
    public s a;
    public final b b;
    public final n c;
    public final ArrayList d;
    public final f e;
    public n f;
    public final e g;
    public MediaSessionCompat.Token h;
    public static final boolean i;

    static {
        MediaBrowserServiceCompat.i = Log.isLoggable("MBServiceCompat", 3);
    }

    public MediaBrowserServiceCompat() {
        this.b = new b(this, 4);
        this.c = new n(this, "android.media.session.MediaController", -1, -1, null);
        this.d = new ArrayList();
        this.e = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        e e0 = new e(6);
        e0.b = this;
        this.g = e0;
    }

    public static List a(List list0, Bundle bundle0) {
        if(list0 == null) {
            return null;
        }
        if(bundle0 != null) {
            int v = bundle0.getInt("android.media.browse.extra.PAGE", -1);
            int v1 = bundle0.getInt("android.media.browse.extra.PAGE_SIZE", -1);
            if(v != -1 || v1 != -1) {
                int v2 = v1 * v;
                int v3 = v2 + v1;
                if(v >= 0 && v1 >= 1 && v2 < list0.size()) {
                    if(v3 > list0.size()) {
                        v3 = list0.size();
                    }
                    return list0.subList(v2, v3);
                }
                return Collections.EMPTY_LIST;
            }
        }
        return list0;
    }

    public void b(String s, Bundle bundle0, o o0) {
        o0.e();
    }

    public abstract g c(Bundle arg1);

    public abstract void d(String arg1, u arg2);

    @Override  // android.app.Service
    public final void dump(FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
    }

    public void e(String s, u u0, Bundle bundle0) {
        u0.e = 1;
        this.d(s, u0);
    }

    public void f(String s, u u0) {
        u0.e = 2;
        u0.f(null);
    }

    public void g(String s, Bundle bundle0, m m0) {
        m0.e = 4;
        m0.f(null);
    }

    public void h(Bundle bundle0, String s) {
    }

    public void i(String s) {
    }

    public final void j(String s, n n0, Bundle bundle0, Bundle bundle1) {
        k k0 = new k(this, s, n0, s, bundle0, bundle1);
        this.f = n0;
        if(bundle0 == null) {
            this.d(s, k0);
        }
        else {
            this.e(s, k0, bundle0);
        }
        this.f = null;
        if(!k0.b()) {
            throw new IllegalStateException(Y.l(new StringBuilder("onLoadChildren must call detach() or sendResult() before returning for package="), n0.a, " id=", s));
        }
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        s s0 = this.a;
        s0.getClass();
        X2.b b0 = (X2.b)s0.b;
        b0.getClass();
        return b0.onBind(intent0);
    }

    @Override  // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.a = Build.VERSION.SDK_INT >= 28 ? new t(this) : new s(this);
        s s0 = this.a;
        s0.getClass();
        r r0 = new r(s0, s0.f);
        s0.b = r0;
        r0.onCreate();
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        this.g.b = null;
    }
}

