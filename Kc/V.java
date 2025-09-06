package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import ie.H;
import k9.j;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class v extends i implements n {
    public int B;
    public Object D;
    public final b E;
    public b r;
    public int w;

    public v(b b0, Continuation continuation0) {
        this.E = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new v(this.E, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.D;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                b b0 = this.E;
                try {
                    if(j.c()) {
                        j.e();
                        this.D = null;
                        this.r = b0;
                        this.w = 0;
                        this.B = 1;
                        if(b0.a0(PlaylistId.SMART, false, this) == a0) {
                            return a0;
                        }
                        b b1 = b0;
                        int v = 0;
                        goto label_22;
                    label_19:
                        v = this.w;
                        b1 = this.r;
                        d5.n.D(object0);
                    label_22:
                        this.D = null;
                        this.r = null;
                        this.w = v;
                        this.B = 2;
                        if(b1.a0(PlaylistId.MUSIC, false, this) == a0) {
                            return a0;
                        }
                    }
                }
                catch(Throwable throwable0) {
                    d5.n.t(throwable0);
                }
                break;
            }
            case 1: {
                goto label_19;
            }
            case 2: {
                CoroutineScope coroutineScope1 = (CoroutineScope)this.r;
                try {
                    d5.n.D(object0);
                    return H.a;
                }
                catch(Throwable throwable0) {
                    d5.n.t(throwable0);
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

