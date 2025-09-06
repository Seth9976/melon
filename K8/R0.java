package k8;

import android.content.Intent;
import com.iloen.melon.MusicBrowserActivity;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.k;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class r0 extends i implements n {
    public final Intent B;
    public int r;
    public final MusicBrowserActivity w;

    public r0(MusicBrowserActivity musicBrowserActivity0, Intent intent0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = intent0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        MusicBrowserActivity musicBrowserActivity0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                k k0 = musicBrowserActivity0.getLoginUseCase();
                this.r = 1;
                if(((e0)k0).o(this) == a0) {
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
        this.r = 2;
        return musicBrowserActivity0.handleIntent(this.B, this) == a0 ? a0 : H.a;
    }
}

