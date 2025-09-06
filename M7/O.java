package M7;

import Bb.e;
import N7.c;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.sessions.SessionLifecycleService;
import com.google.firebase.sessions.SessionLifecycleServiceBinderImpl;
import e7.h;
import ie.H;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import o9.b;
import oe.i;
import we.n;

public final class o extends i implements n {
    public final me.i B;
    public final SessionLifecycleServiceBinderImpl D;
    public int r;
    public final p w;

    public o(p p0, me.i i0, SessionLifecycleServiceBinderImpl sessionLifecycleServiceBinderImpl0, Continuation continuation0) {
        this.w = p0;
        this.B = i0;
        this.D = sessionLifecycleServiceBinderImpl0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z1;
        boolean z;
        p p0 = this.w;
        Q7.i i0 = p0.b;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = c.a.b(this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_11;
            }
            case 1: {
                d5.n.D(object0);
            label_11:
                Iterable iterable0 = ((Map)object0).values();
                if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                    for(Object object1: iterable0) {
                        if(!((h)object1).a.f()) {
                            continue;
                        }
                        this.r = 2;
                        if(i0.b(this) == a0) {
                            return a0;
                        }
                        goto label_23;
                    }
                }
                Log.d("FirebaseSessions", "No Sessions subscribers. Not listening to lifecycle events.");
                return H.a;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(object0);
    label_23:
        Boolean boolean0 = i0.a.a();
        if(boolean0 == null) {
            boolean0 = i0.b.a();
            z = boolean0 == null ? true : boolean0.booleanValue();
        }
        else {
            z = boolean0.booleanValue();
        }
        if(!z) {
            Log.d("FirebaseSessions", "Sessions SDK disabled. Not listening to lifecycle events.");
            return H.a;
        }
        q.g(this.B, "backgroundDispatcher");
        b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.a = this.B;
        b0.c = new LinkedBlockingDeque(20);
        b0.d = new b0(b0, 0);
        q.g(this.D, "sessionLifecycleServiceBinder");
        Messenger messenger0 = new Messenger(new e(this.B));
        b0 b00 = (b0)b0.d;
        q.g(b00, "serviceConnection");
        Context context0 = this.D.a;
        Intent intent0 = new Intent(context0, SessionLifecycleService.class);
        Log.d("LifecycleServiceBinder", "Binding service to application.");
        intent0.setAction("1898");
        intent0.putExtra("ClientCallbackMessenger", messenger0);
        intent0.setPackage("com.iloen.melon");
        try {
            z1 = context0.bindService(intent0, b00, 65);
        }
        catch(SecurityException securityException0) {
            Log.w("LifecycleServiceBinder", "Failed to bind session lifecycle service to application.", securityException0);
            z1 = false;
        }
        if(!z1) {
            try {
                context0.unbindService(b00);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                Log.w("LifecycleServiceBinder", "Session lifecycle service binding failed.", illegalArgumentException0);
            }
            Log.i("LifecycleServiceBinder", "Session lifecycle service binding failed.");
        }
        d0.c = b0;
        if(d0.b) {
            d0.b = false;
            b0.u(1);
        }
        B3.n n0 = new B3.n(17);
        p0.a.a();
        Preconditions.checkNotNull(n0);
        p0.a.j.add(n0);
        return H.a;
    }
}

