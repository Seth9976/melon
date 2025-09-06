package bb;

import Cb.j;
import H8.q;
import com.iloen.melon.custom.S0;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeInsertLikeRes;
import com.iloen.melon.net.v5x.response.MyMusicLikeDeleteLikeRes;
import com.iloen.melon.net.v5x.response.ResponseV5Res;
import eb.y;
import ie.H;
import je.x;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import pb.t;
import ua.u;
import we.n;

public final class d extends i implements n {
    public int B;
    public int D;
    public Object E;
    public final boolean G;
    public final q I;
    public final String M;
    public final String N;
    public final String S;
    public final String T;
    public final String V;
    public ResponseV5Res r;
    public AlbumSuggestedContentsRes w;

    public d(boolean z, q q0, String s, String s1, String s2, String s3, String s4, Continuation continuation0) {
        this.G = z;
        this.I = q0;
        this.M = s;
        this.N = s1;
        this.S = s2;
        this.T = s3;
        this.V = s4;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d(this.G, this.I, this.M, this.N, this.S, this.T, this.V, continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        AlbumSuggestedContentsRes albumSuggestedContentsRes0;
        Object object3;
        int v;
        String s3;
        ResponseV5Res responseV5Res0;
        FlowCollector flowCollector0 = (FlowCollector)this.E;
        a a0 = a.a;
        String s = this.S;
        String s1 = this.M;
        boolean z = this.G;
        q q0 = this.I;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                String s2 = this.N;
                if(z) {
                    this.E = flowCollector0;
                    this.D = 1;
                    Object object1 = ((u)q0.a).o(this.M, s2, this.S, this.T, this.V, this);
                    if(object1 == a0) {
                        return a0;
                    }
                    responseV5Res0 = (ResponseV5Res)object1;
                }
                else {
                    this.E = flowCollector0;
                    this.D = 2;
                    Object object2 = ((u)q0.a).b(this.M, s2, this.S, this.T, this);
                    if(object2 == a0) {
                        return a0;
                    }
                    responseV5Res0 = (ResponseV5Res)object2;
                }
                goto label_30;
            }
            case 1: {
                d5.n.D(object0);
                responseV5Res0 = (ResponseV5Res)object0;
                goto label_30;
            }
            case 2: {
                d5.n.D(object0);
                responseV5Res0 = (ResponseV5Res)object0;
            label_30:
                h h0 = new h((responseV5Res0 == null ? null : responseV5Res0.notification), true);
                this.E = flowCollector0;
                this.r = responseV5Res0;
                this.D = 3;
                if(flowCollector0.emit(h0, this) == a0) {
                    return a0;
                }
                goto label_38;
            }
            case 3: {
                responseV5Res0 = this.r;
                d5.n.D(object0);
            label_38:
                if(responseV5Res0 != null && j.d(responseV5Res0)) {
                    if(responseV5Res0 instanceof MyMusicLikeInsertLikeRes) {
                        s3 = ((MyMusicLikeInsertLikeRes)responseV5Res0).response.summcnt;
                    }
                    else {
                        s3 = responseV5Res0 instanceof MyMusicLikeDeleteLikeRes ? ((MyMusicLikeDeleteLikeRes)responseV5Res0).response.summcnt : "0";
                    }
                    v = ProtocolUtils.parseInt(s3, 0);
                    bb.n n0 = new bb.n(v, s, s1, z);
                    this.E = flowCollector0;
                    this.r = null;
                    this.B = v;
                    this.D = 4;
                    if(flowCollector0.emit(n0, this) == a0) {
                        return a0;
                    }
                    goto label_53;
                }
                break;
            }
            case 4: {
                v = this.B;
                d5.n.D(object0);
            label_53:
                if(z && !kotlin.jvm.internal.q.b(s1, "N10022")) {
                    this.E = flowCollector0;
                    this.r = null;
                    this.B = v;
                    this.D = 5;
                    if(flowCollector0.emit(bb.j.a, this) == a0) {
                        return a0;
                    }
                }
                goto label_62;
            }
            case 5: {
                v = this.B;
                d5.n.D(object0);
            label_62:
                if(z && kotlin.jvm.internal.q.b(s1, "N10002")) {
                    this.E = flowCollector0;
                    this.r = null;
                    this.B = v;
                    this.D = 6;
                    object3 = ((S0)q0.b).J(s, this);
                    if(object3 == a0) {
                        return a0;
                    }
                    goto label_73;
                }
                goto label_107;
            }
            case 6: {
                v = this.B;
                d5.n.D(object0);
                object3 = object0;
            label_73:
                albumSuggestedContentsRes0 = (AlbumSuggestedContentsRes)object3;
                h h1 = new h(albumSuggestedContentsRes0.notification, true);
                this.E = flowCollector0;
                this.r = null;
                this.w = albumSuggestedContentsRes0;
                this.B = v;
                this.D = 7;
                if(flowCollector0.emit(h1, this) == a0) {
                    return a0;
                }
                goto label_85;
            }
            case 7: {
                v = this.B;
                albumSuggestedContentsRes0 = this.w;
                d5.n.D(object0);
            label_85:
                if(j.d(albumSuggestedContentsRes0) && (albumSuggestedContentsRes0.response != null && (albumSuggestedContentsRes0.response.recmList != null && !albumSuggestedContentsRes0.response.recmList.isEmpty()))) {
                    RESPONSE albumSuggestedContentsRes$RESPONSE0 = albumSuggestedContentsRes0.response;
                    kotlin.jvm.internal.q.f(albumSuggestedContentsRes$RESPONSE0, "response");
                    bb.i i0 = new bb.i(albumSuggestedContentsRes$RESPONSE0);
                    this.E = null;
                    this.r = null;
                    this.w = null;
                    this.B = v;
                    this.D = 8;
                    if(flowCollector0.emit(i0, this) == a0) {
                        return a0;
                    }
                }
                goto label_98;
            }
            case 8: {
                v = this.B;
                d5.n.D(object0);
            label_98:
                this.E = null;
                this.r = null;
                this.w = null;
                this.B = v;
                this.D = 9;
                if(((y)q0.c).a("recmAlbumLikePopup", x.a, this) == a0) {
                    return a0;
                }
                goto label_107;
            }
            case 9: {
                v = this.B;
                d5.n.D(object0);
            label_107:
                this.E = null;
                this.r = null;
                this.w = null;
                this.B = v;
                this.D = 10;
                if(((t)q0.g).a(v, s, this, z) == a0) {
                    return a0;
                }
                break;
            }
            case 10: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

