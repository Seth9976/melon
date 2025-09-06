package v8;

import E9.w;
import com.iloen.melon.playback.playlist.db.d;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import u8.b;
import we.n;

public final class c extends i implements n {
    public int r;
    public final f w;

    public c(f f0, Continuation continuation0) {
        this.w = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        f f0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = f0.getCacheKey();
                q.g(s, "cacheKey");
                s8.a a1 = b.a();
                d d0 = new d(s, 24);
                w.N(a1.a, false, true, d0);
                this.r = 1;
                if(f0.clearSubCache(this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v8.b b0 = new v8.b(f0, null);
        this.r = 2;
        return BuildersKt.withContext(Dispatchers.getMain(), b0, this) == a0 ? a0 : H.a;
    }
}

