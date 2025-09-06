package androidx.media3.session;

import I6.V;
import P0.c0;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import b3.N;
import com.google.firebase.messaging.u;
import e3.b;

public final class B0 extends Handler {
    public boolean a;
    public boolean b;
    public final n0 c;

    public B0(n0 n00, Looper looper0) {
        this.c = n00;
        super(looper0);
        this.a = true;
        this.b = true;
    }

    public final void a(boolean z, boolean z1) {
        boolean z2 = false;
        this.a = this.a && z;
        if(this.b && z1) {
            z2 = true;
        }
        this.b = z2;
        if(!this.hasMessages(1)) {
            this.sendEmptyMessage(1);
        }
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        int v2;
        n0 n00 = this.c;
        f1 f10 = n00.g;
        if(message0.what != 1) {
            throw new IllegalStateException("Invalid message what=" + message0.what);
        }
        k1 k10 = n00.s.n(n00.t.p0(), n00.t.n0(), n00.s.k);
        n00.s = k10;
        boolean z = this.a;
        boolean z1 = this.b;
        k1 k11 = f10.E0(k10);
        u u0 = f10.c;
        V v0 = u0.k();
        int v1 = 0;
        while(v1 < v0.size()) {
            w0 w00 = (w0)v0.get(v1);
            try {
                c0 c00 = u0.n(w00);
                if(c00 == null) {
                    if(!n00.j(w00)) {
                        break;
                    }
                    v2 = 0;
                }
                else {
                    v2 = c00.r();
                }
                N n0 = h1.d(u0.i(w00), n00.t.y());
                b.k(w00.d);
                w00.d.g(v2, k11, n0, z, z1);
                goto label_28;
            }
            catch(DeadObjectException unused_ex) {
            }
            catch(RemoteException remoteException0) {
                goto label_27;
            }
            f10.c.w(w00);
            goto label_28;
        label_27:
            b.E("MediaSessionImpl", "Exception in " + w00.toString(), remoteException0);
        label_28:
            ++v1;
        }
        this.a = true;
        this.b = true;
    }
}

