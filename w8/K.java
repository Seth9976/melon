package w8;

import M6.B;
import android.content.Context;
import androidx.compose.runtime.b0;
import com.iloen.melon.playback.Playable;
import ie.H;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import ob.z;
import oe.i;
import we.n;

public final class k extends i implements n {
    public final Context B;
    public final z D;
    public final b0 E;
    public final b0 G;
    public int r;
    public final s2 w;

    public k(s2 s20, Context context0, z z0, b0 b00, b0 b01, Continuation continuation0) {
        this.w = s20;
        this.B = context0;
        this.D = z0;
        this.E = b00;
        this.G = b01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)this.w).r();
                this.r = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Playable playable0 = e.k.p(((oc.H)object0));
        String s = null;
        String s1 = playable0 == null ? null : "";
        if(playable0 != null) {
            s = "";
        }
        if(s1 == null || s1.length() == 0) {
            s1 = "곡 목록이 없습니다.";
            q.f("곡 목록이 없습니다.", "getString(...)");
        }
        else if(s != null && s.length() != 0) {
            s1 = s1 + " - " + s;
        }
        this.E.setValue(s1);
        Boolean boolean0 = Boolean.valueOf(z.a(((oc.H)object0).getId()));
        this.G.setValue(boolean0);
        return H.a;
    }
}

