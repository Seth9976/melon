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
import oe.i;
import we.n;

public final class z extends i implements n {
    public final s2 B;
    public final Context D;
    public final ob.z E;
    public final b0 G;
    public final b0 I;
    public final b0 M;
    public final b0 N;
    public final b0 S;
    public final b0 T;
    public final b0 V;
    public final b0 W;
    public b0 r;
    public int w;

    public z(s2 s20, Context context0, ob.z z0, b0 b00, b0 b01, b0 b02, b0 b03, b0 b04, b0 b05, b0 b06, b0 b07, Continuation continuation0) {
        this.B = s20;
        this.D = context0;
        this.E = z0;
        this.G = b00;
        this.I = b01;
        this.M = b02;
        this.N = b03;
        this.S = b04;
        this.T = b05;
        this.V = b06;
        this.W = b07;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z(this.B, this.D, this.E, this.G, this.I, this.M, this.N, this.S, this.T, this.V, this.W, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        b0 b01;
        a a0 = a.a;
        b0 b00 = this.G;
        boolean z = true;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)this.B).r();
                this.r = b00;
                this.w = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                b01 = b00;
                break;
            }
            case 1: {
                b01 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        b01.setValue(((oc.H)object0));
        oc.H h0 = (oc.H)b00.getValue();
        Uri uri0 = null;
        PlaylistId playlistId0 = h0 == null ? null : h0.getId();
        oc.H h1 = (oc.H)b00.getValue();
        PlayableData playableData0 = h1 == null ? null : b.z(h1.getState());
        this.I.setValue((playableData0 == null ? null : playableData0.a));
        String s = ((Playable)this.I.getValue()) == null ? null : "";
        String s1 = ((Playable)this.I.getValue()) == null ? null : "";
        if(s == null || s.length() == 0) {
            s = "곡 목록이 없습니다.";
            q.f("곡 목록이 없습니다.", "getString(...)");
        }
        else if(s1 != null && s1.length() != 0) {
            s = s + " - " + s1;
        }
        this.M.setValue(s);
        if(playableData0 != null) {
            uri0 = playableData0.m;
        }
        this.N.setValue(uri0);
        boolean z1 = false;
        if(playlistId0 != PlaylistId.STATION) {
            z = false;
        }
        this.S.setValue(Boolean.valueOf(z));
        boolean z2 = playlistId0 == null ? false : e1.n.i(playlistId0);
        this.T.setValue(Boolean.valueOf(z2));
        if(playlistId0 != null) {
            z1 = e1.n.j(playlistId0);
        }
        this.V.setValue(Boolean.valueOf(z1));
        Boolean boolean0 = Boolean.valueOf(ob.z.a(playlistId0));
        this.W.setValue(boolean0);
        return H.a;
    }
}

