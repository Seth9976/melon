package Dc;

import G.g;
import Hf.x;
import If.j;
import If.k;
import If.l;
import If.t;
import O.v;
import P0.f;
import Pd.h;
import androidx.compose.foundation.T;
import androidx.compose.foundation.U;
import androidx.compose.foundation.V;
import androidx.compose.foundation.lazy.layout.E;
import com.iloen.melon.MelonAppBase;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import w0.d;
import x0.c;

public final class s extends n implements we.n {
    public final int b;

    public s(int v, Object object0, Class class0, String s, String s1, int v1, int v2) {
        this.b = v2;
        super(v, v1, class0, object0, s, s1);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.b) {
            case 0: {
                q.g(((v)object0), "p0");
                q.g(((v)object1), "p1");
                ((u)this.receiver).d(((v)object0), ((v)object1));
                return H.a;
            }
            case 1: {
                q.g(((x)object0), "p0");
                q.g(((x)object1), "p1");
                ((t)this.receiver).getClass();
                k.b.getClass();
                return !j.b.b(((x)object0), ((x)object1)) || j.b.b(((x)object1), ((x)object0)) ? false : true;
            }
            case 2: {
                q.g(((x)object0), "p0");
                q.g(((x)object1), "p1");
                return Boolean.valueOf(((l)this.receiver).a(((x)object0), ((x)object1)));
            }
            case 3: {
                return Boolean.valueOf(Q0.u.g(((Q0.u)this.receiver), ((d)object0), ((c)object1)));
            }
            case 4: {
                U u0 = (U)this.receiver;
                if(u0.isAttached()) {
                    boolean z = ((w0.t)(((w0.s)object1))).b();
                    if(z != ((w0.t)(((w0.s)object0))).b()) {
                        we.k k0 = u0.d;
                        if(k0 != null) {
                            k0.invoke(Boolean.valueOf(z));
                        }
                        if(z) {
                            BuildersKt__Builders_commonKt.launch$default(u0.getCoroutineScope(), null, null, new T(u0, null), 3, null);
                            kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                            f.r(u0, new g(24, h0, u0));
                            E e0 = (E)h0.a;
                            if(e0 == null) {
                                e0 = null;
                            }
                            else {
                                e0.a();
                            }
                            u0.f = e0;
                            if(u0.g != null && u0.g.h()) {
                                V v0 = u0.q0();
                                if(v0 != null) {
                                    v0.m0(u0.g);
                                }
                            }
                        }
                        else {
                            E e1 = u0.f;
                            if(e1 != null) {
                                e1.b();
                            }
                            u0.f = null;
                            V v1 = u0.q0();
                            if(v1 != null) {
                                v1.m0(null);
                            }
                        }
                        f.v(u0).E();
                        K.l l0 = u0.c;
                        if(l0 != null) {
                            if(z) {
                                K.f f0 = u0.e;
                                if(f0 != null) {
                                    u0.p0(l0, new K.g(f0));
                                    u0.e = null;
                                }
                                K.f f1 = new K.f();  // 初始化器: Ljava/lang/Object;-><init>()V
                                u0.p0(l0, f1);
                                u0.e = f1;
                                return H.a;
                            }
                            K.f f2 = u0.e;
                            if(f2 != null) {
                                u0.p0(l0, new K.g(f2));
                                u0.e = null;
                            }
                        }
                    }
                }
                return H.a;
            }
            default: {
                return MelonAppBase.access$handleLifecycleEvent(((MelonAppBase)this.receiver), ((h)object0), ((Continuation)object1));
            }
        }
    }
}

