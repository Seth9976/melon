package w8;

import M6.B;
import android.content.Context;
import android.net.Uri;
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
import oc.Q;
import oe.i;
import we.n;

public final class b0 extends i implements n {
    public final s2 B;
    public final Context D;
    public final z E;
    public final androidx.compose.runtime.b0 G;
    public final androidx.compose.runtime.b0 I;
    public final androidx.compose.runtime.b0 M;
    public final androidx.compose.runtime.b0 N;
    public final androidx.compose.runtime.b0 S;
    public final androidx.compose.runtime.b0 T;
    public final androidx.compose.runtime.b0 V;
    public final androidx.compose.runtime.b0 W;
    public final androidx.compose.runtime.b0 X;
    public final androidx.compose.runtime.b0 Y;
    public final androidx.compose.runtime.b0 Z;
    public androidx.compose.runtime.b0 r;
    public int w;

    public b0(s2 s20, Context context0, z z0, androidx.compose.runtime.b0 b00, androidx.compose.runtime.b0 b01, androidx.compose.runtime.b0 b02, androidx.compose.runtime.b0 b03, androidx.compose.runtime.b0 b04, androidx.compose.runtime.b0 b05, androidx.compose.runtime.b0 b06, androidx.compose.runtime.b0 b07, androidx.compose.runtime.b0 b08, androidx.compose.runtime.b0 b09, androidx.compose.runtime.b0 b010, Continuation continuation0) {
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
        this.X = b08;
        this.Y = b09;
        this.Z = b010;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b0(this.B, this.D, this.E, this.G, this.I, this.M, this.N, this.S, this.T, this.V, this.W, this.X, this.Y, this.Z, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PlayableData playableData0;
        androidx.compose.runtime.b0 b02;
        androidx.compose.runtime.b0 b01;
        a a0 = a.a;
        s2 s20 = this.B;
        androidx.compose.runtime.b0 b00 = this.I;
        boolean z = true;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)s20).h();
                b01 = this.G;
                this.r = b01;
                this.w = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_16;
            }
            case 1: {
                b01 = this.r;
                d5.n.D(object0);
            label_16:
                b01.setValue(Boolean.valueOf(((PlaylistId)object0).isAudioType()));
                B b1 = ((d3)s20).r();
                this.r = b00;
                this.w = 2;
                object0 = ListenableFutureKt.await(b1, this);
                if(object0 == a0) {
                    return a0;
                }
                b02 = b00;
                break;
            }
            case 2: {
                b02 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        b02.setValue(((oc.H)object0));
        oc.H h0 = (oc.H)b00.getValue();
        Uri uri0 = null;
        PlaylistId playlistId0 = h0 == null ? null : h0.getId();
        oc.H h1 = (oc.H)b00.getValue();
        if(h1 == null) {
            playableData0 = null;
        }
        else {
            Q q0 = h1.getState();
            playableData0 = q0 == null ? null : b.z(q0);
        }
        androidx.compose.runtime.b0 b03 = this.M;
        b03.setValue((playableData0 == null ? null : playableData0.a));
        if(playableData0 != null) {
            uri0 = playableData0.m;
        }
        this.N.setValue(uri0);
        boolean z1 = ((Playable)b03.getValue()) == null;
        boolean z2 = ((Playable)b03.getValue()) == null;
        this.S.setValue(Boolean.TRUE);
        q.f("곡 목록이 없습니다.", "getString(...)");
        this.T.setValue("곡 목록이 없습니다.");
        this.V.setValue("");
        boolean z3 = (playlistId0 == null ? false : e1.n.j(playlistId0)) && !((Boolean)this.S.getValue()).booleanValue();
        this.W.setValue(Boolean.valueOf(z3));
        boolean z4 = (playlistId0 == null ? false : e1.n.i(playlistId0)) && !((Boolean)this.S.getValue()).booleanValue();
        this.X.setValue(Boolean.valueOf(z4));
        this.Y.setValue(Boolean.valueOf(playlistId0 == PlaylistId.STATION));
        if(playlistId0 != PlaylistId.MUSIC_WAVE) {
            z = false;
        }
        this.Z.setValue(Boolean.valueOf(z));
        return H.a;
    }
}

