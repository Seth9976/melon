package M7;

import Uf.b;
import Uf.d;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.firebase.e;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import x1.a;

public final class c0 extends Handler {
    public boolean a;
    public long b;
    public final ArrayList c;

    public c0(Looper looper0) {
        super(looper0);
        this.c = new ArrayList();
    }

    public final void a() {
        Log.d("SessionLifecycleService", "Broadcasting new session");
        Q q0 = (Q)((i)(((s)e.c().b(s.class)))).q.get();
        N n0 = ((W)((i)(((s)e.c().b(s.class)))).t.get()).e;
        if(n0 != null) {
            ((U)q0).getClass();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(((U)q0).e), null, null, new S(((U)q0), n0, null), 3, null);
            for(Object object0: new ArrayList(this.c)) {
                q.f(((Messenger)object0), "it");
                this.b(((Messenger)object0));
            }
            return;
        }
        q.m("currentSession");
        throw null;
    }

    public final void b(Messenger messenger0) {
        try {
            String s = null;
            Class class0 = s.class;
            if(this.a) {
                N n0 = ((W)((i)(((s)e.c().b(class0)))).t.get()).e;
                if(n0 != null) {
                    this.d(messenger0, n0.a);
                    return;
                }
                q.m("currentSession");
                throw null;
            }
            v v0 = (v)((L)((i)(((s)e.c().b(class0)))).o.get()).c.get();
            if(v0 != null) {
                s = v0.a;
            }
            Log.d("SessionLifecycleService", "App has not yet foregrounded. Using previously stored session.");
            if(s != null) {
                this.d(messenger0, s);
            }
            return;
        }
        catch(IllegalStateException illegalStateException0) {
        }
        Log.w("SessionLifecycleService", "Failed to send session to client.", illegalStateException0);
    }

    public final void c() {
        try {
            W w0 = (W)((i)(((s)e.c().b(s.class)))).t.get();
            int v = w0.d + 1;
            w0.d = v;
            String s = v == 0 ? w0.c : w0.a();
            int v1 = w0.d;
            w0.a.getClass();
            w0.e = new N(v1, s, w0.c, System.currentTimeMillis() * 1000L);
            Log.d("SessionLifecycleService", "Generated new session.");
            this.a();
            L l0 = (L)((i)(((s)e.c().b(s.class)))).o.get();
            N n0 = ((W)((i)(((s)e.c().b(s.class)))).t.get()).e;
            if(n0 != null) {
                l0.getClass();
                q.g(n0.a, "sessionId");
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(l0.a), null, null, new K(l0, n0.a, null), 3, null);
                return;
            }
            q.m("currentSession");
            throw null;
        }
        catch(IllegalStateException illegalStateException0) {
        }
        Log.w("SessionLifecycleService", "Failed to generate new session.", illegalStateException0);
    }

    public final void d(Messenger messenger0, String s) {
        try {
            Bundle bundle0 = new Bundle();
            bundle0.putString("SessionUpdateExtra", s);
            Message message0 = Message.obtain(null, 3, 0, 0);
            message0.setData(bundle0);
            messenger0.send(message0);
        }
        catch(DeadObjectException unused_ex) {
            Log.d("SessionLifecycleService", "Removing dead client from list: " + messenger0);
            this.c.remove(messenger0);
        }
        catch(Exception exception0) {
            Log.w("SessionLifecycleService", "Unable to push new session to " + messenger0 + '.', exception0);
        }
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        long v1;
        q.g(message0, "msg");
        if(Long.compare(this.b, message0.getWhen()) > 0) {
            Log.d("SessionLifecycleService", "Ignoring old message from " + message0.getWhen() + " which is older than " + this.b + '.');
            return;
        }
        switch(message0.what) {
            case 1: {
                Log.d("SessionLifecycleService", "Activity foregrounding at " + message0.getWhen() + '.');
                if(this.a) {
                    long v = message0.getWhen() - this.b;
                    Q7.i i0 = (Q7.i)((i)(((s)e.c().b(s.class)))).k.get();
                    b b0 = i0.a.b();
                    if(b0 == null) {
                    label_20:
                        b b1 = i0.b.b();
                        if(b1 == null) {
                            v1 = a.P(30, d.e);
                        }
                        else {
                            v1 = b1.a;
                            if(v1 <= 0L || b.g(v1)) {
                                v1 = a.P(30, d.e);
                            }
                        }
                    }
                    else {
                        v1 = b0.a;
                        if(v1 <= 0L || b.g(v1)) {
                            goto label_20;
                        }
                    }
                    if(v > b.d(v1)) {
                        Log.d("SessionLifecycleService", "Session too long in background. Creating new session.");
                        this.c();
                    }
                }
                else {
                    Log.d("SessionLifecycleService", "Cold start detected.");
                    this.a = true;
                    this.c();
                }
                this.b = message0.getWhen();
                return;
            }
            case 2: {
                Log.d("SessionLifecycleService", "Activity backgrounding at " + message0.getWhen());
                this.b = message0.getWhen();
                return;
            }
            case 4: {
                this.c.add(message0.replyTo);
                Messenger messenger0 = message0.replyTo;
                q.f(messenger0, "msg.replyTo");
                this.b(messenger0);
                Log.d("SessionLifecycleService", "Client " + message0.replyTo + " bound at " + message0.getWhen() + ". Clients: " + this.c.size());
                return;
            }
            default: {
                Log.w("SessionLifecycleService", "Received unexpected event from the SessionLifecycleClient: " + message0);
                super.handleMessage(message0);
            }
        }
    }
}

