package Rc;

import Pc.e;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import ob.z;
import oc.Q;
import oe.i;
import we.n;

public final class s0 extends i implements n {
    public int B;
    public final e D;
    public final t0 E;
    public t0 r;
    public int w;

    public s0(e e0, t0 t00, Continuation continuation0) {
        this.D = e0;
        this.E = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s0(this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v1;
        t0 t00 = this.E;
        z z0 = t00.d;
        a a0 = a.a;
        H h0 = H.a;
        e e0 = this.D;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                int v = ((W)e0).a;
                Q q0 = t00.j;
                if(q0 == null) {
                    q.m("playlistState");
                    throw null;
                }
                if(v == q0.b()) {
                    if(!t00.n) {
                        z0.v(v);
                    }
                    return h0;
                }
                PlaylistId playlistId0 = t00.d();
                if(playlistId0 != null) {
                    this.r = t00;
                    v1 = 0;
                    this.w = 0;
                    this.B = 1;
                    object0 = z0.p(playlistId0, v, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_31;
                }
                break;
            }
            case 1: {
                int v2 = this.w;
                t0 t01 = this.r;
                d5.n.D(object0);
                v1 = v2;
                t00 = t01;
            label_31:
                if(((Boolean)object0).booleanValue()) {
                    this.r = null;
                    this.w = v1;
                    this.B = 2;
                    if(t00.d.b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                        return a0;
                    }
                }
                break;
            }
            case 2: {
                PlaylistId playlistId1 = (PlaylistId)this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        z0.v(((W)e0).a);
        return h0;
    }
}

