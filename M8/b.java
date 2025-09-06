package m8;

import M6.B;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.Navigator;
import ie.H;
import ie.r;
import kc.D2;
import kc.Y2;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import mb.k;
import ne.a;
import oe.i;
import r8.f;
import va.e0;
import va.o;
import we.n;

public final class b extends i implements n {
    public int r;
    public final c w;

    public b(c c0, Continuation continuation0) {
        this.w = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        r r0 = (r)this.w.c;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                k k0 = o.a();
                this.r = 1;
                object0 = ((e0)k0).o(this);
                if(object0 != a0) {
                label_17:
                    if(!((Boolean)object0).booleanValue()) {
                        Navigator.openLoginView(f.f);
                        return H.a;
                    }
                    d3 d30 = (d3)(((s2)r0.getValue()));
                    D2 d20 = new D2(d30, null);
                    B b0 = ListenableFutureKt.future$default(d30.b, null, null, d20, 3, null);
                    this.r = 2;
                    object0 = ListenableFutureKt.await(b0, this);
                    if(object0 != a0) {
                    label_26:
                        if(((Boolean)object0).booleanValue()) {
                            B b1 = ((d3)(((s2)r0.getValue()))).a(PlaylistId.SMART);
                            this.r = 3;
                            if(ListenableFutureKt.await(b1, this) != a0) {
                                Navigator.INSTANCE.openNowPlayList();
                                return H.a;
                            }
                        }
                        else {
                            d3 d31 = (d3)(((s2)r0.getValue()));
                            Y2 y20 = new Y2(d31, true, true, null);
                            B b2 = ListenableFutureKt.future$default(d31.b, null, null, y20, 3, null);
                            this.r = 4;
                            if(ListenableFutureKt.await(b2, this) != a0) {
                                Navigator.INSTANCE.openNowPlayList();
                                return H.a;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                goto label_17;
            }
            case 2: {
                d5.n.D(object0);
                goto label_26;
            }
            case 3: {
                d5.n.D(object0);
                Navigator.INSTANCE.openNowPlayList();
                return H.a;
            }
            case 4: {
                d5.n.D(object0);
                Navigator.INSTANCE.openNowPlayList();
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

