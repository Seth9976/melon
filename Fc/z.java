package Fc;

import M6.B;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.ui.U0;
import d5.n;
import e1.b;
import ie.H;
import kc.K2;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.Q;
import oe.i;
import we.p;

public final class z extends i implements p {
    public Q B;
    public boolean D;
    public boolean E;
    public final D G;
    public String r;
    public int w;

    public z(D d0, Continuation continuation0) {
        this.G = d0;
        super(4, continuation0);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        z z0 = new z(this.G, ((Continuation)object3));
        z0.B = (Q)object0;
        z0.D = ((Boolean)object1).booleanValue();
        z0.E = ((Boolean)object2).booleanValue();
        return z0.invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object2;
        String s;
        Object object1;
        D d0 = this.G;
        s2 s20 = d0.c;
        Q q0 = this.B;
        boolean z = this.D;
        boolean z1 = this.E;
        a a0 = a.a;
        Integer integer0 = null;
        boolean z2 = true;
        switch(this.w) {
            case 0: {
                n.D(object0);
                if(b.D(q0)) {
                    return new v(new U0(null, null, 0x1F));
                }
                K2 k20 = new K2(((d3)s20), null);
                B b0 = ListenableFutureKt.future$default(((d3)s20).b, null, null, k20, 3, null);
                this.B = q0;
                this.D = z;
                this.E = z1;
                this.w = 1;
                object1 = ListenableFutureKt.await(b0, this);
                if(object1 == a0) {
                    return a0;
                }
                goto label_24;
            }
            case 1: {
                n.D(object0);
                object1 = object0;
            label_24:
                int v = y.a[((PlaylistId)object1).ordinal()];
                if(v == 1 || v == 2) {
                    integer0 = new Integer(0x7F130A39);  // string:smart_playlist_song_title "재생목록"
                }
                else {
                    switch(v) {
                        case 3: {
                            integer0 = new Integer(0x7F130A17);  // string:smart_drawer_playlist_title "음악서랍"
                            break;
                        }
                        case 4: {
                            integer0 = new Integer((z1 ? 0x7F130A14 : 0x7F130A18));  // string:smart_dj_malrang_playlist_title "DJ말랑이"
                            break;
                        }
                        case 5: {
                            goto label_32;
                        }
                    }
                    goto label_35;
                label_32:
                    integer0 = new Integer(0x7F130CBC);  // string:text_station "스테이션"
                }
            label_35:
                s = integer0 == null ? "" : d0.a.a(((int)integer0));
                if(!z) {
                    return new w(q0.b(), s, q0.c(), false);
                }
                B b1 = ((d3)s20).h();
                this.B = q0;
                this.r = s;
                this.D = true;
                this.E = z1;
                this.w = 2;
                object2 = ListenableFutureKt.await(b1, this);
                if(object2 == a0) {
                    return a0;
                }
                goto label_50;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        s = this.r;
        n.D(object0);
        object2 = object0;
    label_50:
        if(!((PlaylistId)object2).isAudioType()) {
            z2 = false;
        }
        return new w(q0.b(), s, q0.c(), z2);
    }
}

