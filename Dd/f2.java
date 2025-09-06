package Dd;

import com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes;
import ea.d;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class f2 extends i implements n {
    public final g1 B;
    public int r;
    public final d w;

    public f2(d d0, g1 g10, Continuation continuation0) {
        this.w = d0;
        this.B = g10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f2(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = this.w.n(this);
                if(object0 == a0) {
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
        e2 e20 = new e2(((MyMusicPlaylistInformCntCheckRes)object0), this.B, null);
        this.r = 2;
        return BuildersKt.withContext(Dispatchers.getMain(), e20, this) == a0 ? a0 : H.a;
    }
}

