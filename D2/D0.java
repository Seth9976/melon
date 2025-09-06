package D2;

import android.content.Context;
import android.os.Bundle;
import androidx.glance.appwidget.GlanceAppWidgetReceiver;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import w8.T;
import we.n;

public final class d0 extends i implements n {
    public final GlanceAppWidgetReceiver B;
    public final Context D;
    public final int E;
    public final Bundle G;
    public int r;
    public Object w;

    public d0(GlanceAppWidgetReceiver glanceAppWidgetReceiver0, Context context0, int v, Bundle bundle0, Continuation continuation0) {
        this.B = glanceAppWidgetReceiver0;
        this.D = context0;
        this.E = v;
        this.G = bundle0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d0(this.B, this.D, this.E, this.G, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                GlanceAppWidgetReceiver.a(this.B, ((CoroutineScope)this.w), this.D);
                T t0 = this.B.b();
                this.r = 1;
                t0.getClass();
                f f0 = new f(this.E);
                S s0 = new S(this.G, null, 0);
                Q q0 = new Q(this.D, f0, t0, this.G, s0, null);
                H h1 = t0.a.a(q0, this);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 != a0) {
                    h1 = h0;
                }
                return h1 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

