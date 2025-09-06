package id;

import Cb.j;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.SearchSettingSongWithPianoforteRes.RESPONSE;
import com.iloen.melon.net.v4x.response.SearchSettingSongWithPianoforteRes;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import ie.H;
import java.io.Serializable;
import java.net.URL;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import ob.z;
import oe.i;
import we.n;

public final class x extends i implements n {
    public final hd.i B;
    public final f D;
    public int r;
    public final A w;

    public x(A a0, hd.i i0, f f0, Continuation continuation0) {
        this.w = a0;
        this.B = i0;
        this.D = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        URL uRL0;
        Serializable serializable0;
        a a0 = a.a;
        A a1 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                serializable0 = a1.a.k(this);
                if(serializable0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                serializable0 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        a1.c = false;
        H h0 = H.a;
        hd.i i0 = this.B;
        if(((SearchSettingSongWithPianoforteRes)serializable0) == null) {
            LogU.debug$default(a1.b, "requestSearchMusic error : network, timeout etc...", null, false, 6, null);
            i0.invoke("Network Error");
            return h0;
        }
        if(j.d(((SearchSettingSongWithPianoforteRes)serializable0))) {
            RESPONSE searchSettingSongWithPianoforteRes$RESPONSE0 = ((SearchSettingSongWithPianoforteRes)serializable0).response;
            if(Cb.i.l(searchSettingSongWithPianoforteRes$RESPONSE0)) {
                String s = searchSettingSongWithPianoforteRes$RESPONSE0.kakaoServerUrl;
                q.d(s);
                if(s.length() == 0) {
                    LogU.debug$default(a1.b, "requestSearchMusic error : kakao server url is invalid", null, false, 6, null);
                    i0.invoke("invalid Kakao server URL");
                    return h0;
                }
                try {
                    uRL0 = new URL(s);
                }
                catch(Exception exception0) {
                    LogU.debug$default(a1.b, "requestSearchMusic error : " + exception0, null, false, 6, null);
                    uRL0 = null;
                }
                if(uRL0 == null) {
                    i0.invoke("a malformed Kakao server URL");
                    return h0;
                }
                f f0 = this.D;
                if(Cb.i.l(f0)) {
                    int v = ProtocolUtils.parseInt(searchSettingSongWithPianoforteRes$RESPONSE0.kakaoServerTryCnt, 1);
                    if(f0 != null) {
                        z z0 = f0.b;
                        if(z0.n()) {
                            z0.s();
                        }
                        F f1 = f0.f;
                        if(f1 == null) {
                            f0.j.removeCallbacksAndMessages(null);
                            LogU.Companion.d("MusicSearchController", "startSearchMusic() mRecordTask == null");
                            f0.b(uRL0, 2001, v, 0L);
                        }
                        else {
                            f1.cancel();
                            LogU.Companion.d("MusicSearchController", "startSearchMusic() mRecordTask != null");
                            f0.b(uRL0, 2001, v, 100L);
                        }
                    }
                    g.d0("M1", a1.getMenuId(), "");
                }
                return h0;
            }
            LogU.debug$default(a1.b, "requestSearchMusic() error : response is null", null, false, 6, null);
            i0.invoke("that the server response is null");
            return h0;
        }
        LogU.debug$default(a1.b, "requestSearchMusic() error : notification", null, false, 6, null);
        i0.invoke("that the server notification has failed");
        return h0;
    }
}

