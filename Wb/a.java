package wb;

import Ea.e;
import androidx.media3.session.legacy.V;
import com.iloen.melon.constants.CType;
import com.iloen.melon.net.v4x.response.ContentsInfoListRes;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.SongInfoRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StringUtils;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import mb.k;
import oe.i;
import va.e0;
import we.n;

public final class a extends i implements n {
    public SongInfoBase B;
    public int D;
    public Object E;
    public final List G;
    public final CType I;
    public final V M;
    public final Playable N;
    public Object r;
    public Serializable w;

    public a(List list0, CType cType0, V v0, Playable playable0, Continuation continuation0) {
        this.G = list0;
        this.I = cType0;
        this.M = v0;
        this.N = playable0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new a(this.G, this.I, this.M, this.N, continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ArrayList arrayList0;
        ContentsInfoListRes contentsInfoListRes0;
        Playable playable1;
        SongInfoBase songInfoBase0;
        SongInfoRes songInfoRes0;
        e e1;
        String s;
        V v0 = this.M;
        k k0 = (k)v0.c;
        e e0 = (e)v0.a;
        FlowCollector flowCollector0 = (FlowCollector)this.E;
        ne.a a0 = ne.a.a;
        Playable playable0 = this.N;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                List list0 = this.G;
                if(list0.isEmpty()) {
                    b b1 = new b(new Exception("empty song ids"));
                    this.E = null;
                    this.D = 10;
                    if(flowCollector0.emit(b1, this) == a0) {
                        return a0;
                    }
                }
                else {
                    CType cType0 = this.I;
                    if(!cType0.equals(CType.SONG) || list0.size() != 1) {
                        androidx.lifecycle.b b0 = (androidx.lifecycle.b)v0.b;
                        String s1 = cType0.getValue();
                        q.f(s1, "getValue(...)");
                        String s2 = StringUtils.parseToCsv(list0, false, false);
                        this.E = flowCollector0;
                        this.D = 6;
                        object0 = b0.v(s1, s2, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_88;
                    }
                    else {
                        s = (String)p.k0(list0);
                        this.E = flowCollector0;
                        this.r = e0;
                        this.w = s;
                        this.D = 1;
                        object0 = ((e0)k0).o(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        e1 = e0;
                        goto label_39;
                    }
                }
                return H.a;
            }
            case 1: {
                s = (String)this.w;
                e1 = (e)this.r;
                d5.n.D(object0);
            label_39:
                boolean z = !((Boolean)object0).booleanValue();
                q.d("");
                this.E = flowCollector0;
                this.r = null;
                this.w = null;
                this.D = 2;
                object0 = e1.a(s, "", this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_49;
            }
            case 2: {
                d5.n.D(object0);
            label_49:
                songInfoRes0 = (SongInfoRes)object0;
                wb.e e2 = new wb.e(songInfoRes0.notification);
                this.E = flowCollector0;
                this.r = songInfoRes0;
                this.D = 3;
                if(flowCollector0.emit(e2, this) == a0) {
                    return a0;
                }
                goto label_58;
            }
            case 3: {
                songInfoRes0 = (SongInfoRes)this.r;
                d5.n.D(object0);
            label_58:
                RESPONSE songInfoRes$RESPONSE0 = songInfoRes0.response;
                if(songInfoRes$RESPONSE0 != null) {
                    songInfoBase0 = songInfoRes$RESPONSE0.songInfo;
                    if(songInfoBase0 != null) {
                        List list1 = e.k.z(songInfoBase0);
                        this.E = flowCollector0;
                        this.r = null;
                        this.w = playable0;
                        this.B = songInfoBase0;
                        this.D = 4;
                        if(e0.d(list1, this) == a0) {
                            return a0;
                        }
                        playable1 = playable0;
                        goto label_76;
                    }
                }
                throw new Exception("Failed to get song info");
            }
            case 4: {
                songInfoBase0 = this.B;
                playable1 = (Playable)this.w;
                SongInfoRes songInfoRes1 = (SongInfoRes)this.r;
                d5.n.D(object0);
            label_76:
                playable1.updateFrom(songInfoBase0);
                c c0 = new c(playable0);
                this.E = null;
                this.r = null;
                this.w = null;
                this.B = null;
                this.D = 5;
                return flowCollector0.emit(c0, this) == a0 ? a0 : H.a;
            }
            case 5: {
                SongInfoRes songInfoRes2 = (SongInfoRes)this.r;
                break;
            }
            case 6: {
                d5.n.D(object0);
            label_88:
                contentsInfoListRes0 = (ContentsInfoListRes)object0;
                wb.e e3 = new wb.e(contentsInfoListRes0.notification);
                this.E = flowCollector0;
                this.r = contentsInfoListRes0;
                this.D = 7;
                if(flowCollector0.emit(e3, this) == a0) {
                    return a0;
                }
                goto label_97;
            }
            case 7: {
                contentsInfoListRes0 = (ContentsInfoListRes)this.r;
                d5.n.D(object0);
            label_97:
                arrayList0 = contentsInfoListRes0.response == null ? null : contentsInfoListRes0.response.contentsList;
                if(arrayList0 == null || arrayList0.isEmpty()) {
                    throw new Exception("Failed to get songs info");
                }
                this.E = flowCollector0;
                this.r = null;
                this.w = arrayList0;
                this.D = 8;
                if(e0.d(arrayList0, this) == a0) {
                    return a0;
                }
                goto label_109;
            }
            case 8: {
                arrayList0 = (ArrayList)this.w;
                ContentsInfoListRes contentsInfoListRes1 = (ContentsInfoListRes)this.r;
                d5.n.D(object0);
            label_109:
                d d0 = new d(arrayList0);
                this.E = null;
                this.r = null;
                this.w = null;
                this.D = 9;
                return flowCollector0.emit(d0, this) == a0 ? a0 : H.a;
            }
            case 9: {
                ArrayList arrayList1 = (ArrayList)this.w;
                ContentsInfoListRes contentsInfoListRes2 = (ContentsInfoListRes)this.r;
                break;
            }
            case 10: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(object0);
        return H.a;
    }
}

