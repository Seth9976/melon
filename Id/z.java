package id;

import Cb.j;
import com.iloen.melon.net.v4x.response.SearchInformSongWithPianoforteRes.RESPONSE;
import com.iloen.melon.net.v4x.response.SearchInformSongWithPianoforteRes;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class z extends i implements n {
    public final String B;
    public final B D;
    public final hd.i E;
    public int r;
    public final A w;

    public z(A a0, String s, B b0, hd.i i0, Continuation continuation0) {
        this.w = a0;
        this.B = s;
        this.D = b0;
        this.E = i0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        String s = this.B;
        A a1 = this.w;
        B b0 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = a1.a.j(s, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_12;
            }
            case 1: {
                d5.n.D(object0);
            label_12:
                if(((SearchInformSongWithPianoforteRes)object0) != null && j.d(((SearchInformSongWithPianoforteRes)object0))) {
                    b0.a = s.length() == 0 ? 0 : 2;
                    RESPONSE searchInformSongWithPianoforteRes$RESPONSE0 = ((SearchInformSongWithPianoforteRes)object0).response;
                    b0.b = searchInformSongWithPianoforteRes$RESPONSE0 == null ? null : searchInformSongWithPianoforteRes$RESPONSE0.songInfo;
                    y y0 = new y(a1, b0, null);
                    this.r = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), y0, this) == a0) {
                        return a0;
                    }
                    this.E.invoke(b0);
                    return H.a;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                this.E.invoke(b0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

