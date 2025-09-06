package B2;

import D0.I;
import D2.W;
import D2.p;
import G.f;
import Hb.j;
import I.W0;
import I.h0;
import I.u0;
import I0.d;
import I0.g;
import K9.c;
import L2.h;
import Mc.D;
import N0.B;
import N0.j0;
import P0.V;
import U.H0;
import U.f0;
import W.w;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.a0;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.session.SessionWorker;
import androidx.lifecycle.r0;
import g0.b;
import g0.e;
import ie.H;
import java.util.HashSet;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import l2.i;
import we.a;
import we.k;

public final class o extends r implements a {
    public final int f;
    public final Object g;

    public o(Object object0, int v) {
        this.f = v;
        this.g = object0;
        super(0);
    }

    public o(a a0) {
        this.f = 0;
        this.g = (n)a0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return ((a)(((n)this.g))).invoke();
            }
            case 1: {
                int v = ((I)this.g).g;
                a0 a00 = ((I)this.g).d;
                if(v == ((K0)a00).m()) {
                    ((K0)a00).n(((K0)a00).m() + 1);
                }
                return H.a;
            }
            case 2: {
                ((O0)((p)this.g).i).getValue();
                return H.a;
            }
            case 3: {
                GlanceAppWidgetManager glanceAppWidgetManager0 = (GlanceAppWidgetManager)this.g;
                W w0 = GlanceAppWidgetManager.d;
                synchronized(w0) {
                    i i0 = GlanceAppWidgetManager.f;
                    if(i0 == null) {
                        i0 = (i)GlanceAppWidgetManager.e.getValue(glanceAppWidgetManager0.a, W.a[0]);
                        GlanceAppWidgetManager.f = i0;
                    }
                    return i0;
                }
            }
            case 4: {
                return f.m(((CoroutineScope)this.g).getCoroutineContext());
            }
            case 5: {
                return (h0)ChannelResult.getOrNull-impl(((Channel)this.g).tryReceive-PtdJZtk());
            }
            case 6: {
                return Boolean.valueOf(((W0)this.g).isAttached());
            }
            case 7: {
                return ((d)this.g).d;
            }
            case 8: {
                return ((g)this.g).m0();
            }
            case 9: {
                z6.f f0 = c.c;
                j j0 = ((I9.g)this.g).a.a;
                c c0 = c.d;
                if(c0 == null) {
                    synchronized(f0) {
                        c0 = c.d;
                        if(c0 == null) {
                            c0 = new c(j0);
                            c.d = c0;
                        }
                    }
                }
                return c0;
            }
            case 10: {
                long v3 = System.nanoTime();
                G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                G g1 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                synchronized(((h)this.g).c) {
                    g0.a = v3 - ((h)this.g).e;
                    g1.a = 1000000000L / ((long)((h)this.g).d);
                }
                L2.f f1 = new L2.f(g0, g1, ((h)this.g), v3, null);
                BuildersKt__Builders_commonKt.launch$default(((h)this.g).a, null, null, f1, 3, null);
                return H.a;
            }
            case 11: {
                CompletableJob completableJob0 = JobKt__JobKt.Job$default(null, 1, null);
                ((SessionWorker)this.g).getClass();
                return completableJob0;
            }
            case 12: {
                return (r0)((Mc.o)this.g).invoke();
            }
            case 13: {
                return (r0)((D)this.g).invoke();
            }
            case 14: {
                N0.I i1 = ((j0)this.g).a();
                P0.I i2 = i1.a;
                int v5 = ((b)i2.p()).a.c;
                if(i1.n != v5) {
                    Object[] arr_object = i1.f.c;
                    long[] arr_v = i1.f.a;
                    int v6 = arr_v.length - 2;
                    if(v6 >= 0) {
                        int v7 = 0;
                        while(true) {
                            long v8 = arr_v[v7];
                            if((~v8 << 7 & v8 & 0x8080808080808080L) == 0x8080808080808080L) {
                                goto label_81;
                            }
                            int v9 = 8 - (~(v7 - v6) >>> 0x1F);
                            for(int v10 = 0; v10 < v9; ++v10) {
                                if((0xFFL & v8) < 0x80L) {
                                    ((B)arr_object[(v7 << 3) + v10]).d = true;
                                }
                                v8 >>= 8;
                            }
                            if(v9 == 8) {
                            label_81:
                                if(v7 != v6) {
                                    ++v7;
                                    continue;
                                }
                            }
                            goto label_84;
                        }
                    }
                    else {
                    label_84:
                        if(!i2.r()) {
                            P0.I.W(i2, false, 7);
                        }
                    }
                }
                return H.a;
            }
            case 15: {
                e e0 = ((O0.c)this.g).c;
                e e1 = ((O0.c)this.g).b;
                e e2 = ((O0.c)this.g).e;
                ((O0.c)this.g).f = false;
                HashSet hashSet0 = new HashSet();
                e e3 = ((O0.c)this.g).d;
                Object[] arr_object1 = e3.a;
                int v12 = e3.c;
                for(int v13 = 0; v13 < v12; ++v13) {
                    P0.I i3 = (P0.I)arr_object1[v13];
                    O0.f f2 = (O0.f)e2.a[v13];
                    if(((r0.p)i3.b0.f).isAttached()) {
                        O0.c.b(((r0.p)i3.b0.f), f2, hashSet0);
                    }
                }
                e3.g();
                e2.g();
                Object[] arr_object2 = e1.a;
                int v14 = e1.c;
                for(int v11 = 0; v11 < v14; ++v11) {
                    P0.c c1 = (P0.c)arr_object2[v11];
                    O0.f f3 = (O0.f)e0.a[v11];
                    if(c1.isAttached()) {
                        O0.c.b(c1, f3, hashSet0);
                    }
                }
                e1.g();
                e0.g();
                for(Object object0: hashSet0) {
                    ((P0.c)object0).o0();
                }
                return H.a;
            }
            case 16: {
                ((P0.I)this.g).c0.p.T = true;
                V v15 = ((P0.I)this.g).c0.q;
                if(v15 != null) {
                    v15.E = true;
                }
                return H.a;
            }
            case 17: {
                ((k)this.g).invoke(P0.j0.c0);
                P0.j0.c0.I = P0.j0.c0.o.i(P0.j0.c0.B, P0.j0.c0.E, P0.j0.c0.D);
                return H.a;
            }
            case 18: {
                CoroutineScopeKt.cancel$default(((Q0.V)this.g).c, null, 1, null);
                return H.a;
            }
            case 19: {
                ((Q0.W)this.g).b = null;
                return H.a;
            }
            case 20: {
                ((a)((kotlin.jvm.internal.H)this.g).a).invoke();
                return H.a;
            }
            case 21: {
                return (x0.c)this.g;
            }
            case 22: {
                return (a1.g)this.g;
            }
            case 23: {
                a.a.o(((H.n)this.g));
                return H.a;
            }
            case 24: {
                return ((f0)this.g).d();
            }
            case 25: {
                return new H0(((u0)this.g), 0.0f);
            }
            case 26: {
                return new r1.j(((r1.k)this.g).a());
            }
            case 27: {
                Object object1 = ((View)((W.p)this.g).a).getContext().getSystemService("input_method");
                q.e(object1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                return (InputMethodManager)object1;
            }
            case 28: {
                return new BaseInputConnection(((w)this.g).a, false);
            }
            default: {
                ((X.h)this.g).r = null;
                X.h.m0(((X.h)this.g));
                return true;
            }
        }
    }
}

