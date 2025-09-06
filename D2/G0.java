package D2;

import android.content.Context;
import androidx.glance.appwidget.GlanceAppWidgetReceiver;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import w8.T;
import we.n;

public final class g0 extends i implements n {
    public final Context B;
    public final int D;
    public int r;
    public final GlanceAppWidgetReceiver w;

    public g0(GlanceAppWidgetReceiver glanceAppWidgetReceiver0, Context context0, int v, Continuation continuation0) {
        this.w = glanceAppWidgetReceiver0;
        this.B = context0;
        this.D = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g0(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                T t0 = this.w.b();
                this.r = 1;
                return T.h(t0, this.B, this.D, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

