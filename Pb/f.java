package pb;

import Cb.j;
import Q1.c;
import android.content.Context;
import android.content.Intent;
import androidx.media3.session.legacy.V;
import bb.h;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MyMusicLikeInsertLikeRes;
import com.iloen.melon.net.v5x.response.MyMusicLikeDeleteLikeRes;
import com.iloen.melon.net.v5x.response.ResponseV5Res;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import ua.u;
import we.n;

public final class f extends i implements n {
    public int B;
    public Object D;
    public final boolean E;
    public final V G;
    public final String I;
    public final String M;
    public final String N;
    public final String S;
    public final PlaylistId T;
    public final Playable V;
    public ResponseV5Res r;
    public int w;

    public f(boolean z, V v0, String s, String s1, String s2, String s3, PlaylistId playlistId0, Playable playable0, Continuation continuation0) {
        this.E = z;
        this.G = v0;
        this.I = s;
        this.M = s1;
        this.N = s2;
        this.S = s3;
        this.T = playlistId0;
        this.V = playable0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f(this.E, this.G, this.I, this.M, this.N, this.S, this.T, this.V, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v1;
        ResponseV5Res responseV5Res0;
        String s3;
        V v0 = this.G;
        u u0 = (u)v0.b;
        FlowCollector flowCollector0 = (FlowCollector)this.D;
        a a0 = a.a;
        String s = this.I;
        String s1 = this.N;
        boolean z = this.E;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                String s2 = this.M;
                if(z) {
                    q.d(s2);
                    this.D = flowCollector0;
                    this.B = 1;
                    Object object1 = u0.o(s, s2, s1, this.S, "", this);
                    if(object1 != a0) {
                        responseV5Res0 = (ResponseV5Res)object1;
                        goto label_39;
                    }
                }
                else {
                    q.d(s2);
                    this.D = flowCollector0;
                    this.B = 2;
                    Object object2 = u0.b(s, s2, s1, this.S, this);
                    if(object2 != a0) {
                        responseV5Res0 = (ResponseV5Res)object2;
                    label_39:
                        h h0 = new h((responseV5Res0 == null ? null : responseV5Res0.notification), true);
                        this.D = flowCollector0;
                        this.r = responseV5Res0;
                        this.B = 3;
                        if(flowCollector0.emit(h0, this) != a0) {
                        label_44:
                            if(responseV5Res0 == null || !j.d(responseV5Res0)) {
                                return H.a;
                            }
                            if(responseV5Res0 instanceof MyMusicLikeInsertLikeRes) {
                                s3 = ((MyMusicLikeInsertLikeRes)responseV5Res0).response.summcnt;
                            }
                            else {
                                s3 = responseV5Res0 instanceof MyMusicLikeDeleteLikeRes ? ((MyMusicLikeDeleteLikeRes)responseV5Res0).response.summcnt : "0";
                            }
                            v1 = ProtocolUtils.parseInt(s3, 0);
                            s2 s20 = (s2)v0.c;
                            e e0 = new e(v1, this.V, null, z);
                            ((d3)s20).C(this.T, "LikePlayableInPlaylistUseCase", false, false, e0);
                            bb.n n0 = new bb.n(v1, s1, s, z);
                            this.D = flowCollector0;
                            this.r = null;
                            this.w = v1;
                            this.B = 4;
                            if(flowCollector0.emit(n0, this) != a0) {
                            label_59:
                                if(!z) {
                                    goto label_65;
                                }
                                this.D = null;
                                this.r = null;
                                this.w = v1;
                                this.B = 5;
                                if(flowCollector0.emit(bb.j.a, this) != a0) {
                                label_65:
                                    Context context0 = (Context)v0.a;
                                    Intent intent0 = new Intent();
                                    c.Y(intent0, "android.appwidget.action.APPWIDGET_UPDATE", false);
                                    intent0.putExtra("com.iloen.melon.intent.action", "com.iloen.melon.response_like_content");
                                    context0.sendBroadcast(intent0);
                                    return H.a;
                                }
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                responseV5Res0 = (ResponseV5Res)object0;
                goto label_39;
            }
            case 2: {
                d5.n.D(object0);
                responseV5Res0 = (ResponseV5Res)object0;
                goto label_39;
            }
            case 3: {
                responseV5Res0 = this.r;
                d5.n.D(object0);
                goto label_44;
            }
            case 4: {
                v1 = this.w;
                d5.n.D(object0);
                goto label_59;
            }
            case 5: {
                d5.n.D(object0);
                goto label_65;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

