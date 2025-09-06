package M7;

import N7.c;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import e.k;
import e7.h;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import je.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import o9.b;
import oe.i;
import we.n;

public final class a0 extends i implements n {
    public final ArrayList B;
    public int r;
    public final b w;

    public a0(b b0, ArrayList arrayList0, Continuation continuation0) {
        this.w = b0;
        this.B = arrayList0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = c.a.b(this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((Map)object0).isEmpty()) {
            Log.d("SessionLifecycleClient", "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent.");
            return H.a;
        }
        Iterable iterable0 = ((Map)object0).values();
        if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
            for(Object object1: iterable0) {
                if(!((h)object1).a.f()) {
                    continue;
                }
                b b0 = this.w;
                for(Object object2: p.J0(p.i0(k.C(new Message[]{b.o(b0, this.B, 2), b.o(b0, this.B, 1)})), new Z())) {  // 初始化器: Ljava/lang/Object;-><init>()V
                    Message message0 = (Message)object2;
                    if(((Messenger)b0.b) == null) {
                        b0.t(message0);
                    }
                    else {
                        try {
                            Log.d("SessionLifecycleClient", "Sending lifecycle " + message0.what + " to service");
                            Messenger messenger0 = (Messenger)b0.b;
                            if(messenger0 == null) {
                                continue;
                            }
                            messenger0.send(message0);
                        }
                        catch(RemoteException remoteException0) {
                            Log.w("SessionLifecycleClient", "Unable to deliver message: " + message0.what, remoteException0);
                            b0.t(message0);
                        }
                    }
                }
                return H.a;
            }
        }
        Log.d("SessionLifecycleClient", "Data Collection is disabled for all subscribers. Skipping this Event");
        return H.a;
    }
}

