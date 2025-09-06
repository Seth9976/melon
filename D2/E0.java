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

public final class e0 extends i implements n {
    public int B;
    public int D;
    public int E;
    public Object G;
    public final GlanceAppWidgetReceiver I;
    public final Context M;
    public final int[] N;
    public GlanceAppWidgetReceiver r;
    public Context w;

    public e0(GlanceAppWidgetReceiver glanceAppWidgetReceiver0, Context context0, int[] arr_v, Continuation continuation0) {
        this.I = glanceAppWidgetReceiver0;
        this.M = context0;
        this.N = arr_v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e0(this.I, this.M, this.N, continuation0);
        continuation1.G = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int[] arr_v;
        int v1;
        Context context0;
        int v;
        GlanceAppWidgetReceiver glanceAppWidgetReceiver0;
        a a0 = a.a;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                GlanceAppWidgetReceiver.a(this.I, ((CoroutineScope)this.G), this.M);
                glanceAppWidgetReceiver0 = this.I;
                v = this.N.length;
                context0 = this.M;
                v1 = 0;
                arr_v = this.N;
                goto label_18;
            }
            case 1: {
                v = this.D;
                v1 = this.B;
                context0 = this.w;
                glanceAppWidgetReceiver0 = this.r;
                arr_v = (int[])this.G;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            ++v1;
        label_18:
            if(v1 >= v) {
                break;
            }
            int v2 = arr_v[v1];
            T t0 = glanceAppWidgetReceiver0.b();
            this.G = arr_v;
            this.r = glanceAppWidgetReceiver0;
            this.w = context0;
            this.B = v1;
            this.D = v;
            this.E = 1;
            if(t0.c(context0, v2, this) != a0) {
                continue;
            }
            return a0;
        }
        return H.a;
    }
}

