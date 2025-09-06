package D2;

import L2.j;
import L2.o;
import U4.F;
import androidx.glance.appwidget.GlanceRemoteViewsService;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.i;
import w8.T;
import we.n;

public final class l0 extends i implements n {
    public final m0 B;
    public final f D;
    public final T E;
    public int r;
    public Object w;

    public l0(m0 m00, f f0, T t0, Continuation continuation0) {
        this.B = m00;
        this.D = f0;
        this.E = t0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l0(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l0)this.create(((o)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        o o2;
        o o1;
        GlanceRemoteViewsService glanceRemoteViewsService0 = this.B.a;
        a a0 = a.a;
        f f0 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                o o0 = (o)this.w;
                this.w = o0;
                this.r = 1;
                Object object1 = o0.a(glanceRemoteViewsService0, F.p(f0.a), this);
                if(object1 == a0) {
                    return a0;
                }
                o1 = o0;
                object0 = object1;
                goto label_18;
            }
            case 1: {
                o1 = (o)this.w;
                d5.n.D(object0);
            label_18:
                if(((Boolean)object0).booleanValue()) {
                    return null;
                }
                p p0 = new p(this.E, f0, null, 0xFC);
                this.w = o1;
                this.r = 2;
                if(o1.b(glanceRemoteViewsService0, p0, this) == a0) {
                    return a0;
                }
                o2 = o1;
                break;
            }
            case 2: {
                o2 = (o)this.w;
                d5.n.D(object0);
                break;
            }
            case 3: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        j j0 = (j)o2.a.get(F.p(f0.a));
        q.e(j0, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetSession");
        this.w = null;
        this.r = 3;
        Object object2 = ((p)j0).f(this);
        return object2 == a0 ? a0 : object2;
    }
}

