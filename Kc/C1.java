package kc;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventCurPlaylistViewFocus;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.melon.playlist.b;
import e1.u;
import ie.H;
import ie.o;
import ie.p;
import k8.t;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import nc.u0;
import ne.a;
import oe.i;
import sc.P0;
import va.e0;
import we.n;

public final class c1 extends i implements n {
    public final b B;
    public final P0 D;
    public Object r;
    public int w;

    public c1(b b0, P0 p00, Continuation continuation0) {
        this.B = b0;
        this.D = p00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c1(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object2;
        i3 i30;
        o o0;
        b b1;
        Object object1;
        a a0 = a.a;
        b b0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                String s = u.v(((e0)b0.g).j());
                try {
                    c c0 = b0.f;
                    if(b0.i.a().b || !c.b(((PlaylistId)b0.p.getValue()))) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    this.r = b0;
                    this.w = 1;
                    object1 = c0.a(s, this);
                    if(object1 == a0) {
                        return a0;
                    }
                    b1 = b0;
                    goto label_18;
                }
                catch(Throwable throwable0) {
                    goto label_26;
                }
            }
            case 1: {
                b1 = (b)this.r;
                try {
                    d5.n.D(object0);
                    object1 = ((p)object0).a;
                label_18:
                    d5.n.D(object1);
                    String s1 = ((i3)object1).a();
                    MelonAppBase.Companion.getClass();
                    if(q.b(s1, DeviceIdentifier.id(t.a().getDeviceData().a)) || b1.i.a().b) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    o0 = (i3)object1;
                }
                catch(Throwable throwable0) {
                label_26:
                    o0 = d5.n.t(throwable0);
                }
                if(o0 instanceof o) {
                    o0 = null;
                }
                i30 = (i3)o0;
                if(i30 instanceof h3) {
                    this.r = null;
                    this.w = 2;
                    if(this.D.V(((h3)i30).b, ((h3)i30).c, this) == a0) {
                        return a0;
                    }
                    goto label_43;
                }
                if(i30 instanceof g3) {
                    this.r = i30;
                    this.w = 4;
                    object0 = b0.b.b(false, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_53;
                }
                return H.a;
            }
            case 2: {
                i3 i31 = (i3)this.r;
                d5.n.D(object0);
            label_43:
                this.r = null;
                this.w = 3;
                if(b0.l(PlaylistId.SMART, this) == a0) {
                    return a0;
                }
                EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                return H.a;
            }
            case 3: {
                i3 i32 = (i3)this.r;
                d5.n.D(object0);
                EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                return H.a;
            }
            case 4: {
                i30 = (i3)this.r;
                d5.n.D(object0);
            label_53:
                this.r = null;
                this.w = 5;
                object2 = ((u0)object0).N(((g3)i30).b, ((g3)i30).c, ((g3)i30).d, this);
                if(object2 == a0) {
                    return a0;
                }
                goto label_61;
            }
            case 5: {
                i3 i33 = (i3)this.r;
                d5.n.D(object0);
                object2 = ((p)object0).a;
            label_61:
                if(!(object2 instanceof o)) {
                    this.r = null;
                    this.w = 6;
                    if(b0.l(PlaylistId.DRAWER, this) == a0) {
                        return a0;
                    }
                    EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                    return H.a;
                }
                return H.a;
            }
            case 6: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        i3 i34 = (i3)this.r;
        d5.n.D(object0);
        EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
        return H.a;
    }
}

