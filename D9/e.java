package d9;

import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class e extends i implements n {
    public final h r;
    public final long w;

    public e(h h0, long v, Continuation continuation0) {
        this.r = h0;
        this.w = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        h h0 = this.r;
        if(h0.r >= h0.p) {
            try {
                int v = h0.q;
                int v1 = h0.l.size();
            label_5:
                while(v < v1) {
                    h0.o = ((LyricsInfo)h0.l.get(v)).a;
                    long v2 = h0.o;
                    if(this.w < v2 && h0.p + 1L <= this.w) {
                        h0.p = v2;
                        h0.q = v;
                        h0.h.postValue(new Integer(v - 1));
                        return H.a;
                    }
                    ++v;
                }
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                LogU.error$default(h0.b, "findPosition(), songName = " + (h0.m == null ? null : "") + ", " + indexOutOfBoundsException0, null, false, 6, null);
                if(true) {
                    return H.a;
                }
                goto label_5;
            }
        }
        return H.a;
    }
}

