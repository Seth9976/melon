package androidx.media;

import Bb.e;
import Ua.h;
import X2.a;
import X2.f;
import X2.g;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class MediaBrowserServiceCompat extends Service {
    public f a;
    public final h b;
    public final a c;
    public final ArrayList d;
    public final androidx.collection.f e;
    public final e f;

    static {
        Log.isLoggable("MBServiceCompat", 3);
    }

    public MediaBrowserServiceCompat() {
        this.b = new h(this);
        this.c = new a(this, "android.media.session.MediaController", -1, -1, null);
        this.d = new ArrayList();
        this.e = new androidx.collection.f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        e e0 = new e(4);
        e0.b = this;
        this.f = e0;
    }

    public abstract x1.a a();

    public abstract void b();

    @Override  // android.app.Service
    public final void dump(FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        return this.a.b.onBind(intent0);
    }

    @Override  // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.a = Build.VERSION.SDK_INT >= 28 ? new g(this) : new f(this);  // 初始化器: LX2/f;-><init>(Landroidx/media/MediaBrowserServiceCompat;)V
        f f0 = this.a;
        f0.getClass();
        X2.e e0 = new X2.e(f0, f0.f);
        f0.b = e0;
        e0.onCreate();
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        this.f.b = null;
    }
}

