package D2;

import android.content.Context;
import android.util.Log;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.appwidget.GlanceAppWidgetReceiver;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import w8.T;
import we.n;

public final class i0 extends i implements n {
    public final GlanceAppWidgetReceiver B;
    public int r;
    public final Context w;

    public i0(Context context0, GlanceAppWidgetReceiver glanceAppWidgetReceiver0, Continuation continuation0) {
        this.w = context0;
        this.B = glanceAppWidgetReceiver0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                try {
                    GlanceAppWidgetManager glanceAppWidgetManager0 = new GlanceAppWidgetManager(this.w);
                    T t0 = this.B.b();
                    this.r = 1;
                    return glanceAppWidgetManager0.c(this.B, t0, this) == a0 ? a0 : H.a;
                }
                catch(CancellationException unused_ex) {
                    return H.a;
                }
                catch(Throwable throwable0) {
                }
                Log.e("GlanceAppWidget", "Error in Glance App Widget", throwable0);
                return H.a;
            }
            case 1: {
                try {
                    d5.n.D(object0);
                }
                catch(CancellationException unused_ex) {
                }
                catch(Throwable throwable0) {
                    Log.e("GlanceAppWidget", "Error in Glance App Widget", throwable0);
                }
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

