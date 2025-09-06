package w8;

import D2.f;
import android.content.Context;
import android.os.Bundle;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import com.iloen.melon.appwidget.GlanceHomeWidgetReceiver;
import ie.H;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class y0 extends i implements n {
    public Bundle B;
    public Iterator D;
    public f E;
    public int G;
    public int I;
    public int M;
    public final Context N;
    public final GlanceHomeWidgetReceiver S;
    public final Bundle T;
    public Context r;
    public GlanceHomeWidgetReceiver w;

    public y0(Context context0, GlanceHomeWidgetReceiver glanceHomeWidgetReceiver0, Bundle bundle0, Continuation continuation0) {
        this.N = context0;
        this.S = glanceHomeWidgetReceiver0;
        this.T = bundle0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y0(this.N, this.S, this.T, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Iterator iterator2;
        int v4;
        int v3;
        Context context1;
        GlanceHomeWidgetReceiver glanceHomeWidgetReceiver1;
        Bundle bundle1;
        f f0;
        int v;
        Bundle bundle0;
        Iterator iterator0;
        a a0 = a.a;
        GlanceHomeWidgetReceiver glanceHomeWidgetReceiver0 = this.S;
        Context context0 = this.N;
    alab1:
        switch(this.M) {
            case 0: {
                d5.n.D(object0);
                GlanceAppWidgetManager glanceAppWidgetManager0 = new GlanceAppWidgetManager(context0);
                Class class0 = glanceHomeWidgetReceiver0.c().getClass();
                this.M = 1;
                object0 = glanceAppWidgetManager0.a(class0, this);
                if(object0 != a0) {
                    iterator0 = ((Iterable)object0).iterator();
                    bundle0 = this.T;
                    v = 0;
                    goto label_40;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                iterator0 = ((Iterable)object0).iterator();
                bundle0 = this.T;
                v = 0;
                goto label_40;
            }
            case 2: {
                int v1 = this.I;
                int v2 = this.G;
                f0 = this.E;
                Iterator iterator1 = this.D;
                bundle1 = this.B;
                glanceHomeWidgetReceiver1 = this.w;
                context1 = this.r;
                d5.n.D(object0);
                v3 = v1;
                v4 = v2;
                iterator2 = iterator1;
                goto label_59;
            }
            case 3: {
                int v5 = this.G;
                Iterator iterator3 = this.D;
                Bundle bundle2 = this.B;
                GlanceHomeWidgetReceiver glanceHomeWidgetReceiver2 = this.w;
                Context context2 = this.r;
                d5.n.D(object0);
                glanceHomeWidgetReceiver0 = glanceHomeWidgetReceiver2;
                v = v5;
                bundle0 = bundle2;
                context0 = context2;
                iterator0 = iterator3;
                while(true) {
                label_40:
                    if(!iterator0.hasNext()) {
                        return H.a;
                    }
                    Object object1 = iterator0.next();
                    x0 x00 = new x0(bundle0, glanceHomeWidgetReceiver0, null);
                    this.r = context0;
                    this.w = glanceHomeWidgetReceiver0;
                    this.B = bundle0;
                    this.D = iterator0;
                    this.E = (f)object1;
                    this.G = v;
                    this.I = 0;
                    this.M = 2;
                    if(d5.f.Y(context0, ((f)object1), x00, this) == a0) {
                        break alab1;
                    }
                    glanceHomeWidgetReceiver1 = glanceHomeWidgetReceiver0;
                    context1 = context0;
                    f0 = (f)object1;
                    iterator2 = iterator0;
                    bundle1 = bundle0;
                    v3 = 0;
                    v4 = v;
                label_59:
                    w0 w00 = glanceHomeWidgetReceiver1.c();
                    this.r = context1;
                    this.w = glanceHomeWidgetReceiver1;
                    this.B = bundle1;
                    this.D = iterator2;
                    this.E = null;
                    this.G = v4;
                    this.I = v3;
                    this.M = 3;
                    if(w00.g(context1, f0, this) == a0) {
                        break alab1;
                    }
                    v = v4;
                    iterator0 = iterator2;
                    bundle0 = bundle1;
                    glanceHomeWidgetReceiver0 = glanceHomeWidgetReceiver1;
                    context0 = context1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

