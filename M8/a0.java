package m8;

import M6.B;
import android.app.Activity;
import android.content.Context;
import com.google.firebase.b;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.SetRepeatResult;
import com.melon.playlist.interfaces.SetShuffleResult.Success;
import com.melon.playlist.interfaces.SetShuffleResult;
import ie.H;
import k8.o;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import ob.z;
import oc.M;
import oe.i;
import qd.V;
import qd.W;
import we.n;

public final class a0 extends i implements n {
    public V B;
    public String D;
    public int E;
    public int G;
    public final Activity I;
    public final String M;
    public final String N;
    public final String S;
    public z r;
    public s2 w;

    public a0(Activity activity0, String s, String s1, String s2, Continuation continuation0) {
        this.I = activity0;
        this.M = s;
        this.N = s1;
        this.S = s2;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a0(this.I, this.M, this.N, this.S, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        M m0;
        V v1;
        V v3;
        String s1;
        z z0;
        s2 s20;
        z z1;
        s2 s21;
        s2 s23;
        z z2;
        a a0 = a.a;
        int v = 0;
        switch(this.G) {
            case 0: {
                d5.n.D(object0);
                q.g(this.I, "context");
                Context context0 = this.I.getApplicationContext();
                q.d(context0);
                z2 = ((o)(((Ma.o)b.B(context0, Ma.o.class)))).k();
                s23 = B.a.G(this.I);
                Context context1 = this.I.getApplicationContext();
                q.d(context1);
                v3 = ((o)(((Ma.n)b.B(context1, Ma.n.class)))).s();
                if("Y".equals(this.M)) {
                    this.r = z2;
                    this.w = s23;
                    this.B = v3;
                    this.G = 1;
                    if(z2.b(0x7F13090F, this) != a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                        goto label_42;
                    }
                    return a0;
                }
            label_42:
                String s2 = this.N;
                if(s2 != null) {
                    if(s2.equals("TOGGLE")) {
                        this.r = z2;
                        this.w = s23;
                        this.B = v3;
                        this.D = null;
                        this.E = 0;
                        this.G = 2;
                        Object object1 = z2.F(this);
                        if(object1 == a0) {
                            return a0;
                        }
                        s21 = s23;
                        object0 = object1;
                        z1 = z2;
                    label_56:
                        if(((SetShuffleResult)object0) instanceof Success) {
                            ((W)v3).d(((Success)(((SetShuffleResult)object0))));
                        }
                        else {
                            LogU.Companion.d("Deeplink-Play", "SetShuffle failed");
                        }
                        s23 = s21;
                        z2 = z1;
                    }
                    else {
                        boolean z3 = s2.equals("Y");
                        s23 = (d3)s23;
                        ((d3)s23).z(z3);
                    }
                }
                break;
            }
            case 1: {
                v3 = this.B;
                s2 s22 = this.w;
                z2 = this.r;
                d5.n.D(object0);
                s23 = s22;
                goto label_42;
            }
            case 2: {
                v3 = this.B;
                s21 = this.w;
                z1 = this.r;
                d5.n.D(object0);
                goto label_56;
            }
            case 3: {
                v = this.E;
                String s = this.D;
                V v2 = this.B;
                s20 = this.w;
                z0 = this.r;
                d5.n.D(object0);
                s1 = s;
                v3 = v2;
                goto label_78;
            }
            case 4: {
                v1 = this.B;
                d5.n.D(object0);
                goto label_88;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        z0 = z2;
        s1 = this.S;
        if(s1 != null) {
            B b0 = ((d3)s23).h();
            this.r = z0;
            this.w = (d3)s23;
            this.B = v3;
            this.D = s1;
            this.E = 0;
            this.G = 3;
            if(ListenableFutureKt.await(b0, this) != a0) {
                s20 = (d3)s23;
            label_78:
                if(!q.b(s1, "TOGGLE")) {
                    goto label_93;
                }
                this.r = null;
                this.w = null;
                this.B = v3;
                this.D = null;
                this.E = v;
                this.G = 4;
                object0 = z0.E(this);
                if(object0 != a0) {
                    v1 = v3;
                label_88:
                    if(((SetRepeatResult)object0) instanceof com.melon.playlist.interfaces.SetRepeatResult.Success) {
                        ((W)v1).c(((com.melon.playlist.interfaces.SetRepeatResult.Success)(((SetRepeatResult)object0))));
                        return H.a;
                    }
                    LogU.Companion.d("Deeplink-Play", "SetRepeat failed");
                    return H.a;
                label_93:
                    if("ALL".equals(s1)) {
                        m0 = M.b;
                    }
                    else {
                        m0 = "ONE".equals(s1) ? M.c : M.a;
                    }
                    ((d3)s20).y(m0);
                    return H.a;
                }
            }
            return a0;
        }
        return H.a;
    }
}

