package D2;

import android.content.Context;
import androidx.glance.appwidget.GlanceAppWidgetReceiver;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class h0 extends i implements n {
    public final GlanceAppWidgetReceiver B;
    public final Context D;
    public final int[] E;
    public int r;
    public Object w;

    public h0(GlanceAppWidgetReceiver glanceAppWidgetReceiver0, Context context0, int[] arr_v, Continuation continuation0) {
        this.B = glanceAppWidgetReceiver0;
        this.D = context0;
        this.E = arr_v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h0(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                GlanceAppWidgetReceiver glanceAppWidgetReceiver0 = this.B;
                Context context0 = this.D;
                GlanceAppWidgetReceiver.a(glanceAppWidgetReceiver0, coroutineScope0, context0);
                int[] arr_v = this.E;
                ArrayList arrayList0 = new ArrayList(arr_v.length);
                for(int v = 0; v < arr_v.length; ++v) {
                    arrayList0.add(BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new g0(glanceAppWidgetReceiver0, context0, arr_v[v], null), 3, null));
                }
                this.r = 1;
                return AwaitKt.awaitAll(arrayList0, this) == a0 ? a0 : H.a;
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

