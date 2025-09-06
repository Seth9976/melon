package w8;

import M6.B;
import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.b0;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.interfaces.PlayableData;
import e1.b;
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

public final class y extends i implements n {
    public final Context B;
    public final b0 D;
    public final b0 E;
    public final b0 G;
    public final b0 I;
    public final b0 M;
    public final b0 N;
    public final z S;
    public final b0 T;
    public int r;
    public final s2 w;

    public y(s2 s20, Context context0, b0 b00, b0 b01, b0 b02, b0 b03, b0 b04, b0 b05, z z0, b0 b06, Continuation continuation0) {
        this.w = s20;
        this.B = context0;
        this.D = b00;
        this.E = b01;
        this.G = b02;
        this.I = b03;
        this.M = b04;
        this.N = b05;
        this.S = z0;
        this.T = b06;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y(this.w, this.B, this.D, this.E, this.G, this.I, this.M, this.N, this.S, this.T, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
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
        PlaylistId playlistId0 = ((oc.H)object0).getId();
        PlayableData playableData0 = b.z(((oc.H)object0).getState());
        Uri uri0 = null;
        this.D.setValue((playableData0 == null ? null : playableData0.a));
        String s = ((Playable)this.D.getValue()) == null ? null : "";
        String s1 = ((Playable)this.D.getValue()) == null ? null : "";
        if(s == null || s.length() == 0) {
            s = "곡 목록이 없습니다.";
            q.f("곡 목록이 없습니다.", "getString(...)");
        }
        else if(s1 != null && s1.length() != 0) {
            s = s + " - " + s1;
        }
        this.E.setValue(s);
        if(playableData0 != null) {
            uri0 = playableData0.m;
        }
        this.G.setValue(uri0);
        if(playlistId0 != PlaylistId.STATION) {
            z = false;
        }
        this.I.setValue(Boolean.valueOf(z));
        Boolean boolean0 = Boolean.valueOf(e1.n.i(playlistId0));
        this.M.setValue(boolean0);
        Boolean boolean1 = Boolean.valueOf(e1.n.j(playlistId0));
        this.N.setValue(boolean1);
        Boolean boolean2 = Boolean.valueOf(z.a(((oc.H)object0).getId()));
        this.T.setValue(boolean2);
        return H.a;
    }
}

