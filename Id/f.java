package id;

import B7.b;
import Bb.e;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.iloen.melon.utils.log.LogU;
import i.n.i.b.a.s.e.Ga;
import java.net.URL;
import kotlin.jvm.internal.q;
import ob.z;

public final class f {
    public final A a;
    public final z b;
    public int c;
    public long d;
    public URL e;
    public F f;
    public final b g;
    public D h;
    public Ga i;
    public final c j;
    public final HandlerThread k;
    public final e l;

    public f(A a0, z z0) {
        q.g(a0, "viewModel");
        q.g(z0, "playerUseCase");
        super();
        this.a = a0;
        this.b = z0;
        this.c = 1;
        this.d = 10000L;
        this.g = new b(17, false);
        HandlerThread handlerThread0 = new HandlerThread("MusicSearchController");
        this.k = handlerThread0;
        handlerThread0.start();
        this.j = new c(this, handlerThread0.getLooper());
        this.l = new e(this, Looper.getMainLooper(), 13);
    }

    public final void a() {
        D d0 = this.h;
        if(d0 != null) {
            d0.e = null;
        }
        if(d0 != null) {
            d0.a();
        }
        this.h = null;
        LogU.Companion.d("MusicSearchController", "releaseRecorder()");
        F f0 = this.f;
        if(f0 != null) {
            f0.cancel();
        }
        F f1 = this.f;
        if(f1 != null) {
            f1.h = null;
        }
        this.f = null;
        this.c = 1;
        this.d = 10000L;
    }

    public final void b(Object object0, int v, int v1, long v2) {
        Message message0 = new Message();
        message0.what = v;
        message0.arg1 = v1;
        message0.obj = object0;
        this.j.sendMessageDelayed(message0, v2);
    }
}

