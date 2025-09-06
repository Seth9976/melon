package w8;

import M6.B;
import android.content.Context;
import androidx.compose.runtime.b0;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import e.k;
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

public final class p extends i implements n {
    public final Context B;
    public final z D;
    public final b0 E;
    public final b0 G;
    public final b0 I;
    public final b0 M;
    public int r;
    public final s2 w;

    public p(s2 s20, Context context0, z z0, b0 b00, b0 b01, b0 b02, b0 b03, Continuation continuation0) {
        this.w = s20;
        this.B = context0;
        this.D = z0;
        this.E = b00;
        this.G = b01;
        this.I = b02;
        this.M = b03;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p(this.w, this.B, this.D, this.E, this.G, this.I, this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        boolean z = true;
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
        Playable playable0 = k.p(((oc.H)object0));
        String s = null;
        String s1 = playable0 == null ? null : "";
        if(playable0 != null) {
            s = "";
        }
        if(((oc.H)object0).getId() != PlaylistId.STATION) {
            z = false;
        }
        this.E.setValue(Boolean.valueOf(z));
        if((s1 == null || s1.length() == 0) && (s == null || s.length() == 0)) {
            s1 = "곡 목록이 없습니다.";
            q.d("곡 목록이 없습니다.");
        }
        else if(s1 == null) {
            s1 = "";
        }
        this.G.setValue(s1);
        if(s == null) {
            s = "";
        }
        this.I.setValue(s);
        Boolean boolean0 = Boolean.valueOf(z.a(((oc.H)object0).getId()));
        this.M.setValue(boolean0);
        return H.a;
    }
}

