package androidx.compose.foundation;

import I.G0;
import J0.e;
import K.l;
import K.m;
import K.o;
import P0.A0;
import P0.D0;
import P0.I;
import P0.d0;
import P0.f;
import android.view.ViewGroup;
import android.view.ViewParent;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import r0.p;
import we.n;

public final class c extends i implements n {
    public final j B;
    public final long D;
    public final l E;
    public o r;
    public int w;

    public c(j j0, long v, l l0, Continuation continuation0) {
        this.B = j0;
        this.D = v;
        this.E = l0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        o o1;
        boolean z1;
        boolean z;
        a a0 = a.a;
        j j0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                e e0 = new e(c0, 1);
                if(!j0.getNode().isAttached()) {
                    M0.a.b("visitAncestors called on an unattached node");
                }
                p p0 = j0.getNode().getParent$ui_release();
                I i0 = f.v(j0);
            label_11:
                while(i0 != null) {
                    if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x40000) != 0) {
                        while(p0 != null) {
                            if((p0.getKindSet$ui_release() & 0x40000) != 0) {
                                p p1 = p0;
                                g0.e e1 = null;
                                while(p1 != null) {
                                    if(p1 instanceof D0) {
                                        Object object1 = ((D0)p1).f();
                                        if(!(G0.b.equals(object1) ? ((Boolean)e0.invoke(((D0)p1))).booleanValue() : true)) {
                                            break label_11;
                                        }
                                    }
                                    else if((p1.getKindSet$ui_release() & 0x40000) != 0 && p1 instanceof P0.n) {
                                        p p2 = ((P0.n)p1).b;
                                        int v = 0;
                                        while(p2 != null) {
                                            if((p2.getKindSet$ui_release() & 0x40000) != 0) {
                                                ++v;
                                                if(v == 1) {
                                                    p1 = p2;
                                                }
                                                else {
                                                    if(e1 == null) {
                                                        e1 = new g0.e(new p[16]);
                                                    }
                                                    if(p1 != null) {
                                                        e1.b(p1);
                                                        p1 = null;
                                                    }
                                                    e1.b(p2);
                                                }
                                            }
                                            p2 = p2.getChild$ui_release();
                                        }
                                        if(v != 1) {
                                            goto label_40;
                                        }
                                        continue;
                                    }
                                label_40:
                                    p1 = f.f(e1);
                                }
                            }
                            p0 = p0.getParent$ui_release();
                        }
                    }
                    i0 = i0.u();
                    if(i0 != null) {
                        d0 d00 = i0.b0;
                        if(d00 != null) {
                            p0 = (A0)d00.e;
                            continue;
                        }
                    }
                    p0 = null;
                }
                if(c0.a) {
                    z1 = true;
                }
                else {
                    for(ViewParent viewParent0 = f.x(j0).getParent(); true; viewParent0 = ((ViewGroup)viewParent0).getParent()) {
                        z = false;
                        if(viewParent0 == null || !(viewParent0 instanceof ViewGroup)) {
                            break;
                        }
                        if(((ViewGroup)viewParent0).shouldDelayChildPressedState()) {
                            z = true;
                            break;
                        }
                    }
                    z1 = z;
                }
                if(z1) {
                    this.w = 1;
                    if(DelayKt.delay(D.a, this) == a0) {
                        return a0;
                    }
                }
                goto label_73;
            }
            case 1: {
                d5.n.D(object0);
            label_73:
                o o0 = new o(this.D);
                this.r = o0;
                this.w = 2;
                if(((m)this.E).a(o0, this) == a0) {
                    return a0;
                }
                o1 = o0;
                break;
            }
            case 2: {
                o1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        j0.l = o1;
        return H.a;
    }
}

