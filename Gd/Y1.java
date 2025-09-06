package gd;

import N0.Z;
import N0.a0;
import Q4.a;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.foundation.w;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import com.iloen.melon.custom.B1;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import l2.Y;
import l2.e0;
import r0.u;
import v1.c;
import v1.m;
import v1.p;
import w1.j;
import we.k;
import we.o;

public final class y1 extends r implements k {
    public final int f;
    public final Object g;
    public final Object h;

    public y1(int v, Object object0, Object object1) {
        this.f = v;
        this.g = object0;
        this.h = object1;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        LayoutInflater layoutInflater0;
        H h2;
        H h1;
        switch(this.f) {
            case 0: {
                int v = ((Number)object0).intValue();
                Object object1 = ((List)this.h).get(v);
                return ((B1)this.g).invoke(v, object1);
            }
            case 1: {
                int v1 = ((Number)object0).intValue();
                Object object2 = ((ArrayList)this.h).get(v1);
                return ((B1)this.g).invoke(v1, object2);
            }
            case 2: {
                int v2 = ((Number)object0).intValue();
                Object object3 = ((List)this.h).get(v2);
                return ((B1)this.g).invoke(v2, object3);
            }
            case 3: {
                int v3 = ((Number)object0).intValue();
                Object object4 = ((List)this.h).get(v3);
                return ((B1)this.g).invoke(v3, object4);
            }
            case 4: {
                int v4 = ((Number)object0).intValue();
                Object object5 = ((List)this.h).get(v4);
                return ((B1)this.g).invoke(v4, object5);
            }
            case 5: {
                int v5 = ((Number)object0).intValue();
                Object object6 = ((ArrayList)this.h).get(v5);
                return ((B1)this.g).invoke(v5, object6);
            }
            case 6: {
                int v6 = ((Number)object0).intValue();
                Object object7 = ((List)this.h).get(v6);
                return ((B1)this.g).invoke(v6, object7);
            }
            case 7: {
                int v7 = ((Number)object0).intValue();
                Object object8 = ((List)this.h).get(v7);
                return ((B1)this.g).invoke(v7, object8);
            }
            case 8: {
                int v8 = ((Number)object0).intValue();
                Object object9 = ((List)this.h).get(v8);
                return ((B1)this.g).invoke(v8, object9);
            }
            case 9: {
                int v9 = ((Number)object0).intValue();
                Object object10 = ((List)this.h).get(v9);
                return ((M6)this.g).invoke(v9, object10);
            }
            case 10: {
                int v10 = ((Number)object0).intValue();
                Object object11 = ((ArrayList)this.h).get(v10);
                return ((M6)this.g).invoke(v10, object11);
            }
            case 11: {
                int v11 = ((Number)object0).intValue();
                Object object12 = ((ArrayList)this.h).get(v11);
                return ((M6)this.g).invoke(v11, object12);
            }
            case 12: {
                int v12 = ((Number)object0).intValue();
                Object object13 = ((List)this.h).get(v12);
                return ((M6)this.g).invoke(v12, object13);
            }
            case 13: {
                int v13 = ((Number)object0).intValue();
                Object object14 = ((List)this.h).get(v13);
                return ((M6)this.g).invoke(v13, object14);
            }
            case 14: {
                int v14 = ((Number)object0).intValue();
                Object object15 = ((List)this.h).get(v14);
                return ((M6)this.g).invoke(v14, object15);
            }
            case 15: {
                int v15 = ((Number)object0).intValue();
                Object object16 = ((List)this.h).get(v15);
                return ((M6)this.g).invoke(v15, object16);
            }
            case 16: {
                int v16 = ((Number)object0).intValue();
                Object object17 = ((List)this.h).get(v16);
                return ((M6)this.g).invoke(v16, object17);
            }
            case 17: {
                int v17 = ((Number)object0).intValue();
                Object object18 = ((ArrayList)this.h).get(v17);
                return ((M6)this.g).invoke(v17, object18);
            }
            case 18: {
                int v18 = ((Number)object0).intValue();
                Object object19 = ((List)this.h).get(v18);
                return ((M6)this.g).invoke(v18, object19);
            }
            case 19: {
                int v19 = ((Number)object0).intValue();
                Object object20 = ((List)this.h).get(v19);
                return ((M6)this.g).invoke(v19, object20);
            }
            case 20: {
                int v20 = ((Number)object0).intValue();
                Object object21 = ((List)this.h).get(v20);
                return ((M6)this.g).invoke(v20, object21);
            }
            case 21: {
                int v21 = ((Number)object0).intValue();
                Object object22 = ((List)this.h).get(v21);
                return ((M6)this.g).invoke(v21, object22);
            }
            case 22: {
                int v22 = ((Number)object0).intValue();
                Object object23 = ((List)this.h).get(v22);
                return ((M6)this.g).invoke(v22, object23);
            }
            case 23: {
                ((w)this.g).invoke(((Throwable)object0));
                Channel channel0 = ((e0)this.h).c;
                channel0.close(((Throwable)object0));
                do {
                    Object object24 = ChannelResult.getOrNull-impl(channel0.tryReceive-PtdJZtk());
                    h1 = H.a;
                    if(object24 == null) {
                        h2 = null;
                    }
                    else {
                        CompletableDeferred completableDeferred0 = ((Y)object24).b;
                        Throwable throwable0 = ((Throwable)object0) == null ? new CancellationException("DataStore scope was cancelled before updateData could complete") : ((Throwable)object0);
                        completableDeferred0.completeExceptionally(throwable0);
                        h2 = h1;
                    }
                }
                while(h2 != null);
                return h1;
            }
            case 24: {
                ((Z)object0).d(((a0)this.g), 0, 0, ((u)this.h).a);
                return H.a;
            }
            case 25: {
                j j0 = (j)this.g;
                if(((Throwable)object0) != null) {
                    if(((Throwable)object0) instanceof CancellationException) {
                        j0.b();
                        return H.a;
                    }
                    j0.c(((Throwable)object0));
                    return H.a;
                }
                j0.a(((Deferred)this.h).getCompleted());
                return H.a;
            }
            case 26: {
                I i0 = (I)this.g;
                if(i0 == null) {
                    layoutInflater0 = LayoutInflater.from(((Context)object0));
                }
                else {
                    layoutInflater0 = i0.getLayoutInflater();
                    if(layoutInflater0 == null) {
                        layoutInflater0 = LayoutInflater.from(((Context)object0));
                    }
                }
                FrameLayout frameLayout0 = new FrameLayout(((Context)object0));
                a a0 = (a)((o)this.h).invoke(layoutInflater0, frameLayout0, Boolean.FALSE);
                View view0 = a0.getRoot();
                view0.setTag(0x7F0A010A, a0);  // id:binding_reference
                return view0;
            }
            case 27: {
                Object object25 = ((View)object0).getTag(0x7F0A010A);  // id:binding_reference
                q.e(object25, "null cannot be cast to non-null type T of androidx.compose.ui.viewinterop.AndroidViewBindingKt.getBinding");
                a a1 = (a)object25;
                l0 l00 = null;
                ViewGroup viewGroup0 = ((View)object0) instanceof ViewGroup ? ((ViewGroup)(((View)object0))) : null;
                if(viewGroup0 != null) {
                    I i1 = (I)this.g;
                    Context context0 = (Context)this.h;
                    if(i1 == null) {
                    label_127:
                        FragmentActivity fragmentActivity0 = context0 instanceof FragmentActivity ? ((FragmentActivity)context0) : null;
                        if(fragmentActivity0 != null) {
                            l00 = fragmentActivity0.getSupportFragmentManager();
                        }
                    }
                    else {
                        l0 l01 = i1.getChildFragmentManager();
                        if(l01 != null) {
                            l00 = l01;
                            u1.j.g(viewGroup0, new w(l00, 21));
                            return H.a;
                        }
                        goto label_127;
                    }
                    u1.j.g(viewGroup0, new w(l00, 21));
                }
                return H.a;
            }
            case 28: {
                r0.q q0 = ((r0.q)object0).then(((r0.q)this.h));
                ((P0.I)this.g).c0(q0);
                return H.a;
            }
            default: {
                androidx.compose.runtime.H h0 = (androidx.compose.runtime.H)object0;
                ((m)this.g).setPositionProvider(((p)this.h));
                ((m)this.g).m();
                return new c();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
        }
    }
}

